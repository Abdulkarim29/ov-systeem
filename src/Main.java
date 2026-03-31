import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = now.format(formatter);


        Scanner scanner = new Scanner(System.in);

        ovChipKaart kaart = new ovChipKaart(
                "1218194",
                1000,
                LocalDate.of(2026, 3, 27)
        );

        kaartLezer lezer = new kaartLezer("Nijmegen", 1);

        automaat automaat = new automaat("Nijmegen Centraal", 101);

        reis Reis = new reis(
                "Nijmegen Centraal",
                "Arnhem Centraal",
                10,
                formattedTime
        );

        boolean ovSysteemActief = true;
        boolean ingecheckt = false;



        while (ovSysteemActief) {
            System.out.println("===== MENU =====");
            System.out.println("1. Inchecken");
            System.out.println("2. Uitchecken");
            System.out.println("3. Saldo bekijken");
            System.out.println("4. Reis info bekijken");
            System.out.println("5. Opwaarderen");
            System.out.println("6. Uitloggen / Stoppen");
            System.out.print("Maak een keuze: ");

            int keuze = scanner.nextInt();

            switch (keuze) {
                case 1:
                    if (!ingecheckt) {
                        if (lezer.leeskaart(kaart)) {
                            kaart.inchecken(Reis.beginstation(), formattedTime);
                            ingecheckt = true;
                        } else {
                            System.out.println("Kaart kon niet gelezen worden.");
                        }
                    } else {
                        System.out.println("Je bent al ingecheckt.");
                    }
                    break;

                case 2:
                    if (ingecheckt) {
                        kaart.uitchecken(
                                Reis.eindstation(),
                                LocalDateTime.of(2026, 3, 27, 10, 37),
                                Reis.berekenPrijs()
                        );
                        ingecheckt = false;
                        System.out.println("Nieuw saldo: " + kaart.Saldo());
                    } else {
                        System.out.println("Je bent nog niet ingecheckt.");
                    }
                    break;

                case 3:
                    System.out.println("Huidig saldo: " + kaart.Saldo());
                    break;

                case 4:
                    System.out.println("Reis van " + Reis.beginstation() + " naar " + Reis.eindstation());
                    System.out.println("Prijs: " + Reis.berekenPrijs());
                    System.out.println("Starttijd: " + Reis.formattedTime);
                    break;

                case 5:
                    System.out.print("Voer bedrag in om op te waarderen: ");
                    double bedrag = scanner.nextDouble();

                    automaat.waardeerOp(kaart, bedrag);

                    System.out.println("Huidig saldo: " + kaart.Saldo());
                    break;

                case 6:
                    System.out.println("Uitgelogd. Programma wordt afgesloten.");
                    ovSysteemActief = false;
                    break;

                default:
                    System.out.println("Ongeldige keuze. Probeer opnieuw.");
            }
        }

        scanner.close();
    }
}