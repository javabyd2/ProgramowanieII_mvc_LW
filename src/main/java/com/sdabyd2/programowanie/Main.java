package com.sdabyd2.programowanie;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Pozycja pozycja1 = new Pozycja("Chleb", 1, 3.5);
        System.out.println(pozycja1);

        Pozycja pozycja2 = new Pozycja("Cukier", 3, 4);
        System.out.print(pozycja2);

        Zamowienie zamowienie = new Zamowienie(2);

        zamowienie.dodajPozycje(pozycja1);
        zamowienie.dodajPozycje(pozycja2);

        System.out.println(zamowienie);
    }
}
