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

    public List<Advertentie> findByNaam(String name) {
        return isBlank(name) ? findAllForSale() : findByName(name);
    }

    public List<Advertentie> findAllForSale() {
        return entityManager.createQuery("SELECT e FROM Advertentie e WHERE e.statusAdvertentie = domain.StatusAdvertentie.TEKOOP").getResultList();
    }

    public List<Advertentie> findAllPerUser(Gebruiker gebruiker) {
        return entityManager.createQuery("SELECT e FROM Advertentie e WHERE e.gebruiker = :firstarg").getResultList();
    }

    private List<Advertentie> findByName(String titel) {
        TypedQuery<Advertentie> query = entityManager.createQuery("SELECT e FROM Advertentie e WHERE UPPER(e.titel) LIKE :firstarg", Advertentie.class);
        query.setParameter("firstarg", "%" + titel.toUpperCase() + "%");
        return query.getResultList();
    }

   /* public List<Advertentie> uitgebreidZoekenDienst(String zoektermTitel, double maxPrijs) {
        return entityManager.createQuery("SELECT e FROM DienstAdvertentie e WHERE UPPER(e.titel) LIKE :firstarg AND UPPER(e.prijs) < :secondarg").getResultList();
    }

    public List<Advertentie> uitgebreidZoekenProduct(String zoektermTitel, double maxPrijs){
        return null;
    }*/

}
