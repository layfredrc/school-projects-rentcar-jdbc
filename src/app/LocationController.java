package app;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Location;
import model.LocationDAO;
import model.Vehicule;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The type Location controller.
 */
public class LocationController {
    @FXML
    private Button clientBtn;
    @FXML
    private Button vehiculeBtn;
    @FXML
    private Button factureBtn;
    @FXML
    private TextField matricule;
    @FXML
    private TextField idClient;
    @FXML
    private TextField dateDebut;
    @FXML
    private TextField dateFin;
    @FXML
    private TextField idFacture;
    @FXML
    private TextField nbJours;
    @FXML
    private TableColumn<Location,String> colMatricule;
    @FXML
    private TableColumn<Location,Integer> colIdClient;
    @FXML
    private TableColumn<Location,String> colDateDebut;
    @FXML
    private TableColumn<Location,String> colDateFin;
    @FXML
    private TableColumn<Location,Integer> colIdFacture;
    @FXML
    private TableView<Location> tableLocation;
    @FXML
    private TextArea console;

    /**
     * Load client page.
     *
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
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadVehiculePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("vehicule.fxml"));
        Stage window = (Stage) vehiculeBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Load facture page.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadFacturePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("facture.fxml"));
        Stage window = (Stage) factureBtn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     * Insert location.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    public void insertLocation(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            LocationDAO.insertLocation(matricule.getText(),Integer.parseInt(idClient.getText()),dateDebut.getText(),dateFin.getText(),Integer.parseInt(idFacture.getText()),Integer.parseInt(nbJours.getText()));
            initialize();
            console.setText("Ajout d'une location !");
        }catch (SQLException e){
            System.out.println("Exception occured while inserting on table Vehicule" + e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update location.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    public void updateLocation(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            LocationDAO.updateLocation(matricule.getText(),Integer.parseInt(idClient.getText()),dateDebut.getText(),dateFin.getText(),Integer.parseInt(idFacture.getText()));
            initialize();
            console.setText("Modification d'une location !");
        }catch (SQLException e){
            System.out.println("Exception occured while inserting on table Vehicule" + e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete location.
     *
     * @param event the event
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    @FXML
    public void deleteLocation(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            LocationDAO.deleteLocation(matricule.getText(),Integer.parseInt(idClient.getText()),Integer.parseInt(idFacture.getText()));
            initialize();
            console.setText("Supression d'une location !");
        }catch (SQLException e){
            System.out.println("Exception occured while inserting on table Vehicule" + e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initialize.
     *
     * @throws Exception    the exception
     * @throws SQLException the sql exception
     */
    public void initialize() throws Exception,SQLException{
        colMatricule.setCellValueFactory(cellData -> cellData.getValue().matriculeProperty());
        colIdClient.setCellValueFactory(cellData -> cellData.getValue().idClientProperty().asObject());
        colDateDebut.setCellValueFactory(cellData -> cellData.getValue().dateDebutProperty());
        colDateFin.setCellValueFactory(cellData -> cellData.getValue().dateFinProperty());
        colIdFacture.setCellValueFactory(cellData -> cellData.getValue().idFactureProperty().asObject());
        ObservableList<Location> listLocation = null;
        try {
            listLocation = LocationDAO.getAllLocation();

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable(listLocation);
    }


    private void populateTable(ObservableList<Location> listLocation){
        tableLocation.setItems(listLocation);

    }

}
