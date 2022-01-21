package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Facture.
 */
public class Facture {
    private StringProperty matricule;
    private IntegerProperty idClient;
    private IntegerProperty idFacture;
    private StringProperty reservoire;
    private IntegerProperty duree;
    private IntegerProperty tarifJ;
    private StringProperty etat;

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
     * Gets id client.
     *
     * @return the id client
     */
    public int getIdClient() {
        return idClient.get();
    }

    /**
     * Id client property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty idClientProperty() {
        return idClient;
    }

    /**
     * Sets id client.
     *
     * @param idClient the id client
     */
    public void setIdClient(int idClient) {
        this.idClient.set(idClient);
    }

    /**
     * Gets id facture.
     *
     * @return the id facture
     */
    public int getIdFacture() {
        return idFacture.get();
    }

    /**
     * Id facture property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty idFactureProperty() {
        return idFacture;
    }

    /**
     * Sets id facture.
     *
     * @param idFacture the id facture
     */
    public void setIdFacture(int idFacture) {
        this.idFacture.set(idFacture);
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
     * Gets duree.
     *
     * @return the duree
     */
    public int getDuree() {
        return duree.get();
    }

    /**
     * Duree property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty dureeProperty() {
        return duree;
    }

    /**
     * Sets duree.
     *
     * @param duree the duree
     */
    public void setDuree(int duree) {
        this.duree.set(duree);
    }

    /**
     * Gets tarif j.
     *
     * @return the tarif j
     */
    public int getTarifJ() {
        return tarifJ.get();
    }

    /**
     * Tarif j property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty tarifJProperty() {
        return tarifJ;
    }

    /**
     * Sets tarif j.
     *
     * @param tarifJ the tarif j
     */
    public void setTarifJ(int tarifJ) {
        this.tarifJ.set(tarifJ);
    }


    /**
     * Instantiates a new Facture.
     */
    public Facture(){
        this.matricule = new SimpleStringProperty();
        this.idClient = new SimpleIntegerProperty();
        this.duree = new SimpleIntegerProperty();
        this.reservoire = new SimpleStringProperty();
        this.tarifJ = new SimpleIntegerProperty();
        this.etat = new SimpleStringProperty();
    }
}
