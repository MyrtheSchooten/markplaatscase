package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProductSoort extends Soort{

    @OneToMany(mappedBy = "isProductSoort", fetch = FetchType.EAGER)
    private List<ProductAdvertentie> productenVanSoort = new ArrayList<>();

    private String naamSoort;

    public ProductSoort(){

    }

    public ProductSoort(String naamSoort) {
        super(naamSoort);
    }
}
