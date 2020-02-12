package com.cvmendes.java.appeventcode.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Organisateur {
    private long id;
    private long typeCompteId;
    private long parrainId;
    private String mail;
    private String password;
    private String parrainMail;
    private String typeCompte;
    private List<Evenement> listEvent = new ArrayList<>();
    Date dateDerniereConnexion = new Date();

    public Organisateur() {
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    public String getParrainMail() {
        return parrainMail;
    }

    public void setParrainMail(String parrainMail) {
        this.parrainMail = parrainMail;
    }

    public List<Evenement> getListEvent() {
        return listEvent;
    }

    public void setListEvent(List<Evenement> data) {
        this.listEvent = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTypeCompteId() {
        return typeCompteId;
    }

    public void setTypeCompteId(long typeCompteId) {
        this.typeCompteId = typeCompteId;
    }

    public long getParrainId() {
        return parrainId;
    }

    public void setParrainId(long parrainId) {
        this.parrainId = parrainId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateDerniereConnexion() {
        return dateDerniereConnexion;
    }

    @Override
    public String toString() {
        return "Organisateur{" +
                "id=" + id +
                ", typeCompteId=" + typeCompteId +
                ", parrainId=" + parrainId +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", parrainMail='" + parrainMail + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                ", data=" + listEvent +
                ", dateDerniereConnexion=" + dateDerniereConnexion +
                '}';
    }
}
