
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.mycompany.gui.ProfileForm;
import com.mycompany.utils.Statics;
import java.util.Map;


public class ServiceUsers {
    
      public static ServiceUsers instance=null;
    public static boolean resulatok=true;
    private ConnectionRequest req;
     String json;
    
    
    public static ServiceUsers getInstance()
    { if(instance == null)
            instance = new ServiceUsers();
            return instance;
        
    }
    
    
    public ServiceUsers()
    {
        req=new ConnectionRequest();
        
    }
    
    public void signup(TextField nom,TextField prenom,TextField email,TextField password,TextField tel,TextField Confirmpassword,Resources res)
    {
        String url=Statics.BASE_URL+"/signupJson?nom="+nom.getText().toString()+"&prenom="+prenom.getText().toString()+"&email="+email.getText().toString()+"&password="+password.getText().toString()+"&tel="+tel.getText().toString();
        req.setUrl(url);
   if(nom.getText().equals("") && prenom.getText().equals("") && email.getText().equals("") && password.getText().equals("") && tel.getText().equals("")&& Confirmpassword.getText() != password.getText()) 
   {
       Dialog.show("errue", "veiller remplir les champs", "ok",null);
   }
   req.addResponseCodeListener((e)-> {
       byte[]data=(byte[]) e.getMetaData();
       String responseData= new String(data);
       System.out.println("data==" +responseData);
       
   });
        NetworkManager.getInstance().addToQueueAndWait(req);
    }
    
    
    public void signein(TextField email,TextField password,Resources res)
    {
        String url= Statics.BASE_URL+"/signinJson?email="+email.getText()+"&password="+password.getText();
        req.setUrl(url);
        req.addResponseListener((e)->{
           
            JSONParser j=new JSONParser();
            String json=new String(req.getResponseData()) + "";
            try {
            if(json.equals("user not found") || json.equals("password invalid") )
            {
                Dialog.show("Echec d authentification", "Username or mdp erronée", "ok",null);
            }
            else 
            {
                System.out.println("data =="+json);
                Map<String,Object> user=j.parseJSON(new CharArrayReader(json.toCharArray()));
                if(user.size() >0)
                new ProfileForm(res).show();    
            }
               } catch (Exception ex) {
                   ex.printStackTrace();  
            }
        }
        );
                    NetworkManager.getInstance().addToQueueAndWait(req); 
    }
    

      public String  getPasswordEmail(String email,Resources res)
    {
        String url= Statics.BASE_URL+"/getPasswordByEmail?email="+email;
        req.setUrl(url);
        req.addResponseListener((e)->{

            JSONParser j=new JSONParser();
             json=new String(req.getResponseData()) + "";
            try {
                System.out.println("data =="+json);
                Map<String,Object> password=j.parseJSON(new CharArrayReader(json.toCharArray()));
               } catch (Exception ex) {
                   ex.printStackTrace();  
            }
        }
      
        );
                    NetworkManager.getInstance().addToQueueAndWait(req); 
                  return json;
    }
    
}
