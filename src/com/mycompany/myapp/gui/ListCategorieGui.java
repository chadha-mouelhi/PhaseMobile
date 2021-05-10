/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;



import com.mycompany.myapp.services.CategorieService;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;


import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
;

import java.util.List;


import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Categorie;



import java.util.List;



public class ListCategorieGui extends Form{
 
   Form previous;
   Form current;
    public ListCategorieGui(Form previous) {
        setTitle("Liste  Categorie");
        setLayout(BoxLayout.y());
        
        List <Categorie> categories = CategorieService.getInstance().getAllCategories();
    
        for (int i = 0; i < categories.size(); i++) {
            Label l = new Label("Categorie N°"+i);
           
          addAll(l);
           
     
            Categorie get = categories.get(i);
            add(addCategorie(get));
          
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());    

     
    }   
    
     private Container addCategorie(Categorie e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
          
        
     
         
          Label id=new Label ("id:"+e.getId());
            id.setTextPosition(RIGHT);
           Label categ=new Label ("nomcategorie:"+e.getNomcategorie());
          categ.setTextPosition(RIGHT);
              Label des =new Label ("description:"+e.getDescription());
              des.setTextPosition(RIGHT);

    Button btnSupprimer = new Button("");
     Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
     supprimerStyle.setFgColor(0xf21f1f);
         FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
     btnSupprimer.setIcon(supprimerImage);
             btnSupprimer.addPointerPressedListener(l-> {
                 
         
         if(CategorieService.getInstance().deleteCategorie(e.getId())){
             new ListCategorieGui(previous).show();
             
         }
         
             });
              Button btnModifier = new Button("");
     Style modifierStyle=new Style(btnModifier.getUnselectedStyle());
     modifierStyle.setFgColor(0xf7ad02);
         FontImage modifierImage=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
     btnModifier.setIcon(modifierImage);
          
           
            btnModifier.addPointerPressedListener(l->{     
      
           //  new ModifierCategorieForm(previous,e).show();


        
     }); 
           detaills.add(id);
          detaills.add(categ);
        
            detaills.add(des);
                                  
        detaills.add(btnSupprimer);
        detaills.add(btnModifier);
       
       
          
        
          
          holder.add(detaills);
          return (holder);
          
     }
}
   


     

 