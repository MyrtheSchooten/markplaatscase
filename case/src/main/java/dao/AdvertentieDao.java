package dao;

import domain.Advertentie;

import javax.persistence.EntityManager;

public class AdvertentieDao extends Dao<Advertentie> {

    public AdvertentieDao(EntityManager entityManager) {
        super(entityManager);
    }
}
