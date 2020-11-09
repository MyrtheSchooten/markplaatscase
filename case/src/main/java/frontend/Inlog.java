package frontend;

import domain.Gebruiker;
import util.ScannerWrapper;

import static org.App.gebDao;

public class Inlog {
    ScannerWrapper scanner = new ScannerWrapper();

    public void inlog() {

        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");
            System.out.println("Wat wilt u doen?");
            System.out.println("(1) [Inloggen]");
            System.out.println("(X) [Sluiten]");

            String antwoord = scanner.read().toUpperCase();

            try {
                switch (antwoord) {
                    case "1":
                        inloggenGebruiker();
                        break;
                    case "X":
                        return;
                    default:
                        System.out.println("Voer 1 of X in.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println("Er is iets misgegaan.");
            }
        }
    }

    private void inloggenGebruiker() {
        try {
            System.out.println("Voer uw gebruikersId in.");
            Long gebruikerId = Long.valueOf(scanner.read());
            Gebruiker gebruiker = gebDao.get(gebruikerId);
            if (gebruiker.getId() != null) {new Hoofdpagina().start(gebruiker);}
        } catch (NumberFormatException e) {
            System.out.println("Voer een juiste gebruikersId in.");
        } catch (RuntimeException e) {
            System.out.println("Er bestaat geen account met die gebruikersId, probeer het opnieuw.");
        }
    }
}
