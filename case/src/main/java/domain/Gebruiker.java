package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Gebruiker extends  AbstractEntityID<Long> {

    private String gebruikersnaam;
    private String wachtwoord;
    private AccountStatus accountStatus = AccountStatus.ACTIEF;

    @OneToMany(mappedBy = "gebruiker")
    private List<Advertentie> advertenties;

    @ManyToMany
    @JoinTable(
            name = "gebruiker_bezorgwijzen",
            joinColumns = @JoinColumn(name = "gebruiker_id"),
            inverseJoinColumns = @JoinColumn(name = "bezorgwijze_id"))
    private List<Bezorgwijze> gekozenBezorgwijzen = new ArrayList<>();

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

    public void addBezorgwijzen(Bezorgwijze bezorgwijze) {
        System.out.println("Dit zijn de bezro sa:" + bezorgwijze.getBezorgwijzeOpties());
        this.gekozenBezorgwijzen.add(bezorgwijze);
    }

}
