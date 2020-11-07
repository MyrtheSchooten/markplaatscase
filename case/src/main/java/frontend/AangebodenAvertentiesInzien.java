package frontend;

import dao.AdvertentieDao;
import dao.Dao;
import domain.Advertentie;
import domain.DienstAdvertentie;
import domain.ProductAdvertentie;
import domain.StatusAdvertentie;

import java.util.Scanner;

public class AangebodenAvertentiesInzien {
    public Scanner scanner = new Scanner(System.in);

    public void aangebodenAdvertentiesInzien(AdvertentieDao adDao) {

        while (true) {

            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle aangeboden advertenties: ");

            adDao.findAllForSale().forEach(e -> System.out.println("\t" + e.toString()));

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(S) [Simpel zoeken (op naam)]");
            System.out.println("(U) [Uitgebreid zoeken]");
            System.out.println("(X) [Terug naar hoofdmenu.]");

            String antwoord = scanner.nextLine().toUpperCase();

            try {
                switch (antwoord) {
                    case "S":
                        break;
                    case "U":
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

