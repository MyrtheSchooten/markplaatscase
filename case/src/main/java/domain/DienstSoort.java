package domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DienstSoort extends Soort{

    @OneToMany(mappedBy = "isDienstSoort", fetch = FetchType.EAGER)
    private List<DienstAdvertentie> productenVanSoort = new ArrayList<>();

    public DienstSoort(){

    }

    public DienstSoort(String naamSoort) {
        super(naamSoort);
    }
}
