package com.cvmendes.java.appeventcode.model.entities;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evenement {
    private long id;
    private long organisateurId;
    private String nom;
    private Timestamp dateEvenement;
    private Organisateur organisateur;
    private long nbBilletsMax;
    private long nbBilletsVendus;
    private long nbBilletsPanier;
    private List<Organisateur> list = new ArrayList<>();


    public Evenement() {
    }

    public long getNbBilletsMax() {
        return nbBilletsMax;
    }

    public void setNbBilletsMax(long nbBilletsMax) {
        this.nbBilletsMax = nbBilletsMax;
    }

    public long getNbBilletsVendus() {
        return nbBilletsVendus;
    }

    public void setNbBilletsVendus(long nbBilletsVendus) {
        this.nbBilletsVendus = nbBilletsVendus;
    }

    public long getNbBilletsPanier() {
        return nbBilletsPanier;
    }

    public void setNbBilletsPanier(long nbBilletsPanier) {
        this.nbBilletsPanier = nbBilletsPanier;
    }

    public List<Organisateur> getList() {
        return list;
    }

    public void setList(List<Organisateur> list) {
        this.list = list;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(long organisateurId) {
        this.organisateurId = organisateurId;
    }

    public Organisateur getOrganisateur() {
        return organisateur;
    }

    public void setOrganisateur(Organisateur organisateur) {
        this.organisateur = organisateur;
    }

    public String getNoml() {
        return nom;
    }

    public void setNom(String noml) {
        this.nom = noml;
    }

    public Timestamp getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Timestamp dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "organisateurId=" + organisateurId +
                ", nom='" + nom + '\'' +
                ", dateEvenement=" + dateEvenement +
                ", nbBilletsMax=" + nbBilletsMax +
                ", nbBilletsVendus=" + nbBilletsVendus +
                ", nbBilletsPanier=" + nbBilletsPanier +
                '}';
    }
}
