package domain;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;

@Entity
public class Advertentie extends AbstractEntityID<Long> {

    private String titel;
    private double prijs;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Gebruiker gebruiker;

    @Enumerated(value = EnumType.STRING)
    private StatusAdvertentie statusAdvertentie;

    @Temporal(value = DATE)
    private Date datumGeplaatst = new Date();

    @Lob
    @Basic
    private String omschrijving;

    @Lob
    @Basic(fetch = LAZY)
    private byte[] afbeelding;

    public Advertentie() {
    }

    public Advertentie(String titel, double prijs, String omschrijving) {
        this.titel = titel;
        this.prijs = prijs;
        this.omschrijving = omschrijving;
        this.statusAdvertentie = StatusAdvertentie.TEKOOP;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Gebruiker getGebruiker() {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public byte[] getAfbeelding() {
        return afbeelding;
    }

    public void setAfbeelding(byte[] afbeelding) {
        this.afbeelding = afbeelding;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setStatusAdvertentie(StatusAdvertentie statusAdvertentie) {
        this.statusAdvertentie = statusAdvertentie;
    }

    public StatusAdvertentie getStatusAdvertentie() {
        return statusAdvertentie;
    }

    @Override
    public String toString() {
        return "Advertentie" + "\n" +
                "\t\t" + "Productcode = " + id + "\n" +
                "\t\t" + "Titel = '" + titel + '\'' + "\n" +
                "\t\t" + "Prijs = " + prijs + "\n" +
                "\t\t" + "Verkoper = " + gebruiker.getGebruikersnaam() + "\n" +
                "\t\t" + "DatumGeplaatst = " + datumGeplaatst + "\n" +
                "\t\t" + "Omschrijving = '" + omschrijving + '\'';
    }
}
