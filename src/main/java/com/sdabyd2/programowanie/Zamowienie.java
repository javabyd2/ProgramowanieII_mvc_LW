package com.sdabyd2.programowanie;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    List<Pozycja> pozycja = new ArrayList<Pozycja>();
    Pozycja pozycjaP = new Pozycja();
    private int ileDodanychPozycjiWZamowieniu;
    private int maksymalnaLiczbaPozycjiWZamowieniu;
    private int zsumowanaIlosc;



    public Zamowienie() { //konstruktor bezparametrowy
        maksymalnaLiczbaPozycjiWZamowieniu = 10;
    }

    public Zamowienie(int maskymalnaLiczbaPozycji) {
        maksymalnaLiczbaPozycjiWZamowieniu = maskymalnaLiczbaPozycji;
    }

    public void dodajPozycje(Pozycja p) {
        pozycja.add(p);
        sprawdzCzyPozycjeSieNiePowtarzajaIZbierzWJedna();
    }

    public void sprawdzCzyPozycjeSieNiePowtarzajaIZbierzWJedna() {

        for (int i = 0; i < pozycja.size(); i++) {
            zsumowanaIlosc +=pozycja.get(i).getIleSztuk();
            for (int j = 0; j < pozycja.size(); j++) {
                if (pozycja.get(i).getNazwaTowaru().equals(pozycja.get(j).getNazwaTowaru()) && i != j) {
                    pozycja.get(i).setIleSztuk(pozycja.get(i).getIleSztuk() + pozycja.get(j).getIleSztuk());
                    pozycja.remove(j);

                }
            }
        }
    }

    public double obliczWartoscCala() {
        double calkowitaWartoscZamowienia = 0;
        for (int i = 0; i < pozycja.size(); i++) {
            calkowitaWartoscZamowienia += pozycja.get(i).obliczWartosc();
        }

        return calkowitaWartoscZamowienia*pozycjaP.obliczWartoscZRabatem(zsumowanaIlosc);
    }

    public double obliczWartoscCalaBezRabatu() {
        double calkowitaWartoscZamowienia = 0;
        for (int i = 0; i < pozycja.size(); i++) {
            calkowitaWartoscZamowienia += pozycja.get(i).obliczWartosc();
        }

        return calkowitaWartoscZamowienia;
    }



    @Override
    public String toString() {
        System.out.println("\nZamówienie:");
        for (int i = 0; i < pozycja.size(); i++) {
            System.out.println(pozycja.get(i));
        }
        return "\nRazem: " + obliczWartoscCalaBezRabatu() + " zł"+" Rabat wynosi: " + pozycjaP.obliczWartoscZRabatem(zsumowanaIlosc)+". Cena po rabacie wynosi: " + obliczWartoscCala();
    }

    public void usunPozycje(Pozycja p) {
        pozycja.remove(p);
    }

    public void edytujPozycje(int indeks, String nazwaTowaru, int ileSztuk, double cena) {
        pozycja.get(indeks).setNazwaTowaru(nazwaTowaru);
        pozycja.get(indeks).setIleSztuk(ileSztuk);
        pozycja.get(indeks).setCena(cena);
        sprawdzCzyPozycjeSieNiePowtarzajaIZbierzWJedna();
    }

//    public int getIleDodanychPozycjiWZamowieniu() {
//        return ileDodanychPozycjiWZamowieniu;
//    }
//
//    public void setIleDodanychPozycjiWZamowieniu(int ileDodanychPozycjiWZamowieniu) {
//        this.ileDodanychPozycjiWZamowieniu = ileDodanychPozycjiWZamowieniu;
//    }
}
