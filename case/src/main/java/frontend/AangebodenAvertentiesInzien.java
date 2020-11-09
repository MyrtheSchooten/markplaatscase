package frontend;

import domain.Advertentie;
import domain.Gebruiker;
import util.ScannerWrapper;

import java.util.List;

import static org.App.adDao;

public class AangebodenAvertentiesInzien {
    public ScannerWrapper scanner = new ScannerWrapper();

    public void aangebodenAdvertentiesInzien(Gebruiker gebruiker) {

        while (true) {
            System.out.println("********* " + getClass().getSimpleName() + " *********");

            List<Advertentie> lijstVanAangeboden = adDao.findAllForSale();
            if (lijstVanAangeboden.size() != 0) {
                System.out.println("Dit zijn alle aangeboden advertenties: ");
                lijstVanAangeboden.forEach(e -> System.out.println("\t" + e.toString()));
            } else {
                System.out.println("Er worden nog geen advertenties aangeboden.");
            }

            System.out.println("----------------------------------------------");
            System.out.println("Voer hier een zoekterm in om te zoeken op naam");
            System.out.println("Voer X in om terug te gaan naar de hoofdpagina.");
            System.out.println("----------------------------------------------");

            String zoekterm = scanner.read().toUpperCase();

            if (zoekterm.equals("X")) {
                return;
            } else {
                simpelZoeken(zoekterm);
            }
        }
    }

    private void simpelZoeken(String zoekterm) {
        List<Advertentie> result = adDao.findByNaamTeKoop(zoekterm);
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

