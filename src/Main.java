import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OvChipKaart kaart = new OvChipKaart("1218194", 20.0, LocalDate.of(2026, 3, 27));
        KaartLezer lezer = new KaartLezer("Nijmegen Centraal", 1);
        Reis reis = new Reis("Nijmegen Centraal", "Arnhem Centraal", 10.0);
        Automaat automaat = new Automaat("Nijmegen Centraal", 101);

        System.out.println("Welkom in Nijmegen");
        System.out.println("Maak een keuze uit het menu.");
        System.out.println("Veel succes!");

        boolean actief = true;

        while (actief) {
            System.out.println();
            System.out.println("===== MENU =====");
            System.out.println("1. Inchecken");
            System.out.println("2. Uitchecken");
            System.out.println("3. Saldo bekijken");
            System.out.println("4. Reis info");
            System.out.println("5. Opwaarderen");
            System.out.println("6. Stoppen");
            System.out.print("Keuze: ");

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    if (kaart.isIngecheckt()) {
                        System.out.println("Je bent al ingecheckt.");
                    } else if (!lezer.leesKaart(kaart)) {
                        System.out.println("Kaart kon niet gelezen worden of is niet geldig.");
                    } else if (!kaart.heeftVoldoendeSaldo(reis.berekenPrijs())) {
                        System.out.println("Je hebt onvoldoende saldo om in te checken.");
                        System.out.println("Huidig saldo: € " + kaart.getSaldo());
                        System.out.println("Benodigd saldo: € " + reis.berekenPrijs());
                    } else {
                        kaart.inchecken(reis.getBeginstation(), kaart.getTime());
                    }
                    break;

                case 2:
                    if (!kaart.isIngecheckt()) {
                        System.out.println("Je bent nog niet ingecheckt.");
                    } else {
                        kaart.uitchecken(reis.getEindstation(), kaart.getTime(), reis.berekenPrijs());
                    }
                    break;

                case 3:
                    System.out.println("Saldo: € " + kaart.getSaldo());
                    break;

                case 4:
                    System.out.println("Reis van " + reis.getBeginstation() + " naar " + reis.getEindstation());
                    System.out.println("Prijs: € " + reis.berekenPrijs());
                    break;

                case 5:
                    System.out.print("Hoeveel wil je opwaarderen? ");
                    double bedrag = scanner.nextDouble();
                    automaat.waardeerOp(kaart, bedrag);
                    break;

                case 6:
                    actief = false;
                    System.out.println("Programma gestopt.");
                    break;

                default:
                    System.out.println("Ongeldige keuze. Kies een nummer van 1 tot en met 6.");
            }
        }

        scanner.close();
    }
}