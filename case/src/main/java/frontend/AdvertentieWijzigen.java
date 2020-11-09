package frontend;

import dao.AdvertentieDao;
import domain.Advertentie;
import domain.DienstAdvertentie;
import domain.ProductAdvertentie;
import util.ScannerWrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static org.App.adDao;

public class AdvertentieWijzigen {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void advertentieWijzigen() {
        System.out.println("********* " + getClass().getSimpleName() + " *********");
        System.out.println("----------------------------------------------");
        System.out.println("Hier kunt u uw advertentie wijzigen.");
        System.out.println("Welke advertentie wilt u aanpassen? Voer de productcode in.");
        System.out.println("----------------------------------------------");

        try {
            String productcode = scanner.read();
            Advertentie teWijzigenAd = adDao.get(Long.parseLong(productcode));

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u met de advertentie:" + teWijzigenAd.getTitel() + "doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Titel wijzigen]");
            System.out.println("(2) [Omschrijving wijzigen]");
            System.out.println("(3) [Prijs aanpassen]");
            System.out.println("(4) [Kattenplaatje toevoegen/verwijderen]");
            System.out.println("(X) [Terug]");

            String antwoord = scanner.read();

            switch (antwoord){
                case "1":
                    wijzigTitel(teWijzigenAd); break;
                case "2":
                    wijzigOmschrijving(teWijzigenAd); break;
                case "3":
                    wijzigPrijs(teWijzigenAd); break;
                case "4":
                    afbeeldingAanpassen(teWijzigenAd); break;
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

    private void wijzigTitel(Advertentie teWijzigenAd) {
        System.out.println("Voer de nieuwe titel in.");
        String nieuweTitel = scanner.read();
        teWijzigenAd.setTitel(nieuweTitel);
        adDao.update(teWijzigenAd);
        System.out.println("De titel is gewijzigd naar: " + teWijzigenAd.getTitel() + ".");
    }

    private void wijzigOmschrijving(Advertentie teWijzigenAd) {
        System.out.println("Voer de nieuwe omschrijving in.");
        String nieuweOmschrijving = scanner.read();
        teWijzigenAd.setOmschrijving(nieuweOmschrijving);
        adDao.update(teWijzigenAd);
        System.out.println("De omschrijving is gewijzigd naar: " + teWijzigenAd.getOmschrijving() + ".");
    }

    private void wijzigPrijs(Advertentie teWijzigenAd) {
        try{
            System.out.println("Voer de nieuwe prijs in.");
            double nieuwePrijs = Double.parseDouble(scanner.read());
            teWijzigenAd.setPrijs(nieuwePrijs);
            adDao.update(teWijzigenAd);
        } catch (NumberFormatException e) {
            System.out.println("Voer een geldige prijs in.");
        }
    }

    private void afbeeldingAanpassen(Advertentie teWijzigenAd) {
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

}
