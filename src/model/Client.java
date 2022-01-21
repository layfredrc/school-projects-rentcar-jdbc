package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * The type Client.
 */
public class Client {
    private IntegerProperty idClient;
    private StringProperty nomClient;
    private StringProperty prenomClient;
    private StringProperty emailClient;
    private StringProperty telClient;
    private StringProperty rueClient;
    private StringProperty villeClient;
    private IntegerProperty codePostalClient;
    private IntegerProperty nbLocation;

    /**
     * Instantiates a new Client.
     */
    public Client() {
        this.idClient = new SimpleIntegerProperty();
        this.nomClient = new SimpleStringProperty();
        this.prenomClient = new SimpleStringProperty();
        this.emailClient = new SimpleStringProperty();
        this.telClient = new SimpleStringProperty();
        this.rueClient = new SimpleStringProperty();
        this.villeClient = new SimpleStringProperty();
        this.codePostalClient = new SimpleIntegerProperty();
        this.nbLocation = new SimpleIntegerProperty();
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
     * Gets nom client.
     *
     * @return the nom client
     */
    public String getNomClient() {
        return nomClient.get();
    }

    /**
     * Nom client property string property.
     *
     * @return the string property
     */
    public StringProperty nomClientProperty() {
        return nomClient;
    }

    /**
     * Sets nom client.
     *
     * @param nomClient the nom client
     */
    public void setNomClient(String nomClient) {
        this.nomClient.set(nomClient);
    }

    /**
     * Gets prenom client.
     *
     * @return the prenom client
     */
    public String getPrenomClient() {
        return prenomClient.get();
    }

    /**
     * Prenom client property string property.
     *
     * @return the string property
     */
    public StringProperty prenomClientProperty() {
        return prenomClient;
    }

    /**
     * Sets prenom client.
     *
     * @param prenomClient the prenom client
     */
    public void setPrenomClient(String prenomClient) {
        this.prenomClient.set(prenomClient);
    }

    /**
     * Gets email client.
     *
     * @return the email client
     */
    public String getEmailClient() {
        return emailClient.get();
    }

    /**
     * Email client property string property.
     *
     * @return the string property
     */
    public StringProperty emailClientProperty() {
        return emailClient;
    }

    /**
     * Sets email client.
     *
     * @param emailClient the email client
     */
    public void setEmailClient(String emailClient) {
        this.emailClient.set(emailClient);
    }

    /**
     * Gets tel client.
     *
     * @return the tel client
     */
    public String getTelClient() {
        return telClient.get();
    }

    /**
     * Tel client property string property.
     *
     * @return the string property
     */
    public StringProperty telClientProperty() {
        return telClient;
    }

    /**
     * Sets tel client.
     *
     * @param telClient the tel client
     */
    public void setTelClient(String telClient) {
        this.telClient.set(telClient);
    }

    /**
     * Gets rue client.
     *
     * @return the rue client
     */
    public String getRueClient() {
        return rueClient.get();
    }

    /**
     * Rue client property string property.
     *
     * @return the string property
     */
    public StringProperty rueClientProperty() {
        return rueClient;
    }

    /**
     * Sets rue client.
     *
     * @param rueClient the rue client
     */
    public void setRueClient(String rueClient) {
        this.rueClient.set(rueClient);
    }

    /**
     * Gets ville client.
     *
     * @return the ville client
     */
    public String getVilleClient() {
        return villeClient.get();
    }

    /**
     * Ville client property string property.
     *
     * @return the string property
     */
    public StringProperty villeClientProperty() {
        return villeClient;
    }

    /**
     * Sets ville client.
     *
     * @param villeClient the ville client
     */
    public void setVilleClient(String villeClient) {
        this.villeClient.set(villeClient);
    }

    /**
     * Gets code postal client.
     *
     * @return the code postal client
     */
    public int getCodePostalClient() {
        return codePostalClient.get();
    }

    /**
     * Code postal client property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty codePostalClientProperty() {
        return codePostalClient;
    }

    /**
     * Sets code postal client.
     *
     * @param codePostalClient the code postal client
     */
    public void setCodePostalClient(int codePostalClient) {
        this.codePostalClient.set(codePostalClient);
    }


    /**
     * Gets nb location.
     *
     * @return the nb location
     */
    public int getNbLocation() {
        return nbLocation.get();
    }

    /**
     * Nb location property integer property.
     *
     * @return the integer property
     */
    public IntegerProperty nbLocationProperty() {
        return nbLocation;
    }

    /**
     * Sets nb location.
     *
     * @param nbLocation the nb location
     */
    public void setNbLocation(int nbLocation) {
        this.nbLocation.set(nbLocation);
    }



}
