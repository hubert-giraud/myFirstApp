package com.haluberlu.myfirstapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Partie implements Parcelable {

    private int id;
    private String nomPartie;
    private String nomJ1;
    private int ptsJ1;
    private String nomJ2;
    private int ptsJ2;

    public static final Parcelable.Creator<Partie> CREATOR = new Parcelable.Creator<Partie>() {

        @Override
        public Partie createFromParcel(Parcel source) {
            return new Partie(source);
        }

        @Override
        public Partie[] newArray(int size) {
            return new Partie[size];
        }
    };

    public Partie() {
    }

    public Partie(Parcel in) {
        nomPartie = in.readString();
        nomJ1 = in.readString();
        ptsJ1 = in.readInt();
        nomJ2 = in.readString();
        ptsJ2 = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nomPartie);
        dest.writeString(nomJ1);
        dest.writeInt(ptsJ1);
        dest.writeString(nomJ2);
        dest.writeInt(ptsJ2);
    }
}
