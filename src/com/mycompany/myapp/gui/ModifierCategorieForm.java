package com.mycompany.myapp.gui;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import com.mycompany.myapp.entities.Categorie;
import com.mycompany.myapp.services.CategorieService;

public class ModifierCategorieForm  extends Form{
    Form previous;
   
    public ModifierCategorieForm(Form previous ,Categorie c){
         
         setTitle(" Modifier Categorie");
        setLayout(BoxLayout.y());
        TextField nomcategorie= new TextField(c.getNomcategorie(), "nomcategorie");
        TextField description = new TextField(c.getDescription(), "Description");
         
        Button btnValider = new Button("Modifier");
           btnValider.addPointerPressedListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent l) {
                 c.setNomcategorie(nomcategorie.getText());
              
                 c.setDescription(description.getText());
              
                 if( CategorieService.getInstance().modifierCategorie(c)) {
                      Dialog.show("Success","Modification avec succée",new Command("OK"));
                  
                      refreshTheme();
                 }
                 
                 else
                     Dialog.show("ERROR", "Server error", new Command("OK"));
             }
         });
                
                addAll(nomcategorie,description,btnValider);
                
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new ListCategorieGui(previous).show());

            }
    
                
    }