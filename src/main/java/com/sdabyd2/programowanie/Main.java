package com.sdabyd2.programowanie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(String.format("%-20s%-10s%-10s%-10s","Nazwa towaru:","Cena:","Sztuk:","Suma:"));
        Pozycja pozycja1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja1);

        Pozycja pozycja2 = new Pozycja("Cukier", 3, 4);
        System.out.println(pozycja2);

        Pozycja pozycja3 = new Pozycja("Mleko", 4, 2.5);
        System.out.println(pozycja3);

        Pozycja pozycja4 = new Pozycja("Kurczak", 1, 10);
        System.out.print(pozycja4);

        Zamowienie zamowienie = new Zamowienie(10);

        zamowienie.dodajPozycje(pozycja3);
        zamowienie.dodajPozycje(pozycja4);

        System.out.println(zamowienie);
    }
}
