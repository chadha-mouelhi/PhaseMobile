/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Reclamation {
    private int idReclamation;
    private int id_user;
    private Date date_creation;
    private Date date_validation;
    private String statut;
    private String type; 
    private String screenshot;
    private String object;
    private String text; 

    public Reclamation() {
    }

    public int getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_validation() {
        return date_validation;
    }

    public void setDate_validation(Date date_validation) {
        this.date_validation = date_validation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Reclamation(int id_reclamation, int id_user, Date date_creation, Date date_validation, String statut, String type, String screenshot, String object, String text) {
        this.idReclamation = id_reclamation;
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.date_validation = date_validation;
        this.statut = statut;
        this.type = type;
        this.screenshot = screenshot;
        this.object = object;
        this.text = text;
    }

    public Reclamation(String object, String text,String type){

        this.object = object;
        this.text = text;
        this.type = type;

    }
        public Reclamation(String object, String text,String type, String screenshot){

        this.object = object;
        this.text = text;
        this.type = type;
        this.screenshot=screenshot;

    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + idReclamation + ", id_user=" + id_user + ", date_creation=" + date_creation + ", date_validation=" + date_validation + ", statut=" + statut + ", type=" + type + ", screenshot=" + screenshot + ", object=" + object + ", text=" + text + '}';
    }
    
    

}
