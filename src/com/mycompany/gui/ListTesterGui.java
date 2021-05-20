/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
//import com.mycompany.entities.Categorie;
import com.mycompany.entities.Test;
import com.mycompany.entities.tester;
//import com.mycompany.services.CategorieService;
import com.mycompany.services.TestService;
import java.util.List;

/**
 *
 * @author nader
 */
public class ListTesterGui extends Form{
    
     Form previous;
   Form current;
    public ListTesterGui(Form previous) {
        setTitle("Liste  Test ");
        setLayout(BoxLayout.y());
        
        List <tester> t = TestService.getInstance().getAllTester();
    
        for (int i = 0; i < t.size(); i++) {
            Label l = new Label("TEST N°"+i);
           
          addAll(l);
           
     
            tester get = t.get(i);
            add(addTester(get));
          
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());    

     
    } 
    
       private Container addTester(tester e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
          
        
     
         
         // Label id=new Label ("id:"+e.getId());
          //  id.setTextPosition(RIGHT);
           Label categ=new Label ("formation:"+e.getFormation());
          categ.setTextPosition(RIGHT);
              Label des =new Label ("date:"+e.getDate());
              des.setTextPosition(RIGHT);
               Label note =new Label ("Note:"+e.getNote());
              note.setTextPosition(RIGHT);
              String str=("--------------------------------------------------");

//    Button btnSupprimer = new Button("");
//     Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
//     supprimerStyle.setFgColor(0xf21f1f);
//         FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
//     btnSupprimer.setIcon(supprimerImage);
//             btnSupprimer.addPointerPressedListener(l-> {
//                 
//         
//         if(CategorieService.getInstance().deleteCategorie(e.getId())){
//             new ListCategorieGui(previous).show();
//             
//         }
//         
//             });
//              Button btnModifier = new Button("");
//     Style modifierStyle=new Style(btnModifier.getUnselectedStyle());
//     modifierStyle.setFgColor(0xf7ad02);
//         FontImage modifierImage=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
//     btnModifier.setIcon(modifierImage);
//          
//           
//            btnModifier.addPointerPressedListener(l->{     
//     
//           // new ModifierCategorieForm(previous,e).show();
//
//
//        
//     }); 
          // detaills.add(id);
          detaills.add(categ);
        
            detaills.add(des);
            detaills.add(note);
            detaills.add(str);
                                  
        //detaills.add(btnSupprimer);
       // detaills.add(btnModifier);
       
       
          
        
          
          holder.add(detaills);
          return (holder);
          
     }
    
}
