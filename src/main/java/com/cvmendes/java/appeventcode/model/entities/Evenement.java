package com.cvmendes.java.appeventcode.model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Evenement {
    private long id;
    private int organisateurId;
    private String nom;
    private Date dateEvenement;
    private Organisateur organisateur;
    private List<Organisateur> list = new ArrayList<>();


    public Evenement() {
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

    public int getOrganisateurId() {
        return organisateurId;
    }

    public void setOrganisateurId(List<Organisateur> organisateurId) {
        this.organisateurId = organisateurId.size();
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

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", organisateur=" + organisateur +
                '}';
    }
}
