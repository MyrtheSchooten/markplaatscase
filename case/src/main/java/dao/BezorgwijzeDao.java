package dao;

import domain.BezorgwijzeGebruiker;

import javax.persistence.EntityManager;

public class BezorgwijzeDao extends Dao<BezorgwijzeGebruiker> {

    public BezorgwijzeDao(EntityManager entityManager) {
        super(entityManager);
    }
}
