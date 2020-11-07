package dao;

import domain.ProductSoort;
import domain.Soort;

import javax.persistence.EntityManager;

public class SoortDao extends Dao<Soort> {

    public SoortDao(EntityManager entityManager) {
        super(entityManager);
    }

}
