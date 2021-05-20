/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.util.Date;




public class HomeForm extends Form {

    Form current;
    /*Garder traÃ§e de la Form en cours pour la passer en paramÃ¨tres 
    aux interfaces suivantes pour pouvoir y revenir plus tard en utilisant
    la mÃ©thode showBack*/
    
    public HomeForm() {
        current = this; //RÃ©cupÃ©ration de l'interface(Form) en cours
        setTitle("Gestion des categories et des événements");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddCategorie = new Button("Ajouter categorie");
        Button btnListCategorie = new Button("Liste des categories");
          Button btnAddEvent = new Button("Ajouter un événement");
        Button btnListEvent = new Button("Liste des évenements");
        

        btnAddCategorie.addActionListener(e -> new AddCategorieGUI(current).show());
       btnListCategorie.addActionListener(e -> new ListCategorieGui(current).show());
          // btnAddEvent.addActionListener(e -> new AddEventGUI(current).show());
                 btnListEvent.addActionListener(e -> new ListEventGui(current).show());
                 

   
        addAll(btnAddCategorie, btnListCategorie,btnAddEvent , btnListEvent);

 
        
        
    }  
     

}

    