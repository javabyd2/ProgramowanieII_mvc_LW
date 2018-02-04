package com.sdabyd2.programowanie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception, IOException, NullPointerException {

        String nazwaPliku = "Pliczek.txt";

        System.out.println(String.format("%-20s%-10s%-10s%-10s","Nazwa towaru:","Cena:","Sztuk:","Suma:"));
        Pozycja pozycja1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja1);

        Pozycja pozycja2 = new Pozycja("Cukier", 3, 4);
        System.out.println(pozycja2);

        Pozycja pozycja3 = new Pozycja("Mleko", 4, 2.5);
        System.out.println(pozycja3);

        Pozycja pozycja4 = new Pozycja("Kurczak", 1, 10);
        System.out.println(pozycja4);
        Pozycja pozycja5 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja5);
        Pozycja pozycja6 = new Pozycja("Jablka", 4, 2.5);
        System.out.println(pozycja6);

        Pozycja pozycja7 = new Pozycja("Jajka", 6, 0.90);
        System.out.println(pozycja7);
        Pozycja pozycja8 = new Pozycja("Plyn", 1, 3.5);
        System.out.println(pozycja8);

        Zamowienie zamowienie = new Zamowienie(10);

        zamowienie.dodajPozycje(pozycja1);
        zamowienie.dodajPozycje(pozycja2);
        zamowienie.dodajPozycje(pozycja3);
        zamowienie.dodajPozycje(pozycja4);
        zamowienie.dodajPozycje(pozycja5);
        zamowienie.dodajPozycje(pozycja6);
        zamowienie.dodajPozycje(pozycja7);
        zamowienie.dodajPozycje(pozycja8);
        zamowienie.edytujPozycje(2,"Kurczak",2,10);
        zamowienie.usunPozycje(pozycja4);
        System.out.println(zamowienie);
        zamowienie.zapiszZamowienie(zamowienie,nazwaPliku);
        zamowienie.wczytajZamowienie(nazwaPliku);
    }
}
