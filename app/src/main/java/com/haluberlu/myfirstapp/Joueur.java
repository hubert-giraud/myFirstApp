package com.haluberlu.myfirstapp;

import android.os.Parcel;

import java.util.Date;

/**
 * Created by haluberlu on 05/08/2015.
 */
public class Joueur implements Parcel {

    private int id;
    private String nom;
    private String date_creation;

    public Joueur(){}

    public Joueur(String n, String date) {
        this.nom = n;
        this.date_creation = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(date_creation);
    }
}
