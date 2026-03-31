public class automaat {

    private String locatie;
    private int automaatId;

    public automaat(String locatie, int automaatId) {
        this.locatie = locatie;
        this.automaatId = automaatId;
    }

    public boolean betaalMetBankpas(double bedrag) {
        System.out.println("Bankpas betaling gestart voor bedrag: " + bedrag);
        System.out.println("Betaling goedgekeurd.");
        return true;
    }

    public void waardeerOp(ovChipKaart kaart, double bedrag) {
        System.out.println("Opwaarderen gestart...");
        System.out.println("Automaat locatie: " + locatie);
        System.out.println("Automaat ID: " + automaatId);

        if (betaalMetBankpas(bedrag)) {
            kaart.opwaarderen(bedrag);
            System.out.println("Opwaarderen voltooid.");
        } else {
            System.out.println("Betaling mislukt. Opwaarderen afgebroken.");
        }
    }
}