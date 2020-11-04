package frontend;

import dao.Dao;
import domain.DienstAdvertentie;
import domain.Gebruiker;
import domain.ProductAdvertentie;

import java.util.Scanner;

public class PlaatsenAdvertentie {
    public Scanner scanner = new Scanner(System.in);

    public void plaatsenAdvertentie(Dao adDao, Gebruiker gebruiker) {

        while (true) {
            System.out.println("----------------------------------------------");
            System.out.println("Hier maakt u een advertentie aan");
            System.out.println("Wat wilt u aanbieden?");
            System.out.println("----------------------------------------------");

            System.out.println("(D) [Dienst]");
            System.out.println("(P) [Product]");
            System.out.println("(X) [Annuleer]");

            String answer = scanner.nextLine().toUpperCase();

            try {
                switch (answer) {
                    case "D":
                        maakDienstAdvertentie(adDao, gebruiker);
                        break;
                    case "P":
                        maakProductAdvertentie(adDao, gebruiker);
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

    public void maakDienstAdvertentie(Dao adDao, Gebruiker gebruiker) {
        try {
            System.out.println("Titel advertentie:");
            String titel = scanner.nextLine();
            System.out.println("Prijs advertentie:");
            double prijs = Double.parseDouble(scanner.nextLine());
            System.out.println("Omschrijving:");
            String omschrijving = scanner.nextLine();
            DienstAdvertentie dienstAdvertentie = new DienstAdvertentie(titel, prijs, omschrijving);
            adDao.save(dienstAdvertentie);

            dienstAdvertentie.setGebruiker(gebruiker);
            adDao.update(dienstAdvertentie);
        } catch (NumberFormatException e) {
            System.out.println("Voer een numerieke waarde in voor de prijs. Probeer het nog een keer.");
        }
        System.out.println("Uw advertentie is opgeslagen.");
    }

    public void maakProductAdvertentie(Dao adDao, Gebruiker gebruiker) {
        try {
            System.out.println("Titel advertentie:");
            String titel = scanner.nextLine();
            System.out.println("Prijs advertentie:");
            double prijs = Double.parseDouble(scanner.nextLine());
            System.out.println("Omschrijving:");
            String omschrijving = scanner.nextLine();
            ProductAdvertentie productAdvertentie = new ProductAdvertentie(titel, prijs, omschrijving);
            adDao.save(productAdvertentie);

            productAdvertentie.setGebruiker(gebruiker);
            adDao.update(productAdvertentie);
        } catch (NumberFormatException e) {
            System.out.println("Voer een numerieke waarde in voor de prijs. Probeer het nog een keer.");
        }
        System.out.println("Uw advertentie is opgeslagen.");
    }


}


