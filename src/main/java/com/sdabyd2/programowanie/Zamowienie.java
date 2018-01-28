package com.sdabyd2.programowanie;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private Pozycja pozycjaPozycja;
    List<Pozycja> pozycja = new ArrayList<Pozycja>();
    private int ileDodanychPozycjiWZamowieniu;
    private int maksymalnaLiczbaPozycjiWZamowieniu;

    public Zamowienie() { //konstruktor bezparametrowy
        maksymalnaLiczbaPozycjiWZamowieniu = 10;
    }

    public Zamowienie(int maskymalnaLiczbaPozycji) {
        maksymalnaLiczbaPozycjiWZamowieniu = maskymalnaLiczbaPozycji;
    }

    public void dodajPozycje(Pozycja p) {
            pozycja.add(p);
    }

    public double obliczWartoscCala() {
        double calkowitaWartoscZamowienia = 0;
        for (int i = 0; i < pozycja.size(); i++) {
            calkowitaWartoscZamowienia +=pozycja.get(i).obliczWartosc();
        }

        return calkowitaWartoscZamowienia;
    }

    @Override
    public String toString() {
                return "\nZamówienie: \n" + pozycja+ "\nRazem: " + obliczWartoscCala() + " zł";
    }
    public void usunPozycje(int podajPozycjeDoUsuniecia){

    }

//    public int getIleDodanychPozycjiWZamowieniu() {
//        return ileDodanychPozycjiWZamowieniu;
//    }
//
//    public void setIleDodanychPozycjiWZamowieniu(int ileDodanychPozycjiWZamowieniu) {
//        this.ileDodanychPozycjiWZamowieniu = ileDodanychPozycjiWZamowieniu;
//    }
}
