/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Events;
import com.mycompany.myapp.utils.Statics;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.text.DateFormat;
//mport java.util.Date;


public class EventService {
     public ArrayList<Events> events;
    
    public static EventService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public EventService() {
         req = new ConnectionRequest();
    }

    public static EventService getInstance() {
        if (instance == null) {
            instance= new EventService();
        }
      return instance;
    }


    public ArrayList<Events> parseEvents(String jsonText){
       
        try {
            
            events=new ArrayList<>();
            
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du rÃ©sultat json

            /*
                On doit convertir notre rÃ©ponse texte en CharArray Ã  fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilitÃ© de new CharArrayReader(json.toCharArray())
            
            La mÃ©thode parse json retourne une MAP<String,Object> ou String est 
            la clÃ© principale de notre rÃ©sultat.
            Dans notre cas la clÃ© principale n'est pas dÃ©finie cela ne veux pas
            dire qu'elle est manquante mais plutÃ´t gardÃ©e Ã  la valeur par defaut
            qui est root.
            En fait c'est la clÃ© de l'objet qui englobe la totalitÃ© des objets 
                    c'est la clÃ© dÃ©finissant le tableau de tÃ¢ches.
            */
            Map<String,Object> eventsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
              /* Ici on rÃ©cupÃ¨re l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tÃ¢che.               
            
            Le format Json impose que l'objet soit dÃ©finit sous forme
            de clÃ© valeur avec la valeur elle mÃªme peut Ãªtre un objet Json.
            Pour cela on utilise la structure Map comme elle est la structure la
            plus adÃ©quate en Java pour stocker des couples Key/Value.
            
            Pour le cas d'un tableau (Json Array) contenant plusieurs objets
            sa valeur est une liste d'objets Json, donc une liste de Map
            */
            List<Map<String,Object>> list = (List<Map<String,Object>>)eventsListJson.get("root");
            
            //Parcourir la liste des tÃ¢ches Json
            for(Map<String,Object> obj : list){
                //CrÃ©ation des tÃ¢ches et rÃ©cupÃ©ration de leurs donnÃ©es
            
                Events t = new Events();
               float idEvent = Float.parseFloat(obj.get("idEvent").toString());
                t.setIdEvent((int)idEvent);
                float nbrPlace = Float.parseFloat(obj.get("nbrPlace").toString());
                t.setNbrPlace((int)nbrPlace);
                 
          //  t.setNomEvent(obj.get("nomevent").toString());
               t.setNomEvent(obj.get("nomEvent").toString());
             
            //   t.setDateDeb.(obj.get("dateDeb").toString());
                // t.setImage(obj.get("image").toString());
              //    t.setDateDeb(dateDeb);
                //    SimpleDateFormat format=new SimpleDateFormat("y-m-d");
                //    format.format(t.getDateDeb());
          
	//	String dateToStr = dateFormat.format(obj"dateDeb").toString());
                
		//System.out.println("Date is "+ dateToStr);
           

        
   
             
            
              
              
             
             
              
                
                //Ajouter la tÃ¢che extraite de la rÃ©ponse Json Ã  la liste
                events.add(t);
                
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu rÃ©cupÃ©rer une liste des tÃ¢ches Ã  partir
        de la base de donnÃ©es Ã  travers un service web
        
        */
        return events;
    }
    
    public ArrayList<Events> getAllEvents(){
        String url = Statics.BASE_URL+"/ev/liste/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEvents(new String(req.getResponseData()));
                req.removeResponseListener(this);
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events;
    }
   
    public boolean deleteEvent(int idEvent) {
        String url = Statics.BASE_URL + "/deleteEvent?idEvent="+idEvent;
        
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                         
                req.removeResponseListener(this); 
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
        return resultOK=true;
    }
    
     public boolean addEvent(Events t) {
        String url = Statics.BASE_URL + "/addEv?nomevent=" + t.getNomEvent()+ "&id=" + t.getId(); //crÃ©ation de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminÃ© de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle mÃ©thode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistrÃ© et donc Ã©xÃ©cutÃ© mÃªme si 
                la rÃ©ponse reÃ§ue correspond Ã  une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
