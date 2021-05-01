/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author bhk
 */
public class Categorie {
private int id;
private String nomcategorie;
private String description;

    public Categorie() {
    }

    public Categorie(int id, String nomcategorie, String description) {
        this.id = id;
        this.nomcategorie = nomcategorie;
        this.description = description;
    }

    public Categorie(String nomcategorie, String description) {
        this.nomcategorie = nomcategorie;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    
    
    







}