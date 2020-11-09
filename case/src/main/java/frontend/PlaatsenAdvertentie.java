package frontend;

import dao.AdvertentieDao;
import dao.Dao;
import domain.Advertentie;
import domain.DienstAdvertentie;
import domain.Gebruiker;
import domain.ProductAdvertentie;
import util.ScannerWrapper;

import java.util.Scanner;

import static org.App.adDao;

public class PlaatsenAdvertentie {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void plaatsenAdvertentie(Gebruiker gebruiker) {

        while (true) {

            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("----------------------------------------------");
            System.out.println("Hier plaatst u uw advertentie.");
            System.out.println("Wat wilt u aanbieden?");
            System.out.println("----------------------------------------------");

            System.out.println("(D) [Dienst]");
            System.out.println("(P) [Product]");
            System.out.println("(X) [Terug naar hoofdpagina.]");

            String antwoord = scanner.read().toUpperCase();

            try {
                switch (antwoord) {
                    case "D":
                        maakAdvertentie(gebruiker, true);
                        break;
                    case "P":
                        maakAdvertentie(gebruiker, false);
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

    public void maakAdvertentie(Gebruiker gebruiker, boolean isDienst) {
        try {
            System.out.println("Titel advertentie:");
            String titel = scanner.read();
            System.out.println("Prijs advertentie:");
            double prijs = Double.parseDouble(scanner.read());
            System.out.println("Omschrijving (indien n.v.t. niets invullen):");
            String omschrijving = scanner.read();

            Advertentie advertentie = isDienst ?
                    new DienstAdvertentie(titel, prijs, omschrijving) :
                    new ProductAdvertentie(titel, prijs, omschrijving);

            adDao.save(advertentie);
            advertentie.setGebruiker(gebruiker);
            adDao.update(advertentie);

            System.out.println("----------------------------------------------");
            System.out.println("Uw advertentie is opgeslagen.");
            System.out.println("U kunt nu via \"Advertentie wijzigen\" in het hoofdmenu een afbeelding toevoegen en de advertentie aanpassen.");
            System.out.println("Druk een toets in om verder te gaan");
            System.out.println("----------------------------------------------");

            String verderGaan = scanner.read();

        } catch (NumberFormatException e) {
            System.out.println("Voer een numerieke waarde in voor de prijs. Probeer het nog een keer.");
        }
    }




}


