package it.lessons;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exceptions {
    public static void main(String[] args) {

//        // Unchecked exceptions
//        try {
//            FileReaderExample.uncheckedException();
//        } catch (ArithmeticException e) {
//            System.err.println("Eccezione non controllata: " + e.getMessage());
//        }
//
//        // Checked exceptions
//        try {
//            FileReaderExample.checkedException();
//        } catch (IOException e) {
//            System.err.println("Eccezione controllata: " + e.getMessage());
//        }


    }
}


// Checked vs unchecked exceptions
class FileReaderExample {
    public static void checkedException() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file.txt")); // FileNotFoundException
        String line = reader.readLine();
        reader.close();
    }

    // Unchecked exceptions
    public static void uncheckedException() {
        int result = 10 / 0; // ArithmeticException
    }
}