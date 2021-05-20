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
public class Message {
    private int id_message;
    private int id_user;
    private Date date_creation;
    private String text;
    private String reponse;
    private String record;

    public Message(int id_message, int id_user, Date date_creation, String message, String reponse, String record) {
        this.id_message = id_message;
        this.id_user = id_user;
        this.date_creation = date_creation;
        this.text = message;
        this.reponse = reponse;
        this.record = record;
    }

    public Message() {
    }
    
 public Message(String text) {
 this.text = text;

    }
 
  public Message(int id_message, String text) {
        this.id_message = id_message;
      this.text = text;

    }
    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
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

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    @Override
    public String toString() {
        return "Message{" + "id_message=" + id_message + ", id_user=" + id_user + ", date_creation=" + date_creation + ", message=" + text + ", reponse=" + reponse + ", record=" + record + '}';
    }
    
    
    
}
