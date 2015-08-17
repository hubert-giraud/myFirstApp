package com.haluberlu.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by haluberlu on 05/08/2015.
 */
public class Partie implements Parcelable {

    private int id;
    private String nomPartie;
    private int nbJoueurs;
    private String nomJ1;
    private int ptsJ1;
    private String nomJ2;
    private int ptsJ2;
    private String nomJ3;
    private int ptsJ3;
    private String nomJ4;
    private int ptsJ4;
    private String date_creation;

    public Partie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }

    public String getNomJ1() {
        return nomJ1;
    }

    public void setNomJ1(String nomJ1) {
        this.nomJ1 = nomJ1;
    }

    public int getPtsJ1() {
        return ptsJ1;
    }

    public void setPtsJ1(int ptsJ1) {
        this.ptsJ1 = ptsJ1;
    }

    public String getNomJ2() {
        return nomJ2;
    }

    public void setNomJ2(String nomJ2) {
        this.nomJ2 = nomJ2;
    }

    public int getPtsJ2() {
        return ptsJ2;
    }

    public void setPtsJ2(int ptsJ2) {
        this.ptsJ2 = ptsJ2;
    }

    public String getNomJ3() {
        return nomJ3;
    }

    public void setNomJ3(String nomJ3) {
        this.nomJ3 = nomJ3;
    }

    public int getPtsJ3() {
        return ptsJ3;
    }

    public void setPtsJ3(int ptsJ3) {
        this.ptsJ3 = ptsJ3;
    }

    public String getNomJ4() {
        return nomJ4;
    }

    public void setNomJ4(String nomJ4) {
        this.nomJ4 = nomJ4;
    }

    public int getPtsJ4() {
        return ptsJ4;
    }

    public void setPtsJ4(int ptsJ4) {
        this.ptsJ4 = ptsJ4;
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
        dest.writeString(nomPartie);
        dest.writeInt(nbJoueurs);
        dest.writeString(nomJ1);
        dest.writeInt(ptsJ1);
        dest.writeString(nomJ2);
        dest.writeInt(ptsJ2);
        dest.writeString(nomJ3);
        dest.writeInt(ptsJ3);
        dest.writeString(nomJ4);
        dest.writeInt(ptsJ4);
        dest.writeString(date_creation);
    }
}
