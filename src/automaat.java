public class automaat {
    private String locatie;
    private int automaatId;

    public automaat(String locatie, int automaatId) {
        this.locatie = locatie;
        this.automaatId = automaatId;
    }

    public boolean betaal(double bedrag) {
        System.out.println("Bankpas betaling gestart voor: " + bedrag);
        System.out.println("Betaling gelukt.");
        return true;
    }

    public void waardeerOp(ovChipKaart kaart, double bedrag) {
        if (betaal(bedrag)) {
            kaart.opwaarderen(bedrag);
            System.out.println("Opwaarderen gelukt bij automaat " + automaatId + " op " + locatie);
        } else {
            System.out.println("Betaling mislukt.");
        }
    }
}