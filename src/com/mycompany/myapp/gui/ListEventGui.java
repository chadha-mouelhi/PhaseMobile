
package com.mycompany.myapp.gui;
import com.codename1.components.ShareButton;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Display;
import com.codename1.ui.TextArea;
import com.codename1.ui.spinner.Picker;
import com.mycompany.myapp.entities.Events;
import com.mycompany.myapp.services.EventService;
import java.util.List;
public class ListEventGui extends Form {

 
   Form previous;
   Form current;
    public ListEventGui(Form previous) {
        setTitle("Liste  des  Evenements");
        setLayout(BoxLayout.y());
        
        List <Events> events = EventService.getInstance().getAllEvents();
    
        for (int i = 0; i < events.size(); i++) {
            Label l = new Label("Evenement N°"+i);
           
          addAll(l);
           
     
            Events get = events.get(i);
            add(addEvent(get));
          
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());    

     
    }   
    
     private Container addEvent(Events e){
          Container holder = new Container(BoxLayout.x());
          Container detaills = new Container(BoxLayout.y());
          
        
     
         
          Label idEvent=new Label ("idEvents:"+e.getIdEvent());
            idEvent.setTextPosition(RIGHT);
          Label nomEvent=new Label ("nomEvent:"+e.getNomEvent());
          
            Label nbrplace =new Label ("nbrplace:"+e.getNbrPlace());
             //  Label image =new Label ("image:"+e.getNbrPlace());
               Label dateDeb=new Label("dateDeb:"+e.getDateDeb());
              //  Label dateFin=new Label("dateDeb:"+e.getDateFin());
      
                  
          Label id=new Label ("id:"+e.getId());
       //    Picker dateDeb  = new Picker("dateDeb:"+e.getDateDeb());
   //   //  dateDeb.getDate();
;
        Button btnSupprimer = new Button("");
     Style supprimerStyle=new Style(btnSupprimer.getUnselectedStyle());
     supprimerStyle.setFgColor(0xf21f1f);
         FontImage supprimerImage=FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
     btnSupprimer.setIcon(supprimerImage);
             btnSupprimer.addPointerPressedListener(l-> {
                 
         
         if(EventService.getInstance().deleteEvent(e.getIdEvent())){
             new ListEventGui(previous).show();
             
         }
         
           
        
     }); 
             
             
             final ShareButton share = new ShareButton();
      final TextArea t = new TextArea("");
 
detaills.addComponent( t);
share.setTextToShare(t.getText());
    share.addPointerPressedListener(l-> {
                 
         
        share.setTextToShare(t.getText());
      //   Display.getInstance().execute("https://www.facebook.com/sharer/sharer.php?u=" + Util.encodeUrl(e));
             
    });  
             
             
           detaills.add(idEvent);
            detaills.add(nomEvent);
            detaills.add(nbrplace);
            detaills.add(share);
            //  detaills.add(dateDeb);
             //     detaills.add(dateFin);
               //    detaills.add(dateFin);
                 //   detaills.add(id);
             
              
                     
        
      //  detaills.add(g)
         
                                  
        detaills.add(btnSupprimer);
     
       
       
          
        
          
          holder.add(detaills);
          return (holder);
          
     }
}
   