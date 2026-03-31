import java.time.LocalDate;
import java.time.LocalDateTime;

public class ovChipKaart {

    private String kaartnummer;
    private double saldo;
    private LocalDate geldigTot;

    public ovChipKaart(String kaartnummer, double saldo, LocalDate geldigTot) {
        this.kaartnummer = kaartnummer;
        this.saldo = saldo;
        this.geldigTot = geldigTot;
    }

    public String kaartnummer() {
        return kaartnummer;
    }

    public double Saldo() {
        return saldo;
    }

    public LocalDate GeldigTot() {
        return geldigTot;
    }

    public void inchecken(String station, String formattedTime) {
        System.out.println("Ingecheckt op " + station + " om " + formattedTime);
    }

    public void uitchecken(String station, LocalDateTime tijd, double prijs) {
        saldo = saldo - prijs;
        System.out.println("Uitgecheckt op " + station + " om " + tijd);
    }

    public void opwaarderen(double bedrag) {
        System.out.println("Kaart wordt opgewaardeerd met: " + bedrag);

        saldo = saldo + bedrag;

        System.out.println("Opwaarderen op kaart is uitgevoerd.");
    }
}