package domain;

import javax.persistence.Entity;

@Entity
public class DienstAdvertentie extends Advertentie {

    public DienstAdvertentie() {
    }

    public DienstAdvertentie(String titel, double prijs, String omschrijving) {
        super(titel, prijs, omschrijving);
    }
}
