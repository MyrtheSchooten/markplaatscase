package frontend;

import dao.Dao;
import domain.Advertentie;
import domain.DienstAdvertentie;
import domain.Gebruiker;
import domain.ProductAdvertentie;

import java.util.Scanner;

public class PlaatsenAdvertentie {
    public Scanner scanner = new Scanner(System.in);

    public void plaatsenAdvertentie(Dao<Advertentie> adDao, Gebruiker gebruiker) {

        while (true) {

            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("----------------------------------------------");
            System.out.println("Hier plaatst u uw advertentie.");
            System.out.println("Wat wilt u aanbieden?");
            System.out.println("----------------------------------------------");

            System.out.println("(D) [Dienst]");
            System.out.println("(P) [Product]");
            System.out.println("(X) [Terug naar hoofdmenu.]");

            String antwoord = scanner.nextLine().toUpperCase();

            try {
                switch (antwoord) {
                    case "D":
                        maakAdvertentie(adDao, gebruiker, true);
                        break;
                    case "P":
                        maakAdvertentie(adDao, gebruiker, false);
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

    public void maakAdvertentie(Dao<Advertentie> adDao, Gebruiker gebruiker, boolean isDienst) {
        try {
            System.out.println("Titel advertentie:");
            String titel = scanner.nextLine();
            System.out.println("Prijs advertentie:");
            double prijs = Double.parseDouble(scanner.nextLine());
            System.out.println("Omschrijving (indien n.v.t. niets invullen):");
            String omschrijving = scanner.nextLine();

            Advertentie advertentie = isDienst ?
                    new DienstAdvertentie(titel, prijs, omschrijving) :
                    new ProductAdvertentie(titel, prijs, omschrijving);

            adDao.save(advertentie);
            advertentie.setGebruiker(gebruiker);
            adDao.update(advertentie);

            System.out.println("----------------------------------------------");
            System.out.println("Uw advertentie is opgeslagen.");
            System.out.println("U kunt nu via \"mijn advertenties\" een afbeelding toevoegen, aangeven welke soort product/dienst u heeft aangeboden en evt bezorgwijzen kiezen.");
            System.out.println("Druk een toets in om verder te gaan");
            System.out.println("----------------------------------------------");

            String verderGaan = scanner.nextLine();

        } catch (NumberFormatException e) {
            System.out.println("Voer een numerieke waarde in voor de prijs. Probeer het nog een keer.");
        }
    }

   /* private void afbeeldingToevoegen() {
        try {
            System.out.println("Voeg een afbeelding toe:");
            System.out.println("Hard gecodeerd: C:\\Afbeeldingen\\markplaatscase");

            Path path = Paths.get("C:\\Afbeeldingen\\markplaatscase\\advertentieafbeelding.jpg");
            byte[] afbeelding = Files.readAllBytes(path);
        } catch (IOException e) {
            System.out.println("Geen afbeelding gevonden.");
        }
    }*/


}


