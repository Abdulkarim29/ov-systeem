public class automaat {
    private String locatie;
    private int automaatId;

    public automaat(String locatie, int automaatId) {
        this.locatie = locatie;
        this.automaatId = automaatId;
    }

    public void waardeerOp(ovChipKaart kaart, double bedrag) {
        kaart.opwaarderen(bedrag);
        System.out.println("Opwaarderen gelukt bij automaat " + automaatId + " op " + locatie);
    }
}