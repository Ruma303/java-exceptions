package it.lessons;

import java.util.ArrayList;
import java.util.List;

public class Errors {

    public static void ricorsioneInfinita() {
        ricorsioneInfinita(); // StackOverflowError
    }

    public static void outOfMemoryError() {
        List<int[]> list = new ArrayList<>();
        while (true) {
            list.add(new int[1_000_000]); // OutOfMemoryError
        }
    }

    public static void noClassDefFoundError() {
        try {
            Class.forName("it.lessons.NonExistentClass"); // NoClassDefFoundError
        } catch (ClassNotFoundException e) {
            System.err.println("Classe non trovata: " + e.getMessage());
        }
    }

    public static void internalError() {
        throw new InternalError("Errore interno simulato"); // InternalError
    }

    public static void main(String[] args) {
        // Testare uno alla volta gli errori

        // ricorsioneInfinita();
        // outOfMemoryError();
        // noClassDefFoundError();
        // internalError();
    }
}