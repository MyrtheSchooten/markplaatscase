package dao;

import domain.Bezorgwijze;
import domain.BezorgwijzeGebruiker;

import javax.persistence.EntityManager;

public class BezorgwijzeDao extends Dao<Bezorgwijze> {

    public BezorgwijzeDao(EntityManager entityManager) {
        super(entityManager);
    }
}
