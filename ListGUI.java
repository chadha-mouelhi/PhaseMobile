/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.serviceReclamation;

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
import java.util.List;



/**
 *
 * @author Mariem
 */
public class ListGUI extends Form{
 Resources theme;
   Form previous;
   Form current;
   
  
    public ListGUI(Form previous) {
    
        setTitle("Liste  réclamations");
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, m-> previous.showBack());
        setLayout(BoxLayout.y());
        List <Reclamation> reclamations= serviceReclamation.getInstance().getAllReclamations();
    
        for (int i = 0; i < reclamations.size(); i++) 
        {
          Label l = new Label("Reclamation N°"+i);
          addAll(l);
          Reclamation get = reclamations.get(i);
          add(ajouterRec(get));

        }
                }   
    
     private Container ajouterRec(Reclamation e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
         
            Label id = new Label ("id:"+e.getIdReclamation());
            id.setTextPosition(RIGHT);  
            Label date_creation = new Label ("date:"+e.getDate_creation());
            date_creation.setTextPosition(RIGHT);  
            
            Label objet = new Label ("objet:"+e.getObject());
            objet.setTextPosition(RIGHT);
            
            Label statut = new Label ("statut:"+e.getStatut());
            statut.setTextPosition(RIGHT);
            Label type = new Label ("type:"+e.getType());
            type.setTextPosition(RIGHT);
         
            Label text = new Label ("text:"+e.getText());
            text.setTextPosition(RIGHT);
            
            Label screenshot = new Label ("screenshot:"+e.getScreenshot());
            screenshot.setTextPosition(RIGHT);
            
            Button btnSupprimer = new Button("");   
            Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
            supprimerStyle.setFgColor(0xf21f1f);
            FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
            btnSupprimer.setIcon(supprimerImage);
            
              Button btnModifier = new Button("");
              Style modifierStyle=new Style(btnModifier.getUnselectedStyle());
              modifierStyle.setFgColor(0xf7ad02);
              FontImage modifierImage=FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
    
             btnModifier.setIcon(modifierImage);
             
             Button details = new Button("");
             details.addPointerPressedListener(l-> 
             {
                        new DetailsRec(previous).show();

             });
/*
           
                                    LocalDate d1 = LocalDate.parse(java.time.LocalDate.now().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                                    LocalDate d2 = LocalDate.parse(e.getDate_creation().toString(), DateTimeFormatter.ISO_LOCAL_DATE);
                                    Duration diff = Duration.between(d2.atStartOfDay(), d1.atStartOfDay());
                                    long diffDays = diff.toDays();

                                    if (diffDays > 0.1) {
                                        btnModifier.setEnabled(false);
                                        btnSuoprimer.setEnabled(false);
                                            e.setStatut("en cours");
                                           // sr.UpdateRecStatut(Reclamation);
                                        
                                    } else {
                                        if (e.getStatut().equals("validée")) {
 
                                            btnSupprimer.setEnabled(false);
             
                                            btnModifier.setEnabled(false);
                                        } else {
                                            btnSupprimer.setEnabled(true);
             
                                            btnModifier.setEnabled(true);                                      
                                        }
                                    }
           
           */
           
           
            if(e.getStatut().equals("en attente"))
            {btnSupprimer.setEnabled(true);
             btnModifier.setEnabled(true);
            }
             else {
             btnSupprimer.setEnabled(false);
             btnModifier.setEnabled(false);
            }             
            btnSupprimer.addPointerPressedListener(l-> 
            {

            if(serviceReclamation.getInstance().deleteReclamation(e.getIdReclamation())){
            new ListGUI(previous).show();
            }
         
            });
              

              btnModifier.addPointerPressedListener(l-> 
             {
               new UpdateRec(previous, e).show();
             });
            

          getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, m-> previous.showBack());
                    
          detaills.add(id);

          detaills.add(date_creation);
          detaills.add(statut);
          detaills.add(type);
          detaills.add(objet);
          detaills.add(text);
          detaills.add(screenshot);                           
          detaills.add(btnSupprimer);
          detaills.add(btnModifier);

          holder.add(detaills);
            
          return (holder);
          
   /* setTitle("List tasks");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(serviceReclamation.getInstance().getAllReclamations().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
  */
            
     }
     
              
              }
    

