package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.ServiceUsers;
import com.sun.mail.smtp.SMTPTransport;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Account activation UI
 *
 * @author Hamed Ala
 */
public class ActivateForm extends BaseForm {
    TextField email;

    public ActivateForm(Resources res) {
        super(new BorderLayout());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        tb.setUIID("IMGLogin");
        getTitleArea().setUIID("Container");
        Form previous = Display.getInstance().getCurrent();
        tb.setBackCommand("", e -> previous.showBack());
      setUIID("Activate");
        
        add(BorderLayout.NORTH, 
                BoxLayout.encloseY(
                        new Label(res.getImage("oublie.jpg"),"CenterLabel"),
                        new Label("Awsome Thanks!", "LogoLabel")
                )
        );
        
      email=new TextField("","Saisir votre email",20,TextField.ANY);
      email.setSingleLineTextArea(false);
      Button Valider=new Button("Valider");
      Label haveAnaccount=new Label("retour se connceter");
      
            Button signein=new Button("Renouvler Votre mot de passe ");
            signein.addActionListener((e-> previous.showBack()));
            signein.setUIID("CenterLink");
            Container content=BoxLayout.encloseY(
                    new FloatingHint(email),createLineSeparator(),Valider,FlowLayout.encloseCenter(haveAnaccount,signein));

      content.setScrollableY(true);
      add(BorderLayout.CENTER,content);
      Valider.requestFocus();
      Valider.addActionListener(e->{         
          InfiniteProgress ip=new InfiniteProgress();
          final Dialog ipDialog=ip.showInfiniteBlocking();        
          sendMail(res);
          ipDialog.dispose();
          Dialog.show("Mot de passe", "Nous avons envoyée le mdp a votre email,verifier votre boite", new Command("ok"));         
          new SignInForm(res).show();
          refreshTheme();
      });
    }
    
    public void sendMail(Resources res)
    {
    	try {
            Properties props = new Properties();
            	props.put("mail.transport.protocol", "smtp"); //SMTP Host

		props.put("mail.smtps.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtps.auth", "true"); //enable authentication

            Session session=Session.getInstance(props,null);
            MimeMessage msg=new MimeMessage(session);
            msg.setFrom(new InternetAddress("Reintialisation de mot de passe <monEmail@domaine.com>"));
            msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
            msg.setSubject("Reset your password");
            msg.setSentDate(new Date(System.currentTimeMillis()));
            String mp=ServiceUsers.getInstance().getPasswordEmail(email.getText().toString(), res);
            String text="Bienvenue sur notre application,Taper ce mot de passe pour ce connecter"+mp+"dans le champs requis et appuier sur valider";
            msg.setText(text);
            SMTPTransport st=(SMTPTransport)session.getTransport("smtps");
            st.connect("smtp.gmail.com",465,"inovvat@gmail.com","Mary12111998");
            st.sendMessage(msg, msg.getAllRecipients());
            System.out.println("servez reponse" +st.getLastServerResponse());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
