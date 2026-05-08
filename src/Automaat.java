public class Automaat {
    private String locatie;
    private int automaatId;

    public Automaat(String locatie, int automaatId) {
        this.locatie = locatie;
        this.automaatId = automaatId;
    }

    public boolean betaal(double bedrag) {
        if (bedrag <= 0) {
            System.out.println("Betaling mislukt. Het bedrag moet groter zijn dan 0.");
            return false;
        }

        System.out.println("Bankpasbetaling gestart voor: € " + bedrag);
        System.out.println("Betaling gelukt.");
        return true;
    }

    public void waardeerOp(OvChipKaart kaart, double bedrag) {
        if (kaart == null) {
            System.out.println("Geen kaart gevonden.");
            return;
        }

        if (betaal(bedrag)) {
            kaart.opwaarderen(bedrag);
            System.out.println("Opwaarderen gelukt bij automaat " + automaatId + " op " + locatie);
        } else {
            System.out.println("Opwaarderen mislukt.");
        }
    }

    public String getLocatie() {
        return locatie;
    }

    public int getAutomaatId() {
        return automaatId;
    }
}