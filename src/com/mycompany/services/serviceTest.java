/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import com.mycompany.entities.Test;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author nader
 */


public class serviceTest {

    
    
    
    
    public static serviceTest instance = null;
    
    //initillisation connection request 
    private ConnectionRequest req ;
    
    public static serviceTest getInstance()
    {
        if(instance == null)
            instance = new serviceTest();
        
    
        return instance;
    }
    
    
    
    public serviceTest() {
    
        req = new ConnectionRequest();
    }
    
    public void ajouterTest(Test test)
    {
        String  url=Statics.BASE_URL+"/addTest?categories="+test.getCategories()+"&test="+test.getTest()+
                "&duree="+test.getDuree();
        req.setUrl(url);
        req.addResponseListener((e) -> {
            String str = new String(req.getResponseData());
            System.out.println("data == "+str);
        
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        
    
    }
    
    //affichage
    
    public ArrayList<Test>affichageTest()
    {
        ArrayList<Test> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/displayTest";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            private String DateConverter;
            @Override
            public void actionPerformed(NetworkEvent evt)
            {
                //throw new UnsupportedOperationException("not supported yet");
                JSONParser json;
                json = new JSONParser();
                
                try{
                    Map<String,Object>mapTests = json.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    List<Map<String,Object>>listOfMaps = (List<Map<String,Object>>) mapTests.get("root");
                    
                    for(Map<String, Object> obj : listOfMaps)
                    {
                        Test t = new Test();
                        
                        float id = Float.parseFloat(obj.get("idTest").toString());
                        String categories = obj.get("categories").toString();
                        String test = obj.get("test").toString();
                        float duree = Float.parseFloat(obj.get("duree").toString());
                        String dateCreation = obj.get("dateCreation").toString();
                        
                        t.setCategories(categories);
                        t.setTest(test);
                        t.setDuree((int)duree);
                        
                        String DateSystem = obj.get("dateCreation").toString().substring(obj.get("dateCreation").toString().indexOf("timestamp")+10,obj.get("obj").toString().lastIndexOf("}"));
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue()*1000);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString =  formatter.format(currentTime);
                        t.setDateCreation(dateString);
                        
                        result.add(t);
                        
                    }
                
                }catch(Exception ex){ex.printStackTrace();}
            }
        
        });
     NetworkManager.getInstance().addToQueueAndWait(req);

     return result;       
        
    }
    
    
    public Test DetailTest(int id, Test test)
    {
        String url = Statics.BASE_URL+"/detailTest?"+id;
        req.setUrl(url);
        
        String str = new String(req.getResponseData());
        req.addResponseListener(((evt)-> {
            
            
            JSONParser json =  new JSONParser();
            
            try{
                
                Map<String,Object>obj = json.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                test.setCategories(obj.get("categories").toString());
                test.setTest(obj.get("test").toString());
                test.setDuree(Integer.parseInt(obj.get("obj").toString())); 
                    
                
            }catch(IOException ex){System.out.println("error related to api :( "+ex.getMessage() );}
            System.out.println("data =="+str);
            
        }));
        
     NetworkManager.getInstance().addToQueueAndWait(req);
     return test;
   
    }
    
    
    
    
    
      
    
    
}
