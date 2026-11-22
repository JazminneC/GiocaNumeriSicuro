package giocanumerisicuro;

public class Cifrario {

 // Prende ogni lettera della parola e la fa avanzare nell'alfabeto di "spostamento" passi (es. +3) per cifrarla
    public String cifra(String testo, int spostamento) {
        String risultato = "";
        for (int i = 0; i < testo.length(); i++) {
            char c = testo.charAt(i);
            if (c >= 'a' && c <= 'z') {
                char cifrato = (char) ('a' + (c - 'a' + spostamento) % 26);
                risultato = risultato + cifrato;
            } else if (c >= 'A' && c <= 'Z') {
                char cifrato = (char) ('A' + (c - 'A' + spostamento) % 26);
                risultato = risultato + cifrato;
            } else {
                // Caratteri non alfabetici restano uguali
                risultato = risultato + c;
            }
        }
        return risultato;
    }
}
