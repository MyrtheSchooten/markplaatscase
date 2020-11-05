package domain;

import javax.persistence.*;

@Entity
public class BezorgwijzeArtikel extends AbstractEntityID<Long> {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ProductAdvertentie productAdvertentie;

    @Enumerated(value = EnumType.STRING)
    private BezorgwijzeOpties bezorgwijzeOpties;

}
