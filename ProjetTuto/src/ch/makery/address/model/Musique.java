package ch.makery.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Michaël on 29/04/2017.
 */
public class Musique {

    private final StringProperty nomDeGroupe;
    private final StringProperty style;
    private final StringProperty country;
    private final StringProperty categorie;
    private final ObjectProperty<LocalDate> sortie;

    public Musique() {
        this(null,null,null,null);
    }

    public Musique(String firstName, String style,String country,String categorie) {
        this.nomDeGroupe = new SimpleStringProperty(firstName);
        this.country = new SimpleStringProperty(country);
        this.style = new SimpleStringProperty(style);
        this.categorie = new SimpleStringProperty(categorie);
        this.sortie = new SimpleObjectProperty<LocalDate>(LocalDate.of(1999, 2, 21));
    }

    public String getNomDeGroupe() {
        return nomDeGroupe.get();
    }

    public void setNomDeGroupe(String nomDeGroupe) {
        this.nomDeGroupe.set(nomDeGroupe);
    }

    public StringProperty nomDeGroupeProperty() {
        return nomDeGroupe;
    }

    public String getCountry() {
        return country.get();
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public StringProperty countryProperty() {
        return country;
    }

    public String getStryle() {
        return style.get();
    }

    public void setStyle(String style) {
        this.style.set(style);
    }

    public StringProperty styleProperty() {
        return style;
    }

    public LocalDate getSortie() {
        return sortie.get();
    }

    public void setSortie(LocalDate sortie) {
        this.sortie.set(sortie);
    }

    public ObjectProperty<LocalDate> sortieProperty() {
        return sortie;
    }

    public String getCategorie() {
        return categorie.get();
    }

    public void setCategorie(String categorie) {
        this.categorie.set(categorie);
    }

    public StringProperty categorieProperty() {
        return categorie;
    }

}