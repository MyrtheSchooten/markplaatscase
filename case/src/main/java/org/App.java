package org;

import dao.AdvertentieDao;
import dao.BezorgwijzeDao;
import dao.GebruikerDao;
import dao.SoortDao;
import domain.*;
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
    public static final SoortDao soortDao = new SoortDao(entityManager);


    public static void main(String[] args) {
        PlaatsenAdvertentie plaatsenAdvertentie = new PlaatsenAdvertentie();

        BezorgwijzeGebruiker afhalenMagazijn = new BezorgwijzeGebruiker(BezorgwijzeOpties.AFHALENMAGAZIJN);
        BezorgwijzeGebruiker thuisAfhalen = new BezorgwijzeGebruiker(BezorgwijzeOpties.THUISAFHALEN);
        BezorgwijzeGebruiker versturen = new BezorgwijzeGebruiker(BezorgwijzeOpties.VERSTUREN);
        BezorgwijzeGebruiker versturenRembours = new BezorgwijzeGebruiker(BezorgwijzeOpties.VERSTURENREMBOURS);
        bezorgDao.save(afhalenMagazijn);
        bezorgDao.save(thuisAfhalen);
        bezorgDao.save(versturen);
        bezorgDao.save(versturenRembours);

        ProductSoort fiets = new ProductSoort("fiets");
        ProductSoort boek = new ProductSoort("boek");
        DienstSoort fietsenMaker = new DienstSoort("fietsenmaker");
        DienstSoort schilder = new DienstSoort("schilder");
        soortDao.save(fiets);
        soortDao.save(boek);
        soortDao.save(fietsenMaker);
        soortDao.save(schilder);

        Gebruiker gebruiker1 = new Gebruiker("Gebruiker1", "W8Woord");
        gebruiker1.addGebruikerBezorgwijzen(afhalenMagazijn);
        gebruiker1.addGebruikerBezorgwijzen(thuisAfhalen);
        gebDao.save(gebruiker1);

        Gebruiker gebruiker2 = new Gebruiker("Gebruiker2", "ditismijnwachtwoord");
        gebruiker2.addGebruikerBezorgwijzen(versturen);
        gebDao.save(gebruiker2);

        Gebruiker gebruiker3 = new Gebruiker("Gebruiker3", "12345");
        gebruiker3.addGebruikerBezorgwijzen(versturen);
        gebruiker3.addGebruikerBezorgwijzen(versturenRembours);
        gebDao.save(gebruiker3);

        new Hoofdpagina().Start(adDao, gebruiker2);
    }


}
