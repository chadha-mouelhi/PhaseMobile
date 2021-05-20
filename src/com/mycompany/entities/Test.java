/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;
import java.util.*;
import java.util.Date;

/**
 *
 * @author nader
 */
public class Test {
    
    private int idTest;
    private String categories;
    private String test;
    private int duree;
    private String dateCreation;

    public Test() {
    }

    public Test(String categories, String test, int duree) {
        this.categories = categories;
        this.test = test;
        this.duree = duree;
    }
    
    
    
    

    public Test(int idTest, String categories, String test, int duree, String dateCreation) {
        this.idTest = idTest;
        this.categories = categories;
        this.test = test;
        this.duree = duree;
        this.dateCreation = dateCreation;
    }

    public Test(String categories, String test, int duree, String dateCreation) {
        this.categories = categories;
        this.test = test;
        this.duree = duree;
        this.dateCreation = dateCreation;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
    
    
    
    
     
     
    
    
    
            
    
}
