package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Gebruiker extends  AbstractEntityID<Long> {

    private String gebruikersnaam;
    private String wachtwoord;

    @Enumerated(value = EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "gebruiker")
    private List<Advertentie> advertenties;

    @ManyToMany
    @JoinTable(
            name = "gebruiker_bezorgwijzen",
            joinColumns = @JoinColumn(name = "gebruiker_id"),
            inverseJoinColumns = @JoinColumn(name = "bezorgwijze_id"))
    private List<BezorgwijzeGebruiker> gekozenBezorgwijzen = new ArrayList<>();

    public Gebruiker() {

    }

    public Gebruiker(String gebruikersnaam, String wachtwoord) {
        this.gebruikersnaam = gebruikersnaam;
        this.wachtwoord = wachtwoord;
        this.accountStatus = AccountStatus.ACTIEF;

    }

    public void addGebruikerBezorgwijzen(BezorgwijzeGebruiker bezorgwijzeGebruiker) {
        this.gekozenBezorgwijzen.add(bezorgwijzeGebruiker);
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }
}
