
package com.mycompany.myapp.entities;

import java.util.Date;


public class Events {
   
    private int idEvent;

    private String nomEvent;

    
    private Date dateDeb;

    private Date dateFin;

    
    private int nbrPlace;

    
    private int id;

    
    private String image;

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNomEvent() {
        return nomEvent;
    }

    public void setNomEvent(String nomEvent) {
        this.nomEvent = nomEvent;
    }

    public Date getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(Date dateDeb) {
        this.dateDeb = dateDeb;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Events() {
    }

    public Events(int idEvent, String nomEvent, Date dateDeb, Date dateFin, int nbrPlace, int id, String image) {
        this.idEvent = idEvent;
        this.nomEvent = nomEvent;
        this.dateDeb = dateDeb;
        this.dateFin = dateFin;
        this.nbrPlace = nbrPlace;
        this.id = id;
        this.image = image;
    }

  
    


    
}
