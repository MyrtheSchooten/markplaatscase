package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gebruiker extends  AbstractEntityID<Long> {

    private String gebruikersnaam;
    private String wachtwoord;
    private AccountStatus accountStatus = AccountStatus.ACTIEF;

    @OneToMany(mappedBy = "gebruiker")
    private List<Advertentie> advertenties;

    public Gebruiker() {

    }

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;

    }

    public List<Advertentie> getAdvertenties() {
        return advertenties;
    }

    public void setAdvertenties(List<Advertentie> advertenties) {
        this.advertenties = advertenties;
    }
}
