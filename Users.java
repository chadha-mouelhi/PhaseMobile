/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author Hamed Ala
 */
public class Users {

    private int id;
    private String nom;
    private String prenom;
    private String id_photo;
    private String email;
    private String password;


    public Users() {
    }

    public Users(String nom, String prenom, String id_photo, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.id_photo = id_photo;
        this.email = email;
        this.password = password;
        
    }

    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return id_photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.id_photo = photo;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }


}
