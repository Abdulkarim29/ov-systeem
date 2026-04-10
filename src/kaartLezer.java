public class kaartLezer {
    private String locatie;
    private int lezerId;

    public kaartLezer(String locatie, int lezerId) {
        this.locatie = locatie;
        this.lezerId = lezerId;
    }

    public boolean leesKaart(ovChipKaart kaart) {
        System.out.println("Kaart gelezen bij " + locatie);
        return true;
    }
}