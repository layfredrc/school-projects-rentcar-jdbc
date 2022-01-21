package model;

import javafx.beans.property.*;

/**
 * The type Vehicule.
 */
public class Vehicule {
    private StringProperty matricule;
    private StringProperty marque;
    private StringProperty modele;
    private StringProperty kilometrage;
    private StringProperty boite;
    private BooleanProperty climatisation;
    private StringProperty reservoire;
    private StringProperty etat;
    private StringProperty categorie;
    private StringProperty carburant;
    private IntegerProperty tarifJournalier;
    private IntegerProperty caution;

    /**
     * Instantiates a new Vehicule.
     */
    public Vehicule(){
        this.matricule = new SimpleStringProperty();
        this.marque = new SimpleStringProperty();
        this.modele = new SimpleStringProperty();
        this.kilometrage = new SimpleStringProperty();
        this.boite = new SimpleStringProperty();
        this.climatisation = new SimpleBooleanProperty();
        this.reservoire = new SimpleStringProperty();
        this.etat = new SimpleStringProperty();
        this.categorie = new SimpleStringProperty();
        this.carburant = new SimpleStringProperty();
        this.tarifJournalier = new SimpleIntegerProperty();
        this.caution = new SimpleIntegerProperty();
    }


    /**
     * Gets boite.
     *
     * @return the boite
     */
    public String getBoite() {
        return boite.get();
    }

    /**
     * Boite property string property.
     *
     * @return the string property
     */
    public StringProperty boiteProperty() {
        return boite;
    }

    /**
     * Sets boite.
     *
     * @param boite the boite
     */
    public void setBoite(String boite) {
        this.boite.set(boite);
    }

    /**
     * Gets matricule.
     *
     * @return the matricule
     */
    public String getMatricule() {
        return matricule.get();
    }

    /**
     * Matricule property string property.
     *
     * @return the string property
     */
    public StringProperty matriculeProperty() {
        return matricule;
    }

    /**
     * Sets matricule.
     *
     * @param matricule the matricule
     */
    public void setMatricule(String matricule) {
        this.matricule.set(matricule);
    }

    /**
     * Gets marque.
     *
     * @return the marque
     */
    public String getMarque() {
        return marque.get();
    }

    /**
     * Marque property string property.
     *
     * @return the string property
     */
    public StringProperty marqueProperty() {
        return marque;
    }

    /**
     * Sets marque.
     *
     * @param marque the marque
     */
    public void setMarque(String marque) {
        this.marque.set(marque);
    }

    /**
     * Gets modele.
     *
     * @return the modele
     */
    public String getModele() {
        return modele.get();
    }

    /**
     * Modele property string property.
     *
     * @return the string property
     */
    public StringProperty modeleProperty() {
        return modele;
    }

    /**
     * Sets modele.
     *
     * @param modele the modele
     */
    public void setModele(String modele) {
        this.modele.set(modele);
    }

    /**
     * Gets kilometrage.
     *
     * @return the kilometrage
     */
    public String getKilometrage() {
        return kilometrage.get();
    }

    /**
     * Kilometrage property string property.
     *
     * @return the string property
     */
    public StringProperty kilometrageProperty() {
        return kilometrage;
    }

    /**
     * Sets kilometrage.
     *
     * @param kilometrage the kilometrage
     */
    public void setKilometrage(String kilometrage) {
        this.kilometrage.set(kilometrage);
    }


    /**
     * Gets reservoire.
     *
     * @return the reservoire
     */
    public String getReservoire() {
        return reservoire.get();
    }

    /**
     * Reservoire property string property.
     *
     * @return the string property
     */
    public StringProperty reservoireProperty() {
        return reservoire;
    }

    /**
     * Sets reservoire.
     *
     * @param reservoire the reservoire
     */
    public void setReservoire(String reservoire) {
        this.reservoire.set(reservoire);
    }

    /**
     * Gets etat.
     *
     * @return the etat
     */
    public String getEtat() {
        return etat.get();
    }

    /**
     * Etat property string property.
     *
     * @return the string property
     */
    public StringProperty etatProperty() {
        return etat;
    }

    /**
     * Sets etat.
     *
     * @param etat the etat
     */
    public void setEtat(String etat) {
        this.etat.set(etat);
    }

    /**
     * Gets categorie.
     *
     * @return the categorie
     */
    public String getCategorie() {
        return categorie.get();
    }

    /**
     * Categorie property string property.
     *
     * @return the string property
     */
    public StringProperty categorieProperty() {
        return categorie;
    }

    /**
     * Sets categorie.
     *
     * @param categorie the categorie
     */
    public void setCategorie(String categorie) {
        this.categorie.set(categorie);
    }

    /**
     * Gets carburant.
     *
     * @return the carburant
     */
    public String getCarburant() {
        return carburant.get();
    }

    /**
     * Carburant property string property.
     *
     * @return the string property
     */
    public StringProperty carburantProperty() {
        return carburant;
    }

    /**
     * Sets carburant.
     *
     * @param carburant the carburant
     */
    public void setCarburant(String carburant) {
        this.carburant.set(carburant);
    }

    /**
     * Gets tarif journalier.
     *
     * @return the tarif journalier
     */
    public int getTarifJournalier() {
        return tarifJournalier.get();
    }

    /**
     * Tarif journalier property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty tarifJournalierProperty() {
        return tarifJournalier;
    }

    /**
     * Sets tarif journalier.
     *
     * @param tarifJournalier the tarif journalier
     */
    public void setTarifJournalier(int tarifJournalier) {
        this.tarifJournalier.set(tarifJournalier);
    }

    /**
     * Gets caution.
     *
     * @return the caution
     */
    public int getCaution() {
        return caution.get();
    }

    /**
     * Caution property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty cautionProperty() {
        return caution;
    }

    /**
     * Sets caution.
     *
     * @param caution the caution
     */
    public void setCaution(int caution) {
        this.caution.set(caution);
    }

    /**
     * Gets climatisation.
     *
     * @return the climatisation
     */
    public boolean getClimatisation() {
        return climatisation.get();
    }

    /**
     * Climatisation property boolean property.
     *
     * @return the boolean property
     */
    public BooleanProperty climatisationProperty(){
        return  climatisation;
    }

    /**
     * Sets climatisation.
     *
     * @param climatisation the climatisation
     */
    public void setClimatisation(boolean climatisation) {
        this.climatisation.set(climatisation);
    }



}
