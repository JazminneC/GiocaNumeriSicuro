package giocanumerisicuro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GestoreFile {

// Crea il nome del file usando l'id del giocatore e la data di oggi (es. "G1 - gioco del 22112026.txt")
    public String creaNomeFile(String idGiocatore) {
        LocalDate oggi = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("ddMMyyyy");
        String dataFormattata = oggi.format(formato);
        return idGiocatore + " - gioco del " + dataFormattata + ".txt";
    }

    // Prima scrive nel file e poi rilegge per mostrare i dati in output
    // 'throws IOException' segnala che il metodo può generare un'eccezione controllata
    public void scriviELeggi(String idGiocatore, int numero, int punteggio, String parolaCifrata) throws IOException {
        String nomeFile = creaNomeFile(idGiocatore);

        // Scrittura su file
        FileWriter fw = new FileWriter(nomeFile);
        fw.write("Numero: " + numero + "\n");
        fw.write("Punteggio: " + punteggio + "\n");
        fw.write("Parola cifrata: " + parolaCifrata + "\n");
        fw.close();

        // Lettura dal file e stampa a video
        BufferedReader br = new BufferedReader(new FileReader(nomeFile));
        String riga;
        System.out.println("--- Output da file: " + nomeFile + " ---");
        while ((riga = br.readLine()) != null) {
            System.out.println(riga);
        }
        br.close();
    }
}
