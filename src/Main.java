import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ovChipKaart kaart = new ovChipKaart("1218194", 20.0, LocalDate.of(2026, 3, 27));
        kaartLezer lezer = new kaartLezer("Nijmegen Centraal", 1);
        reis reis = new reis("Nijmegen Centraal", "Arnhem Centraal", 10.0);
        automaat automaat = new automaat("Nijmegen Centraal", 101);

        System.out.println("Welkom in Nijmegen 🚉");
        System.out.println("Maak een keuze wat uw wilt doen ");
        System.out.println("Veel succes");

        boolean actief = true;

        while (actief) {
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
                    if (!kaart.isIngecheckt()) {
                        if (lezer.leesKaart(kaart)) {
                            kaart.inchecken(reis.getBeginstation(), LocalDateTime.now());
                        } else {
                            System.out.println("Kaart kon niet gelezen worden.");
                        }
                    } else {
                        System.out.println("Je bent al ingecheckt.");
                    }
                    break;

                case 2:
                    if (kaart.isIngecheckt()) {
                        kaart.uitchecken(reis.getEindstation(), LocalDateTime.now(), reis.berekenPrijs());
                        System.out.println("Nieuw saldo: " + kaart.getSaldo());
                    } else {
                        System.out.println("Je bent nog niet ingecheckt.");
                    }
                    break;

                case 3:
                    System.out.println("Saldo: " + kaart.getSaldo());
                    break;

                case 4:
                    System.out.println("Reis van " + reis.getBeginstation() + " naar " + reis.getEindstation());
                    System.out.println("Prijs: " + reis.berekenPrijs());
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
                    System.out.println("Ongeldige keuze.");
            }
        }

        scanner.close();
    }
}