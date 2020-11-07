package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Bezorgwijze extends AbstractEntityID<Long> {
    @Enumerated(value = EnumType.STRING)
    BezorgwijzeOpties bezorgwijzeOpties;

    public  Bezorgwijze(){

    }
    public Bezorgwijze(BezorgwijzeOpties bezorgwijzeOpties) {
        this.bezorgwijzeOpties = bezorgwijzeOpties;
    }
}
