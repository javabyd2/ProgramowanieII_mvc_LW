package com.sdabyd2.programowanie;

public class Pozycja {

    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }
    public double obliczWartosc(){
        return getIleSztuk()*getCena();
    }

    @Override
    public String toString(){
        return String.format("%-20s%-10s%-4s%-10s",getNazwaTowaru(),getCena()+" zł",getIleSztuk()+" szt.",obliczWartosc(/*getIleSztuk(),getCena()*/));
    }

    public String getNazwaTowaru() {
        return nazwaTowaru;
    }

    public void setNazwaTowaru(String nazwaTowaru) {
        this.nazwaTowaru = nazwaTowaru;
    }

    public int getIleSztuk() {
        return ileSztuk;
    }

    public void setIleSztuk(int ileSztuk) {
        this.ileSztuk = ileSztuk;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
