package com.cvmendes.java.appeventcode.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String mail;
    private String password;
    private int nbBilletsAchetes;
    private List<Billet> list = new ArrayList<>();

    public int getNbBilletsAchetes() {
        return nbBilletsAchetes;
    }

    public void setBilletsAchetes(List<Billet> nbBilletsAchetes) {
        this.nbBilletsAchetes = list.size();
    }

    public List<Billet> getList() {
        return list;
    }

    public void setList(List<Billet> list) {
        this.list = list;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", nbBilletsAchetes=" + nbBilletsAchetes +
                ", list=" + list +
                '}';
    }
}
