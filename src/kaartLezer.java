import java.time.LocalDate;

public class kaartLezer {

    private String locatie;
    private int lezerId;

    public kaartLezer(String locatie, int lezerId) {
        this.locatie = locatie;
        this.lezerId = lezerId;
    }

    public boolean leeskaart(ovChipKaart kaart) {
        return true;
    }
}