package giocanumerisicuro;

import java.io.IOException;

// Classe che rappresenta il singolo giocatore eseguito come Thread
public class GiocatoreSicuro implements Runnable {

    private String idGiocatore;
    private int numero;
    private String parola;
    private int punteggio;
    private String parolaCifrata;

    public GiocatoreSicuro(String idGiocatore, int numero, String parola) {
        // Eccezione non controllata se l'utente inserisce 0 o un numero negativo
        if (numero <= 0) {
            throw new IllegalArgumentException("Il numero deve essere maggiore di zero!");
        }
        this.idGiocatore = idGiocatore;
        this.numero = numero;
        this.parola = parola;
        this.punteggio = 0;
    }

    public void gioca() {
        for (int i = 0; i < numero; i++) {
            System.out.println(idGiocatore + " - giro: " + i);
        }
        punteggio = numero * 10;

        // Usa la classe Cifrario per cifrare la parola
        Cifrario cifrario = new Cifrario();
        parolaCifrata = cifrario.cifra(parola, 3);
    }

    @Override
    public void run() {
        gioca();

        // Usa la classe GestoreFile per salvare su file e poi stampare
        GestoreFile gestore = new GestoreFile();
        try {
            gestore.scriviELeggi(idGiocatore, numero, punteggio, parolaCifrata);
        } catch (IOException e) {
            // Gestione dell'eccezione controllata IOException
            System.err.println("Errore file per " + idGiocatore + ": " + e.getMessage());
        }
    }
}
