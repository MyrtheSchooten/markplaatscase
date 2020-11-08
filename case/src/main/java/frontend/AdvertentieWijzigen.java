package frontend;

import dao.AdvertentieDao;
import domain.Advertentie;
import domain.DienstAdvertentie;
import domain.ProductAdvertentie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdvertentieWijzigen {
    public Scanner scanner = new Scanner(System.in);

    public void advertentieWijzigen(AdvertentieDao adDao) {
        System.out.println("----------------------------------------------");
        System.out.println("Hier kunt u uw advertentie wijzigen.");
        System.out.println("Welke advertentie wilt u aanpassen? Voer de productcode in.");
        System.out.println("----------------------------------------------");

        try {
            String productcode = scanner.nextLine();
            Advertentie teWijzigenAd = adDao.get(Long.parseLong(productcode));

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u met de advertentie:" + teWijzigenAd.getTitel() + "doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Titel wijzigen]");
            System.out.println("(2) [Omschrijving wijzigen]");
            System.out.println("(3) [Prijs aanpassen]");
            System.out.println("(4) [Kattenplaatje toevoegen/verwijderen]");
            System.out.println("(5) [Soort aanpassen]");
            System.out.println("(6) [Bezorgwijze kiezen]");
            System.out.println("(X) [Terug naar hoofdmenu.]");

            String antwoord = scanner.nextLine();

            switch (antwoord){
                case "1":
                    wijzigTitel(adDao, teWijzigenAd); break;
                case "2":
                    wijzigOmschrijving(adDao, teWijzigenAd); break;
                case "3":
                    wijzigPrijs(adDao,teWijzigenAd); break;
                case "4":
                    afbeeldingAanpassen(adDao, teWijzigenAd); break;
                case "5":
                    soortAanpassen(adDao, teWijzigenAd); break;
                case "6":
                    bezorgwijzeKiezen(adDao, teWijzigenAd); break;
                case "X":
                    return;
                default:
                    System.out.println("Ongeldige invoer. Probeer het nog eens."); break;
            }

        } catch (NumberFormatException e){
            System.out.println("Geen advertentie gevonden, voer een geldige productcode in.");
        } catch (RuntimeException e){
            System.out.println("Er is iets misgegaan, probeer het opnieuw.");
        }
    }

    private void wijzigTitel(AdvertentieDao adDao, Advertentie teWijzigenAd) {
        System.out.println("Voer de nieuwe titel in.");
        String nieuweTitel = scanner.nextLine();
        teWijzigenAd.setTitel(nieuweTitel);
        adDao.update(teWijzigenAd);
        System.out.println("De titel is gewijzigd naar: " + teWijzigenAd.getTitel() + ".");
    }

    private void wijzigOmschrijving(AdvertentieDao adDao, Advertentie teWijzigenAd) {
        System.out.println("Voer de nieuwe omschrijving in.");
        String nieuweOmschrijving = scanner.nextLine();
        teWijzigenAd.setOmschrijving(nieuweOmschrijving);
        adDao.update(teWijzigenAd);
        System.out.println("De omschrijving is gewijzigd naar: " + teWijzigenAd.getOmschrijving() + ".");
    }

    private void wijzigPrijs(AdvertentieDao adDao, Advertentie teWijzigenAd) {
        try{
            System.out.println("Voer de nieuwe prijs in.");
            double nieuwePrijs = Double.parseDouble(scanner.nextLine());
            teWijzigenAd.setPrijs(nieuwePrijs);
            adDao.update(teWijzigenAd);
        } catch (NumberFormatException e) {
            System.out.println("Voer een geldige prijs in.");
        }
    }

    private void afbeeldingAanpassen(AdvertentieDao adDao, Advertentie teWijzigenAd) {
        try {
            if (teWijzigenAd.getAfbeelding() != null){
                teWijzigenAd.setAfbeelding(null);
                System.out.println("De afbeelding is verwijderd.");
            } else {
                Path path = Paths.get("C:\\Afbeeldingen\\markplaatscase\\advertentieafbeelding.jpg");
                byte[] afbeelding = Files.readAllBytes(path);
                teWijzigenAd.setAfbeelding(afbeelding);
                System.out.println("De afbeelding is toegevoegd.");
            }
        } catch (IOException e) {
            System.out.println("Geen afbeelding gevonden.");
        }
       adDao.update(teWijzigenAd);
    }

    private void soortAanpassen(AdvertentieDao adDao, Advertentie teWijzigenAd) {

    }

    private void bezorgwijzeKiezen(AdvertentieDao adDao, Advertentie teWijzigenAd) {
    }

}
