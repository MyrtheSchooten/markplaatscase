package frontend;

import dao.AdvertentieDao;
import domain.Advertentie;
import domain.StatusAdvertentie;
import util.ScannerWrapper;

import static org.App.adDao;

public class AdvertentieStatusWijzigen {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void advertentieStatusWijzigen() {
        System.out.println("********* " + getClass().getSimpleName() + " *********");
        System.out.println("----------------------------------------------");
        System.out.println("Hier kunt u de status van uw advertentie wijzigen.");
        System.out.println("Welke advertentie wilt u aanpassen? Voer de productcode in.");
        System.out.println("----------------------------------------------");

        try {
            String productcode = scanner.read();
            Advertentie teWijzigenAd = adDao.get(Long.parseLong(productcode));

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u met de advertentie: " + teWijzigenAd.getTitel() + " doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Terugtrekken/weer te koop zetten]");
            System.out.println("(2) [Verwijderen]");
            System.out.println("(X) [Terug naar de hoofdpagina.]");

            String antwoord = scanner.read().toUpperCase();

            switch (antwoord) {
                case "1":
                    terugtrekkenOfVerkopenAd(teWijzigenAd);
                    break;
                case "2":
                    verwijderenAd(teWijzigenAd);
                    break;
                case "X":
                    return;
                default:
                    System.out.println("Ongeldige invoer. Probeer het nog eens.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Geen advertentie gevonden, voer een geldige productcode in.");
        } catch (RuntimeException e) {
            System.out.println("Er is iets misgegaan, probeer het opnieuw.");
        }
    }

    private void terugtrekkenOfVerkopenAd(Advertentie teWijzigenAd) {
        if (teWijzigenAd.getStatusAdvertentie() == StatusAdvertentie.TEKOOP) {
            teWijzigenAd.setStatusAdvertentie(StatusAdvertentie.TERUGGETROKKEN);
            adDao.save(teWijzigenAd);
            System.out.println("De advertentie is teruggetrokken");
        } else {
            teWijzigenAd.setStatusAdvertentie(StatusAdvertentie.TEKOOP);
            adDao.save(teWijzigenAd);
            System.out.println("De advertentie is weer te koop");
        }

        System.out.println("----------------------------------------------");
        System.out.println("Druk een toets in om verder te gaan");
        System.out.println("----------------------------------------------");

        String verderGaan = scanner.read();
    }

    private void verwijderenAd(Advertentie teWijzigenAd) {
        System.out.println("Weet u zeker dat u de advertentie \"" + teWijzigenAd.getTitel() + "\" wil verwijderen?");
        System.out.println("(1) [Ja]");
        System.out.println("(2) [Nee, annuleer]");
        String antwoord = scanner.read();

        switch (antwoord) {
            case "1":
                adDao.remove(teWijzigenAd);
                break;
            case "2":
                System.out.println("Het verwijderen is geannuleerd.");
                break;
            default:
                System.out.println("Voer een geldige keuze in.");
        }
    }
}
