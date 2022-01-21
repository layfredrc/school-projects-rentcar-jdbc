package app;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Facture;
import model.FactureDAO;

import java.io.IOException;
import java.sql.SQLException;


/**
 * The type Facture controller.
 */
public class FactureController {
    @FXML
    private Button clientBtn;
    @FXML
    private Button vehiculeBtn;
    @FXML
    private Button locationBtn;
    @FXML
    private TextField inputMatricule;
    @FXML
    private TextField inputIdClient;
    @FXML
    private TextField inputIdFacture;
    @FXML
    private TextArea factureTxt;
    @FXML
    private Button getFacture;

    /**
     * Load client page.
     * methode pour changer de page vers client
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadClientPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("client.fxml"));
        Stage window = (Stage) clientBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Load vehicule page.
     * methode pour changer de page vers vehicule
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadVehiculePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vehicule.fxml"));
        Stage window = (Stage) vehiculeBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Load location page.
     *methode pour changer de page vers location
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadLocationPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location.fxml"));
        Stage window = (Stage) locationBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }


    /**
     * Gets duree.
     *
     * @return the duree
     * Recuperation de la duree d'une location par un client
     * Nous utiliserons cette valeur pour calculer le prix total de la facture
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public int getDuree()throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Facture> listDuree = FactureDAO.getDureeLocation(Integer.parseInt(inputIdFacture.getText()));
            int duree = listDuree.get(0).getDuree();
            return duree;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Facture table" + e);
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Gets tarif j.
     * Recuperation du tarif j d'une location par un client
     * Nous utiliserons cette valeur pour calculer le prix total de la facture
     * @return the tarif j
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public int getTarifJ()throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Facture> listDuree = FactureDAO.getTarifJLocation(inputMatricule.getText());
            int duree = listDuree.get(0).getTarifJ();
            return duree;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Facture table" + e);
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Gets etat.
     *
     * @return the etat
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public String getEtat()throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Facture> listEtat = FactureDAO.getEtatVehicule(inputMatricule.getText());
            String duree = listEtat.get(0).getEtat();
            return duree;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Facture table" + e);
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * Gets reservoire.
     *
     * @return the reservoire
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public String getReservoire()throws ClassNotFoundException, SQLException {
        try {
            ObservableList<Facture> listReservoire = FactureDAO.getReservoirVehicule(inputMatricule.getText());
            String reservoire = listReservoire.get(0).getEtat();
            return reservoire;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Facture table" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets facture.
     *  Nous appellons toutes les méthodes getter pour effectuer les calculs
     *  et afficher les informations sur la facture
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public void getFacture() throws ClassNotFoundException,SQLException{
        try {
            int duree = getDuree();
            int tarifJ = getTarifJ();
            String etat = getEtat();
            String reservoire = getReservoire();
            int prixAssuranceToutRisque = 400;
            int prixAssuranceAccident = 200;
            int prixDegatSansAssurance = 1000;
            int prixRetard = 150;
            int prixReservoire = 0;
            switch (reservoire){
                case "VIDE":
                    prixReservoire = 60;
                    break;
                case "3/4":
                    prixReservoire = 15;
                    break;
                case "1/2":
                    prixReservoire = 30;
                    break;
                case "1/4":
                    prixReservoire = 45;
                    break;
            }

            factureTxt.setText("Facture pour le client :" + inputIdClient.getText() + "\nVehicule loué : " + inputMatricule.getText()
            + "\n Tarif Journalier : " + tarifJ + "\nDurée de la location : " + duree + "\nEtat du vehicule : " + etat
            + "\nEtat du reservoire : " + reservoire + "\nFrais de carburant: " + prixReservoire + "\n(Frais Assurance tout risque) : "
            + prixAssuranceToutRisque + "\n(Frais Assurance accident) :" + prixAssuranceAccident + "\n(Prix Retard) : " + prixRetard
            + "\n(Frais dégât sans Assurance) : " + prixDegatSansAssurance + "\n TOTAL : " + (duree*tarifJ+prixReservoire)+ "€\n **Ajout des frais si applicable.");

        }catch (SQLException e){
            System.out.println("Error occured while Select in Facture table" + e);
            e.printStackTrace();
            throw e;
        }
    }

}
