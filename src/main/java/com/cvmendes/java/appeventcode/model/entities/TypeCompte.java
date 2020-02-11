package com.cvmendes.java.appeventcode.model.entities;

public class TypeCompte {
    private long id;
    private String nom;

    public TypeCompte() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "TypeCompte{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
