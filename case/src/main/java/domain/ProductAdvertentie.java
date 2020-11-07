package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductAdvertentie extends Advertentie{

    @OneToMany(mappedBy = "productAdvertentie", fetch = FetchType.EAGER)
    private List<BezorgwijzeArtikel> bezorgwijzenVoorAdvertentie = new ArrayList<>();


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ProductSoort isProductSoort;

    public ProductAdvertentie() {
    }

    public ProductAdvertentie(String titel, double prijs, String omschrijving) {
        super(titel, prijs, omschrijving);
    }

    public void addProductBezorgwijzen(BezorgwijzeArtikel bezorgwijzeArtikel) {
        this.bezorgwijzenVoorAdvertentie.add(bezorgwijzeArtikel);
    }

    public void setIsProductSoort(ProductSoort isProductSoort) {
        this.isProductSoort = isProductSoort;
    }
}
