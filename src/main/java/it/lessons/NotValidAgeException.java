package it.lessons;

// Eccezione personalizzata controllata (checked)
public class NotValidAgeException extends Exception {
    public NotValidAgeException(String messaggio) {
        super(messaggio);
    }

    public static void main(String[] args) {
        RegistrazioneUtente reg = new RegistrazioneUtente();
        try {
            reg.registra(16);
        } catch (NotValidAgeException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

class RegistrazioneUtente {
    public void registra(int età) throws NotValidAgeException {
        if (età < 18) {
            throw new NotValidAgeException("Età minima richiesta: 18 anni");
        }
        System.out.println("Utente registrato con successo");
    }
}