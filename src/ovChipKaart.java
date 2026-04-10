import java.time.LocalDate;
import java.time.LocalDateTime;

public class ovChipKaart {
    private String kaartnummer;
    private double saldo;
    private LocalDate geldigTot;
    private boolean ingecheckt;

    public ovChipKaart(String kaartnummer, double saldo, LocalDate geldigTot) {
        this.kaartnummer = kaartnummer;
        this.saldo = saldo;
        this.geldigTot = geldigTot;
        this.ingecheckt = false;
    }

    public void inchecken(String station, LocalDateTime tijd) {
        ingecheckt = true;
        System.out.println("Ingecheckt op " + station + " om " + tijd);
    }

    public void uitchecken(String station, LocalDateTime tijd, double prijs) {
        saldo -= prijs;
        ingecheckt = false;
        System.out.println("Uitgecheckt op " + station + " om " + tijd);
        System.out.println("Reisprijs: " + prijs);
    }

    public void opwaarderen(double bedrag) {
        saldo += bedrag;
        System.out.println("Kaart opgewaardeerd met " + bedrag);
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isIngecheckt() {
        return ingecheckt;
    }
}