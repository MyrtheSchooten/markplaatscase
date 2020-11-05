package dao;

import domain.Bezorgwijze;

import javax.persistence.EntityManager;

public class BezorgwijzeDao extends Dao<Bezorgwijze> {

    public BezorgwijzeDao(EntityManager entityManager) {
        super(entityManager);
    }
}
