package frontend;

import dao.AdvertentieDao;
import domain.Gebruiker;
import util.ScannerWrapper;

import java.util.Scanner;

public class Hoofdpagina {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void start(Gebruiker gebruiker) {

        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("----------------------------------------------");
            System.out.println("Welkom op de marktplaats!");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Een advertentie plaatsen.]");
            System.out.println("(2) [Aangeboden artikelen bekijken.]");
            System.out.println("(3) [Eigen artikelen raadplegen.]");
            System.out.println("(X) [Afmelden]");

            String answer = scanner.read().toUpperCase();

            try {
                switch (answer) {
                    case "1":
                        new PlaatsenAdvertentie().plaatsenAdvertentie(gebruiker);
                        break;
                    case "2":
                        new AangebodenAvertentiesInzien().aangebodenAdvertentiesInzien(gebruiker);
                        break;
                    case "3":
                        new EigenAdvertentiesRaadplegen().eigenAdvertentiesRaadplegen(gebruiker);
                        break;
                    case "X":
                        return;
                    default:
                        System.out.println("Ongeldige keuze; probeer opnieuw");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Er is iets mis gegaan. Probeer het nog eens.");
            }

        }
    }

}
