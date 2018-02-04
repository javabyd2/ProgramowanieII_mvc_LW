package com.sdabyd2.programowanie;

import java.io.IOException;
import java.util.List;

public interface Serializable {

   void zapiszZamowienie(Zamowienie z, String nazwaPliku) throws  Exception;

    List<String> wczytajZamowienie(String nazwaPliku) throws IOException;

}
