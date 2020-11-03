package domain;

import javax.persistence.*;

@Entity
public class Gebruiker {

    @Id
    @GeneratedValue
    Long id;

    @Basic
    String gebruikersnaam;

    @Basic
    String wachtwoord;

    public Gebruiker() {

    }

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
    }
}
