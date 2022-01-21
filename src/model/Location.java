package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Location.
 */
public class Location {
    private StringProperty matricule;
    private IntegerProperty idClient;
    private StringProperty dateDebut;
    private StringProperty dateFin;

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
     * Gets date debut.
     *
     * @return the date debut
     */
    public String getDateDebut() {
        return dateDebut.get();
    }

    /**
     * Date debut property string property.
     *
     * @return the string property
     */
    public StringProperty dateDebutProperty() {
        return dateDebut;
    }

    /**
     * Sets date debut.
     *
     * @param dateDebut the date debut
     */
    public void setDateDebut(String dateDebut) {
        this.dateDebut.set(dateDebut);
    }

    /**
     * Gets date fin.
     *
     * @return the date fin
     */
    public String getDateFin() {
        return dateFin.get();
    }

    /**
     * Date fin property string property.
     *
     * @return the string property
     */
    public StringProperty dateFinProperty() {
        return dateFin;
    }

    /**
     * Sets date fin.
     *
     * @param dateFin the date fin
     */
    public void setDateFin(String dateFin) {
        this.dateFin.set(dateFin);
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

    private IntegerProperty idFacture;

    /**
     * Instantiates a new Location.
     */
    public Location(){
        this.matricule = new SimpleStringProperty();
        this.idClient = new SimpleIntegerProperty();
        this.dateDebut = new SimpleStringProperty();
        this.dateFin = new SimpleStringProperty();
        this.idFacture = new SimpleIntegerProperty();
    }
}
