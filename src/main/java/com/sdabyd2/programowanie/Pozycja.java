package com.sdabyd2.programowanie;

public class Pozycja {

    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;
    private int zsumowanaIloscSztuk;


    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }
    public Pozycja(){
        this.obliczWartoscZRabatem(getZsumowanaIloscSztuk());
    }
    public double obliczWartosc(){
        return getIleSztuk()*getCena();
    }

    public double obliczWartoscZRabatem(int zsumowanaIloscSztuk){

        if(zsumowanaIloscSztuk>=5 && zsumowanaIloscSztuk <10){
            return 0.95;
        }else if(zsumowanaIloscSztuk>=10 && zsumowanaIloscSztuk <20){
            return 0.90;
        }else if(zsumowanaIloscSztuk>=20){
            return 0.85;
        }else{
            return 1;
        }
    }

    @Override
    public String toString(){
        return String.format("%-20s%-10s%-10s%-10s",getNazwaTowaru(),getCena()+" zł",getIleSztuk()+" szt.",obliczWartosc(/*getIleSztuk(),getCena()*/)+"zł");
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

    public int getZsumowanaIloscSztuk() {
        return zsumowanaIloscSztuk;
    }

    public void setZsumowanaIloscSztuk(int zsumowanaIloscSztuk) {
        this.zsumowanaIloscSztuk = zsumowanaIloscSztuk;
    }
}
