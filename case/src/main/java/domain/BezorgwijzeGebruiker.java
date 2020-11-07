package domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BezorgwijzeGebruiker extends Bezorgwijze {

    @ManyToMany(mappedBy = "gekozenBezorgwijzen")
    List<Gebruiker> gebruikersVanBezorgwijze = new ArrayList<>();

    public  BezorgwijzeGebruiker(){

    }
    public BezorgwijzeGebruiker(BezorgwijzeOpties bezorgwijzeOpties) {
        super(bezorgwijzeOpties);
    }
}
