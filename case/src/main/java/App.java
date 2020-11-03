import dao.GebruikerDao;
import domain.Gebruiker;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@lombok.extern.slf4j.Slf4j
public class App {

    public static void main(String[] args) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("MySQL-marktplaatscase").createEntityManager();
        GebruikerDao dao = new GebruikerDao(entityManager);

        new App().maakEnBewaarGebruikers(dao);
    }

    public void maakEnBewaarGebruikers(GebruikerDao dao) {
        Gebruiker gebruiker1 = new Gebruiker("Gebruiker1", "W8Woord");
        dao.saveAndDetach(gebruiker1);

        Gebruiker gebruiker2 = new Gebruiker("Gebruiker2", "ditismijnwachtwoord");
        dao.saveAndDetach(gebruiker2);

        Gebruiker gebruiker3 = new Gebruiker("Gebruiker3", "12345");
        dao.saveAndDetach(gebruiker3);
    }
}
