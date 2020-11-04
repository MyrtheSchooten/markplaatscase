package org;

import dao.AdvertentieDao;
import dao.GebruikerDao;
import domain.Gebruiker;
import frontend.Hoofdpagina;
import frontend.PlaatsenAdvertentie;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

@lombok.extern.slf4j.Slf4j
public class App {

    public static final EntityManager entityManager = Persistence.createEntityManagerFactory("MySQL-marktplaatscase").createEntityManager();
    public static final GebruikerDao gebDao = new GebruikerDao(entityManager);
    public static final AdvertentieDao adDao = new AdvertentieDao(entityManager);

    public static void main(String[] args) {
        PlaatsenAdvertentie plaatsenAdvertentie = new PlaatsenAdvertentie();

        Gebruiker gebruiker1 = new Gebruiker("Gebruiker1", "W8Woord");
        gebDao.save(gebruiker1);
        Gebruiker gebruiker2 = new Gebruiker("Gebruiker2", "ditismijnwachtwoord");
        gebDao.save(gebruiker2);
        Gebruiker gebruiker3 = new Gebruiker("Gebruiker3", "12345");
        gebDao.save(gebruiker3);

        new Hoofdpagina().Start(adDao, gebruiker2);
    }


}
