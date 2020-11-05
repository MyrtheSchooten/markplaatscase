package domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bezorgwijze extends AbstractEntityID<Long> {

    @ManyToMany(mappedBy = "gekozenBezorgwijzen")
    List<Gebruiker> gebruikersVanBezorgwijze = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    BezorgwijzeOpties bezorgwijzeOpties;

    public Bezorgwijze() {
    }

    public Bezorgwijze(BezorgwijzeOpties bezorgwijzeOpties) {
        this.bezorgwijzeOpties = bezorgwijzeOpties;
    }

    public BezorgwijzeOpties getBezorgwijzeOpties() {
        return bezorgwijzeOpties;
    }

    public void setBezorgwijzeOpties(BezorgwijzeOpties bezorgwijzeOpties) {
        this.bezorgwijzeOpties = bezorgwijzeOpties;
    }
}
