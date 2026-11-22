package giocanumerisicuro;

import java.util.Scanner;

public class MainGiocaNumeriSicuro {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input da tastiera per i due giocatori
            System.out.print("Giocatore 1, inserisci un numero maggiore di 0: ");
            int num1 = Integer.parseInt(scanner.nextLine());
            System.out.print("Giocatore 1, inserisci una parola: ");
            String parola1 = scanner.nextLine();

            System.out.print("Giocatore 2, inserisci un numero maggiore di 0: ");
            int num2 = Integer.parseInt(scanner.nextLine());
            System.out.print("Giocatore 2, inserisci una parola: ");
            String parola2 = scanner.nextLine();

            // Creazione dei giocatori e dei thread
            GiocatoreSicuro g1 = new GiocatoreSicuro("G1", num1, parola1);
            GiocatoreSicuro g2 = new GiocatoreSicuro("G2", num2, parola2);

            Thread t1 = new Thread(g1, "G1");
            Thread t2 = new Thread(g2, "G2");

            t1.start();
            t2.start();

            // Attesa della fine di entrambi i thread
            t1.join();
            t2.join();

            System.out.println("Gioco terminato!");
        } catch (NumberFormatException e) {
            // Eccezione non controllata: input non numerico
            System.err.println("Errore: devi inserire un numero intero valido!");
        } catch (IllegalArgumentException e) {
            // Eccezione non controllata: numero <= 0
            System.err.println("Errore nei dati inseriti: " + e.getMessage());
        } catch (InterruptedException e) {
            // Eccezione controllata: interruzione durante join()
            System.err.println("Attesa dei thread interrotta!");
            Thread.currentThread().interrupt();
        } finally {
            scanner.close();
        }
    }
}
