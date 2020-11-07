package domain;

import javax.persistence.Entity;

@Entity
public class Soort extends AbstractEntityID<Long> {

    private String naamSoort;

    public Soort(){

    }

    public Soort(String naamSoort) {
        this.naamSoort = naamSoort;
    }
}
