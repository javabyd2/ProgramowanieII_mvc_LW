package com.sdabyd2.programowanie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.nio.file.*;

public class Zamowienie  implements Serializable {
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
            zsumowanaIlosc += pozycja.get(i).getIleSztuk();
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

        return calkowitaWartoscZamowienia * pozycjaP.obliczWartoscZRabatem(zsumowanaIlosc);
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
        double rabat = (obliczWartoscCalaBezRabatu() - obliczWartoscCalaBezRabatu() * pozycjaP.obliczWartoscZRabatem(zsumowanaIlosc));
        return "\nRazem: " + obliczWartoscCalaBezRabatu() + " zł" + " Rabat wynosi: " + rabat + ". Cena po rabacie wynosi: " + obliczWartoscCala();
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

    @Override
    public void zapiszZamowienie(Zamowienie zamowienie, String nazwaPliku) throws Exception {
        Path path = Paths.get("D:\\Cwiczenia\\Programowanie_cwiczenia_rozne", nazwaPliku);
        BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.CREATE);
        writer.write(String.valueOf(zamowienie));
    }

    @Override
    public List<String> wczytajZamowienie(String nazwaPliku)throws IOException {
        Path path= Paths.get("D:\\Cwiczenia\\Programowanie_cwiczenia_rozne",nazwaPliku);
        List<String> lines = Files.readAllLines(path);
        return lines;
    }

}
