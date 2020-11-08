package frontend;

import dao.AdvertentieDao;
import dao.Dao;
import domain.Advertentie;
import domain.Gebruiker;
import frontend.PlaatsenAdvertentie;

import java.util.Scanner;

public class Hoofdpagina {
    public Scanner scanner = new Scanner(System.in);

    public void Start(AdvertentieDao adDao, Gebruiker gebruiker) {

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Welkom op de marktplaats!");
            System.out.println("Wat wilt u doen?");
            System.out.println("----------------------------------------------");

            System.out.println("(1) [Een advertentie plaatsen.]");
            System.out.println("(2) [Aangeboden artikelen zoeken.]");
            System.out.println("(3) [Eigen artikelen raadplegen.]");
            System.out.println("(4) [Naar mijn winkelmandje]");
            System.out.println("(X) [Afsluiten]");

            String answer = scanner.nextLine().toUpperCase();

            try {
                switch (answer) {
                    case "1":
                        new PlaatsenAdvertentie().plaatsenAdvertentie(adDao, gebruiker);
                        break;
                    case "2":
                        new AangebodenAvertentiesInzien().aangebodenAdvertentiesInzien(adDao, gebruiker);
                        break;
                    case "3":
                        new EigenArtikelenRaadplegen().eigenArtikelenRaadplegen(adDao, gebruiker);
                        break;
                    case "4":
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
