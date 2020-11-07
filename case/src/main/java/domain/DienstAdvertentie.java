package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class DienstAdvertentie extends Advertentie {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private DienstSoort isDienstSoort;

    public DienstAdvertentie() {
    }

    public DienstAdvertentie(String titel, double prijs, String omschrijving) {
        super(titel, prijs, omschrijving);
    }

    public void setIsDienstSoort(DienstSoort isDienstSoort) {
        this.isDienstSoort = isDienstSoort;
    }
}
