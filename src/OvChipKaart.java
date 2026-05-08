import java.time.LocalDate;

public class OvChipKaart {
    private String kaartnummer;
    private double saldo;
    private LocalDate geldigTot;
    private boolean ingecheckt;

    public OvChipKaart(String kaartnummer, double saldo, LocalDate geldigTot) {
        this.kaartnummer = kaartnummer;
        this.saldo = saldo;
        this.geldigTot = geldigTot;
        this.ingecheckt = false;
    }

    public boolean isGeldig() {
        return geldigTot.getYear() < 2030;
    }

    public boolean heeftVoldoendeSaldo(double bedrag) {
        return saldo >= bedrag;
    }

    public void inchecken(String station, String tijd) {
        ingecheckt = true;
        System.out.println("Ingecheckt op " + station + " om " + tijd);
    }

    public void uitchecken(String station, String tijd, double prijs) {
        if (saldo >= prijs) {
            saldo -= prijs;
            ingecheckt = false;

            System.out.println("Uitgecheckt op " + station + " om " + tijd);
            System.out.println("Reisprijs: € " + prijs);
            System.out.println("Nieuw saldo: € " + saldo);
        } else {
            System.out.println("Uitchecken niet gelukt. Onvoldoende saldo.");
        }
    }

    public String getTime() {
        HoursMinutes hm = new HoursMinutes();
        return hm.getFormattedTime();
    }

    public void opwaarderen(double bedrag) {
        if (bedrag > 0) {
            saldo += bedrag;
            System.out.println("Kaart opgewaardeerd met € " + bedrag);
            System.out.println("Nieuw saldo: € " + saldo);
        } else {
            System.out.println("Opwaardeerbedrag moet groter zijn dan 0.");
        }
    }

    public String getKaartnummer() {
        return kaartnummer;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isIngecheckt() {
        return ingecheckt;
    }
}