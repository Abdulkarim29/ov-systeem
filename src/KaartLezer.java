public class KaartLezer {
    private String locatie;
    private int lezerId;

    public KaartLezer(String locatie, int lezerId) {
        this.locatie = locatie;
        this.lezerId = lezerId;
    }

    public boolean leesKaart(OvChipKaart kaart) {
        if (kaart == null) {
            System.out.println("Geen kaart gevonden.");
            return false;
        }

        if (!kaart.isGeldig()) {
            System.out.println("Kaart is verlopen.");
            return false;
        }

        System.out.println("Kaart " + kaart.getKaartnummer() + " gelezen bij " + locatie);
        return true;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getLezerId() {
        return lezerId;
    }
}