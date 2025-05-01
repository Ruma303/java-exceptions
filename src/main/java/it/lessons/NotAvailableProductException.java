package it.lessons;

// Eccezione personalizzata non controllata (unchecked)
public class NotAvailableProductException extends RuntimeException {
    public NotAvailableProductException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        Magazzino m = new Magazzino();
        try {
            m.vendi(5);
        } catch (NotAvailableProductException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }
}

class Magazzino {
    private int quantità = 0;

    public void vendi(int richiesti) {
        if (richiesti > quantità) {
            throw new NotAvailableProductException("Prodotto esaurito");
        }
        quantità -= richiesti;
    }
}