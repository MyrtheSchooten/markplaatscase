package org;

import dao.AdvertentieDao;
import dao.BezorgwijzeDao;
import dao.GebruikerDao;
import domain.Bezorgwijze;
import domain.BezorgwijzeOpties;
import domain.Gebruiker;
import frontend.Hoofdpagina;
import frontend.PlaatsenAdvertentie;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@lombok.extern.slf4j.Slf4j
public class App {

    public static final EntityManager entityManager = Persistence.createEntityManagerFactory("MySQL-marktplaatscase").createEntityManager();
    public static final GebruikerDao gebDao = new GebruikerDao(entityManager);
    public static final AdvertentieDao adDao = new AdvertentieDao(entityManager);
    public static final BezorgwijzeDao bezorgDao = new BezorgwijzeDao(entityManager);

    public static void main(String[] args) {
        PlaatsenAdvertentie plaatsenAdvertentie = new PlaatsenAdvertentie();

        Bezorgwijze afhalenMagazijn = new Bezorgwijze(BezorgwijzeOpties.AFHALENMAGAZIJN);
        Bezorgwijze thuisAfhalen = new Bezorgwijze(BezorgwijzeOpties.THUISAFHALEN);
        Bezorgwijze versturen = new Bezorgwijze(BezorgwijzeOpties.VERSTUREN);
        Bezorgwijze versturenRembours = new Bezorgwijze(BezorgwijzeOpties.VERSTURENREMBOURS);
        bezorgDao.save(afhalenMagazijn);
        bezorgDao.save(thuisAfhalen);
        bezorgDao.save(versturen);
        bezorgDao.save(versturenRembours);

        Gebruiker gebruiker1 = new Gebruiker("Gebruiker1", "W8Woord");
        gebruiker1.addBezorgwijzen(afhalenMagazijn);
        gebruiker1.addBezorgwijzen(thuisAfhalen);
        gebDao.save(gebruiker1);

        Gebruiker gebruiker2 = new Gebruiker("Gebruiker2", "ditismijnwachtwoord");
        gebruiker2.addBezorgwijzen(versturen);
        gebDao.save(gebruiker2);

        Gebruiker gebruiker3 = new Gebruiker("Gebruiker3", "12345");
        gebruiker3.addBezorgwijzen(versturen);
        gebruiker3.addBezorgwijzen(versturenRembours);
        gebDao.save(gebruiker3);

        new Hoofdpagina().Start(adDao, gebruiker2);
    }


}
