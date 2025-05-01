package it.lessons;

import java.io.*;

public class TryWithResources {

    public static void main(String[] args) {
       LetturaFile letturaFile = new LetturaFile();
         try {
              letturaFile.readAndWrite();
         } catch (IOException e) {
              System.out.println("Errore nella lettura del file: " + e.getMessage());
         }
    }
}


class LetturaFile {
   public static void readAndWrite() throws IOException {
       try (
               BufferedReader reader = new BufferedReader(new FileReader("dati.txt"));
               BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
       ) {
           String linea;
           while ((linea = reader.readLine()) != null) {
               System.out.println(linea);
               writer.write(linea);
               writer.newLine();
           }
       } catch (IOException e) {
           System.err.println("Errore nella lettura del file: " + e.getMessage());

       }
   }
}