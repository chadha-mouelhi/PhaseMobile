/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Form;
import com.mycompany.myapp.entities.Reclamation;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.mycompany.myapp.services.serviceReclamation;
/**
 *
 * @author Mariem
 */

public class UpdateRec  extends Form{
    Form previous;
   
    public UpdateRec(Form previous ,Reclamation c){
         
 setTitle("Modifier réclamation");
   
            getTitleArea().setUIID("container");
            getContentPane().setScrollVisible(false);
            
         
        
TextField text= new TextField(c.getText());
        TextField object = new TextField(c.getObject());   
               // TextField screenshot = new TextField(c.getScreenshot(), "screenshot");  
                               // ComboBox type = new ComboBox(c.getType());            

                // c.setType(type.getSelectedItem().toString());

         ComboBox type = new ComboBox("Contenu","service technique");

   
        Button btnValider = new Button("Modifier");

       btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                c.setObject(object.getText());
             
                 c.setText(text.getText());
                // c.setScreenshot(screenshot.getText());
                 c.setType(type.getSelectedItem().toString());

             
                 if( serviceReclamation.getInstance().modifierReclamation(c)) {
                      Dialog.show("Success","Modification avec succée",new Command("OK"));
                 
                      refreshTheme();
                 }
                 
                 else
                     Dialog.show("ERROR", "Server error", new Command("OK"));
            }
        });


        addAll(object,text,btnValider,type);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
}

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 


