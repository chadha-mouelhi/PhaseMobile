/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Message;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.serviceMessage;
import com.mycompany.myapp.services.serviceReclamation;
import java.util.List;

/**
 *
 * @author Mariem
 */
public class ListGuiMsg extends Form{
     Resources theme;
   Form previous;
   Form current;
            public ListGuiMsg(Form previous) {
                  setTitle("Liste  messages");
        setLayout(BoxLayout.y());
                getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, m-> previous.showBack());

        List <Message> messages= serviceMessage.getInstance().getAllMessages();
    
        for (int i = 0; i < messages.size(); i++) {
            Label l = new Label("Message N°"+i);
             addAll(l);
            Message get = messages.get(i);
            add(ajouterMsg(get));   
        }
 
            }
            
          private Container ajouterMsg(Message e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
         
            Label text = new Label ("text:"+e.getText());
            text.setTextPosition(RIGHT);
            Label reponse = new Label ("reponse:"+e.getReponse());
            reponse.setTextPosition(RIGHT);
            
    Button btnSupprimer = new Button("");
     Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
     supprimerStyle.setFgColor(0xf21f1f);
         FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
     btnSupprimer.setIcon(supprimerImage);
             btnSupprimer.addPointerPressedListener(l-> {

         if(serviceMessage.getInstance().deleteMessage(e.getId_message())){
             new ListGuiMsg(previous).show();    
         }
         
             });
 getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , m-> previous.showBack()); // Revenir vers l'interface précédente
      
          detaills.add(text);
          detaills.add(reponse);        
          detaills.add(btnSupprimer);
          holder.add(detaills);
          
          return (holder);
     }
       
}
