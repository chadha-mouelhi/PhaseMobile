/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.WebBrowser;
import com.codename1.io.Log;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
//import com.mycompany.entities.Categorie;
import com.mycompany.entities.Test;
//import com.mycompany.services.CategorieService;
import com.mycompany.services.TestService;

import java.util.List;

/**
 *
 * @author nader
 */
public class ListTestGui extends Form{
    
     Form previous;
   Form current;
    public ListTestGui(Form previous) {
        setTitle("Liste  Test");
        setLayout(BoxLayout.y());
        
        
        List <Test> t = TestService.getInstance().getAllTest();
    
        for (int i = 0; i < t.size(); i++) {
            Label l = new Label("TEST N°"+i);
           
          addAll(l);
           
     
            Test get = t.get(i);
            add(addTest(get));
          
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        //-----------------------------------
        Container list = new Container();
         getToolbar().addSearchCommand(e -> {
        String text = (String)e.getSource();
          if(text == null || text.length() == 0) {
        // clear search
        for(Component cmp : list) {
            cmp.setHidden(false);
            cmp.setVisible(true);
            }
        getContentPane().animateLayout(150);
         } else {
        text = text.toLowerCase();
        for(Component cmp : list) {
            Button mb = (Button)cmp;
            String line1 = mb.getText();
            boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1;
            mb.setHidden(!show);
            mb.setVisible(show);
        }
        getContentPane().animateLayout(150);
    }
}, 4);
//------------------------------------------------
        

     
    }   
    
    Command back = new Command("Back") {
    @Override
    public void actionPerformed(ActionEvent evt) {
        showBack();
    }
};
    
     private Container addTest(Test e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
          
        
     
         
          Label id=new Label ("id="+e.getIdTest());
            id.setTextPosition(RIGHT);
           Label categ=new Label ("Categorie:"+e.getCategories());
          categ.setTextPosition(RIGHT);
              Label des =new Label ("Test:"+e.getTest());
              des.setTextPosition(RIGHT);
              Label duree =new Label ("Duree:"+e.getDuree());
              duree.setTextPosition(RIGHT);
              
              String str=("----------------------------------");

//    Button btnSupprimer = new Button("");
//     Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
//     supprimerStyle.setFgColor(0xf21f1f);
//         FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
//     btnSupprimer.setIcon(supprimerImage);
//             btnSupprimer.addPointerPressedListener(l-> {
//                 
//         
////         if(serviceTest.getInstance().deleteCategorie(e.getIdTest())){
////             new ListCategorieGui(previous).show();
////             
////         }
//         
//             });
              Button btnModifier = new Button("");
     Style modifierStyle=new Style(btnModifier.getUnselectedStyle());
     modifierStyle.setFgColor(0xf7ad02);
         FontImage modifierImage=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
     btnModifier.setIcon(modifierImage);
          
           
            btnModifier.addPointerPressedListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent l) {
                  
                  
                  
                  //new ModifierCategorieForm(previous,e).show();
                  BrowserComponent browserComponent = new BrowserComponent();
                  browserComponent.addWebEventListener(BrowserComponent.onLoad, evt -> {
                      Log.p("onLoad start", Log.INFO);
                      Log.p(browserComponent.executeAndReturnString("document.documentElement.outerHTML"), Log.INFO);
                      Log.p("onLoad end", Log.INFO);
                  });
                  
                  Form form = new Form("Browser Contents Test", new BorderLayout());
                  
//                  Button btnModifier1 = new Button("");
//                  Style modifierStyle1=new Style(btnModifier1.getUnselectedStyle());
//                  modifierStyle1.setFgColor(0xf7ad02);
//                  FontImage modifierImage1=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle1);
//                  btnModifier1.setIcon(modifierImage1);
//                  
                  
                  // btnModifier1.addActionListener((ActionEvent l)->{ new HomeForm(previous,e).show(); });
//                  btnModifier1.addActionListener(e -> new ListTestGui(current).show());
                  form.getToolbar().setBackCommand(back);
                  form.setBackCommand(back);
                  form.show();
                  form.add(BorderLayout.CENTER, browserComponent);
//                  Button btnModifier1 = new Button("");
//                  Style modifierStyle1=new Style(btnModifier1.getUnselectedStyle());
//                  modifierStyle1.setFgColor(0xf7ad02);
//                  FontImage modifierImage1=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle1);
//                  btnModifier1.setIcon(modifierImage1);
//                  
//                  
//                  // btnModifier1.addActionListener((ActionEvent l)->{ new HomeForm(previous,e).show(); });
//                  btnModifier1.addActionListener(e -> new ListTestGui(current).show());
                  form.show();
                  
                  browserComponent.setURL(e.getTest());
                  
                    try {
                       
                        if( TestService.getInstance().addTester(e))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
//         getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, m-> previous.showBack());
//         setLayout(BoxLayout.y());
              }
              
              
          }); 
           detaills.add(id);
          detaills.add(categ);
        
            detaills.add(des);
            detaills.add(duree);
                                  
//        detaills.add(btnSupprimer);
        detaills.add(btnModifier);
        detaills.add(str);
        
       
       
          
        
          
          holder.add(detaills);
          return (holder);
          
     }
    
}
