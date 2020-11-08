package frontend;

import dao.AdvertentieDao;
import domain.Advertentie;
import domain.Gebruiker;

import java.util.Scanner;

public class EigenAdvertentiesRaadplegen {
    public Scanner scanner = new Scanner(System.in);

    public void eigenAdvertentiesRaadplegen(AdvertentieDao adDao, Gebruiker gebruiker) {

        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle door u geplaatste advertenties: ");

            /*adDao.findAllPerUser(gebruiker).forEach(e -> System.out.println("\t" + e.toString()));*/

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Zoeken in eigen producten]");
            System.out.println("(2) [Advertentie wijzingen]");
            System.out.println("(3) [Advertentie terugtrekken of verwijderen]");
            System.out.println("(X) [Terug naar hoofdmenu.]");

            String antwoord = scanner.nextLine().toUpperCase();

            try {
                switch (antwoord) {
                    case "1":
                        break;
                    case "2":
                        new AdvertentieWijzigen().advertentieWijzigen(adDao);
                        break;
                    case "3":
                        new AdvertentieStatusWijzigen().advertentieStatusWijzigen(adDao);
                        break;
                    case "X":
                        return;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Er is iets mis gegaan. Probeer het nog eens.");
            }

        }

    }

}
