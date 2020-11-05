package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BezorgwijzeGebruiker extends AbstractEntityID<Long> {

    @ManyToMany(mappedBy = "gekozenBezorgwijzen")
    List<Gebruiker> gebruikersVanBezorgwijze = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    BezorgwijzeOpties bezorgwijzeOpties;

    public BezorgwijzeGebruiker() {
    }

    public BezorgwijzeGebruiker(BezorgwijzeOpties bezorgwijzeOpties) {
        this.bezorgwijzeOpties = bezorgwijzeOpties;
    }

}
