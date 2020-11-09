package dao;

import domain.Advertentie;
import domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isBlank;

public class AdvertentieDao extends Dao<Advertentie> {

    public AdvertentieDao(EntityManager entityManager) {
        super(entityManager);
    }

    public List<Advertentie> findByNaamTeKoop(String name) {
        return isBlank(name) ? findAllForSale() : findByNameForSalePrivate(name);
    }

    public List<Advertentie> findByNaamGebruiker(String naam, Gebruiker gebruiker) {
        return isBlank(naam) ? findAllPerUser(gebruiker) : findByNameGebruikerPrivate(naam, gebruiker);
    }

    public List<Advertentie> findAllForSale() {
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie e WHERE e.statusAdvertentie = domain.StatusAdvertentie.TEKOOP", Advertentie.class);
        return query.getResultList();
    }

    public List<Advertentie> findAllPerUser(Gebruiker gebruiker) {
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie  e WHERE e.gebruiker = :gebruiker", Advertentie.class);
        query.setParameter("gebruiker", gebruiker);
        return query.getResultList();
    }

    private List<Advertentie> findByNameForSalePrivate(String titel) {
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie e WHERE UPPER(e.titel) LIKE :firstarg AND e.statusAdvertentie = domain.StatusAdvertentie.TEKOOP", Advertentie.class);
        query.setParameter("firstarg", "%" + titel.toUpperCase() + "%");
        return query.getResultList();
    }

    private List<Advertentie> findByNameGebruikerPrivate(String zoekterm, Gebruiker gebruiker) {
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie e WHERE UPPER(e.titel) LIKE :zoekterm AND e.gebruiker = :gebruiker", Advertentie.class);
        query.setParameter("gebruiker", gebruiker);
        query.setParameter("zoekterm", "%" + zoekterm.toUpperCase() + "%");
        return query.getResultList();
    }

}
