package dao;

import domain.Gebruiker;

import javax.persistence.EntityManager;

public class GebruikerDao extends Dao<Gebruiker> {

    public GebruikerDao(EntityManager entityManager) {
        super(entityManager);
    }

}
