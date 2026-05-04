package com.example.pimp_my_deck;

public class Carte {


    private int id_carte;
    private int id_collection;
    private  int id_rarete;
    private String nom;
    private int numero;
    private double prix;
    private String description;
    private String img_path;
    private int active;

    public int getId_carte() {
        return id_carte;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public int getId_collection() {
        return id_collection;
    }

    public void setId_collection(int id_collection) {
        this.id_collection = id_collection;
    }

    public int getId_rarete() {
        return id_rarete;
    }

    public void setId_rarete(int id_rarete) {
        this.id_rarete = id_rarete;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }






}
