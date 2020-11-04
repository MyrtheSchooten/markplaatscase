package domain;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductAdvertentie extends Advertentie{

    public ProductAdvertentie() {
    }

    public ProductAdvertentie(String titel, double prijs, String omschrijving) {
        super(titel, prijs, omschrijving);
    }
}
