package it.lessons;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandling {

    public static void main(String[] args) {
        basicTryCatch();
        System.err.println("\n-----------------\n");

        System.err.println("\n-----------------\n");
        multiCatch();

        System.err.println("\n-----------------\n");
        pipeCatch();

        System.err.println("\n-----------------\n");
        nestedExceptions();

        System.err.println("\n-----------------\n");
        finallyBlock();

        System.err.println("\n-----------------\n");
        VerificaLogin.testVerificaPassword();

        System.err.println("\n-----------------\n");
        LettoreFile.testThrows();
    }


    public static void basicTryCatch() {
        try {
            int n = 20;
            int d = 0;
            int risultato = n / d; // Lancia ArithmeticException automaticamente
            System.out.println("Questa istruzione non verrà eseguita.");
        } catch (ArithmeticException error) {
            System.err.println("Impossibile dividere per zero.");
            System.err.println("Dettaglio eccezione: " + error.toString());
        }
    }

    public static void multiCatch() {
        try {
            int[] numeri = new int[5];
            numeri[10] = 99; // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.err.println("Errore aritmetico: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Indice non valido: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("Riferimento nullo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Eccezione generica: " + e.getMessage());
        } finally {
            System.out.println("Blocco finally eseguito.");
        }
    }

    public static void pipeCatch() {
        try {
            int n = 20;
            int d = 0;
            int risultato = n / d; // Lancia ArithmeticException automaticamente
            System.out.println("Questa istruzione non verrà eseguita.");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException error) {
            System.err.println("Impossibile dividere per zero.");
            System.err.println("Dettaglio eccezione: " + error.toString());
        }
    }

    public static void nestedExceptions() {
        try {
            try {
                int[] arr = new int[2];
                arr[5] = 10;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Errore interno: array out of bounds.");
            }

            int risultato = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Errore esterno: divisione per zero.");
        }
    }

        public static void finallyBlock() {
            try {
                System.out.println("Divisione in corso...");
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.err.println("Eccezione catturata: " + e.getMessage());
            } finally {
                System.out.println("Blocco finally eseguito");
            }
        }

    public class VerificaLogin {
        static void verificaPassword(String password) {
            if (password.length() < 8) {
                throw new IllegalArgumentException("Password troppo corta");
            }
        }

        public static void testVerificaPassword() {
            try {
                verificaPassword("12345");
            } catch (IllegalArgumentException ex) {
                System.err.println("Errore: " + ex.getMessage());
            }
        }
    }


    public class LettoreFile {

        public static void leggiFile(String nomeFile) throws IOException {
            FileReader fr = new FileReader(new File(nomeFile));
            System.out.println("File aperto correttamente");
            fr.close();
        }

        public static void testThrows() {
            try {
                leggiFile("test.txt");
            } catch (IOException e) {
                System.out.println("Errore I/O: " + e.getMessage());
            }
        }

    }
}
