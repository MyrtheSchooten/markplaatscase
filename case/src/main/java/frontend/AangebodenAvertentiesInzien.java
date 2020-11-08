package frontend;

import dao.AdvertentieDao;
import domain.Advertentie;
import domain.Gebruiker;

import java.util.List;
import java.util.Scanner;

public class AangebodenAvertentiesInzien {
    public Scanner scanner = new Scanner(System.in);

    public void aangebodenAdvertentiesInzien(AdvertentieDao adDao, Gebruiker gebruiker) {

        while (true) {

            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Dit zijn alle aangeboden advertenties: ");

            adDao.findAllForSale().forEach(e -> System.out.println("\t" + e.toString()));

            System.out.println("----------------------------------------------");
            System.out.println("Voer hier een zoekterm in om te zoeken op naam of voer U in om uitgebreid te zoeken.");
            System.out.println("Voer X in om terug te gaan naar het hoofdmenu.");
            System.out.println("----------------------------------------------");

            String zoekterm = scanner.nextLine().toUpperCase();

            try {
                switch (zoekterm) {
                    case "U":
                        uitgebreidZoeken(adDao);
                        break;
                    case "X":
                        return;
                    default:
                        simpelZoeken(adDao, zoekterm);
                        // adToevoegenWinkelmand(adDao, gebruiker);
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Er is iets mis gegaan. Probeer het nog eens.");
            }


        }

    }

    private void uitgebreidZoeken(AdvertentieDao adDao) {
        System.out.println("----------------------------------------------");
        System.out.println("In dit scherm kunt u uitgebreid zoeken");
        System.out.println("----------------------------------------------");

        System.out.println("Zoekt u een dienst of een product?");
        System.out.println("(D) [Dienst]");
        System.out.println("(P) [Product]");
        System.out.println("(X) [Annuleer]");

        boolean zoektDienst = false;
        String zoekCategorie = scanner.nextLine().toUpperCase();

        try{
        switch (zoekCategorie) {
            case "D":
                zoektDienst = true;
                break;
            case "P":
                zoektDienst = false;
                break;
            case "X":
                return;
            default:
                System.out.println("Geen geldige invoer. Probeer het nog eens.");
                break;
        }

            System.out.println("Titel:");
            String zoektermTitel = scanner.nextLine();
            System.out.println("Maximum prijs:");
            double maxPrijs = Double.parseDouble(scanner.nextLine());
            System.out.println();

           /* List<Advertentie> result = zoektDienst ?
                    adDao.uitgebreidZoekenDienst(zoektermTitel, maxPrijs):
                    adDao.uitgebreidZoekenProduct(zoektermTitel, maxPrijs);

            result.forEach(e -> System.out.println("\t" + e.toString()));*/

        } catch (NumberFormatException e) {
            System.out.println("Voer een getal in voor de prijs.");
        }


    }

    private void simpelZoeken(AdvertentieDao adDao, String zoekterm) {
        List<Advertentie> result = adDao.findBy(zoekterm);
        if (result.size() != 0) {
            result.forEach(e -> System.out.println("\t" + e.toString()));
        } else {
            System.out.println("Er zijn geen advertenties gevonden met deze zoekterm in de titel.");
        }
        System.out.println("----------------------------------------------");
        System.out.println("Druk een toets in om verder te gaan");
        System.out.println("----------------------------------------------");
        String verderGaan = scanner.nextLine();
    }


}

