package domain;

import dao.BezorgwijzeDao;

import javax.persistence.*;

@Entity
public class BezorgwijzeArtikel extends Bezorgwijze {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ProductAdvertentie productAdvertentie;

    public BezorgwijzeArtikel(){

    }

    public BezorgwijzeArtikel(BezorgwijzeOpties bezorgwijzeOpties) {
        super(bezorgwijzeOpties);
    }
}
