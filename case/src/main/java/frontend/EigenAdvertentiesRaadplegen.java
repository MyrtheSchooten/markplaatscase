package frontend;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import dao.AdvertentieDao;
import domain.Advertentie;
import domain.Gebruiker;
import util.ScannerWrapper;

import java.util.List;
import java.util.Scanner;

import static org.App.adDao;

public class EigenAdvertentiesRaadplegen {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void eigenAdvertentiesRaadplegen(Gebruiker gebruiker) {

        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");

            List<Advertentie> lijstVanGebruiker = adDao.findAllPerUser(gebruiker);
            if (lijstVanGebruiker.size() != 0) {
                System.out.println("Dit zijn alle door u geplaatste advertenties: ");
                lijstVanGebruiker.forEach(e -> System.out.println("\t" + e.toString()));
            } else {
                System.out.println("U heeft nog geen advertenties geplaatst.");
            }

            System.out.println("----------------------------------------------");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Zoeken in eigen advertenties]");
            System.out.println("(2) [Advertentie wijzigen]");
            System.out.println("(3) [Advertentie terugtrekken of verwijderen]");
            System.out.println("(X) [Terug naar hoofdpagina.]");

            String antwoord = scanner.read().toUpperCase();

            try {
                switch (antwoord) {
                    case "1":
                        simpelZoekenEigenAdvertenties(gebruiker);
                        break;
                    case "2":
                        new AdvertentieWijzigen().advertentieWijzigen();
                        break;
                    case "3":
                        new AdvertentieStatusWijzigen().advertentieStatusWijzigen();
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

    private void simpelZoekenEigenAdvertenties(Gebruiker gebruiker) {
        System.out.println("Voer een (deel van) een titel in om te zoeken");
        String zoekterm = scanner.read();

        List<Advertentie> result = adDao.findByNaamGebruiker(zoekterm, gebruiker);

        if (result.size() != 0) {
            result.forEach(e -> System.out.println("\t" + e.toString()));
        } else {
            System.out.println("Er zijn geen advertenties gevonden met deze zoekterm in de titel.");
        }

        System.out.println("----------------------------------------------");
        System.out.println("Druk een toets in om verder te gaan");
        System.out.println("----------------------------------------------");
        String verderGaan = scanner.read();
    }

}
