package app;
import com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping;
import db.DBUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import model.Vehicule;
import model.VehiculeDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * The type Vehicule controller.
 */
public class VehiculeController  {
    @FXML
    private Button clientBtn;
    @FXML
    private Button locationBtn;
    @FXML
    private Button factureBtn;
    @FXML
    private TextField inputMatricule;
    @FXML
    private TextField inputMarque;
    @FXML
    private TextField inputModele;
    @FXML
    private TextField inputKilometrage;
    @FXML
    private TextField inputTarifJournalier;
    @FXML
    private TextField inputCaution;
    @FXML
    private ChoiceBox<String> cbBoite;
    @FXML
    private ChoiceBox<String> cbReservoire;
    @FXML
    private ChoiceBox<String> cbCategorie;
    @FXML
    private ChoiceBox<String> cbCarburant;
    @FXML
    private ChoiceBox<String> cbEtat;
    @FXML
    private RadioButton climatisation;
    @FXML
    private TextArea console;
    @FXML
    private TableColumn<Vehicule,String> colMatricule;
    @FXML
    private TableColumn<Vehicule,String> colMarque;
    @FXML
    private TableColumn<Vehicule,String> colModele;
    @FXML
    private TableColumn<Vehicule,String> colKilometrage;
    @FXML
    private TableColumn<Vehicule,String> colBoite;
    @FXML
    private TableColumn<Vehicule,Boolean> colClimatisation;
    @FXML
    private TableColumn<Vehicule,String> colReservoire;
    @FXML
    private TableColumn<Vehicule,String> colEtat;
    @FXML
    private TableColumn<Vehicule,String> colCategorie;
    @FXML
    private TableColumn<Vehicule,String> colCarburant;
    @FXML
    private TableColumn<Vehicule,Integer> colTarifJour;
    @FXML
    private TableColumn<Vehicule,Integer> colCaution;
    @FXML
    private TableView<Vehicule> tableVehicule;


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
     * Load location page.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    public void loadLocationPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("location.fxml"));
        Stage window = (Stage) locationBtn.getScene().getWindow();
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
    // Ajoute un nouveau véhicule dans la table Vehicule
    // Climatisation étant un radio button, si il est selectionné nous prendrons la valeur 1 en int et sinon 0
    // Recuperation des champs saisie par l'utilisateur pour les insérer dans la requete de vehiculeDAO
    @FXML
    private void insertVehicule(ActionEvent event) throws ClassNotFoundException, SQLException{
        try {
            int climatisationValue;
            if (climatisation.isSelected()){
                climatisationValue = 1;
            }else{
                climatisationValue = 0;
            }

            VehiculeDAO.insertVehicule(inputMatricule.getText(),inputMarque.getText(),inputModele.getText()
                    ,inputKilometrage.getText(),String.valueOf(cbBoite.getSelectionModel().getSelectedItem())
                    ,climatisationValue,String.valueOf(cbReservoire.getSelectionModel().getSelectedItem())
                    ,String.valueOf(cbEtat.getSelectionModel().getSelectedItem()),String.valueOf(cbCategorie.getSelectionModel().getSelectedItem())
                    ,String.valueOf(cbCarburant.getSelectionModel().getSelectedItem()),Integer.parseInt(inputTarifJournalier.getText())
                    ,Integer.parseInt(inputCaution.getText()));
            initialize();
            console.setText("Vehicule ajouté à la table VEHICULE !");
        }catch (SQLException e){
            System.out.println("Exception occured while inserting on table Vehicule" + e);
            e.printStackTrace();
            throw e;
        }
    }

    // Modifie un véhicule dans la table Vehicule
    // Climatisation étant un radio button, si il est selectionné nous prendrons la valeur 1 en int et sinon 0
    // Recuperation des champs saisie par l'utilisateur pour les insérer dans la requete de vehiculeDAO
    @FXML
    private void updateVehicule(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            int climatisationValue;
            if (climatisation.isSelected()){
                climatisationValue = 1;
            }else {
                climatisationValue = 0;
            }
            VehiculeDAO.updateVehicule(inputMatricule.getText(),inputMarque.getText(),inputModele.getText(),inputKilometrage.getText()
                    ,String.valueOf(cbBoite.getSelectionModel().getSelectedItem()),climatisationValue,String.valueOf(cbReservoire.getSelectionModel().getSelectedItem())
                    ,String.valueOf(cbEtat.getSelectionModel().getSelectedItem()),String.valueOf(cbCategorie.getSelectionModel().getSelectedItem())
                    ,String.valueOf(cbCarburant.getSelectionModel().getSelectedItem()),Integer.parseInt(inputTarifJournalier.getText())
                            ,Integer.parseInt(inputCaution.getText()));
            initialize();
            console.setText("Vehicule mis à jour !");
        }   catch (SQLException e){
            System.out.println("Error While updating un table Vehicule" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Supprime un véhicule dans la table Vehicule
    // Recuperation des champs saisie par l'utilisateur pour les insérer dans la requete de vehiculeDAO
    @FXML
    private void deleteVehicule(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            VehiculeDAO.deleteVehicule(inputMatricule.getText());
            initialize();
            console.setText("Vehicule supprimé !");
        }catch (SQLException e){
            System.out.println("Error while deleting in the Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Affichage des véhicules selon la marque saisie par l'utilisateur
    @FXML
    private void getVehiculeByMarque(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Vehicule> listeVehiculeByMarque =  VehiculeDAO.getVehiculeByMarque(inputMarque.getText());
            populateTable(listeVehiculeByMarque);
            console.setText("Affichage des véhicules par marque !");
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Affichage des vehicule de catégorie economique
    @FXML
    private void getVehiculeEconomique(ActionEvent event) throws  ClassNotFoundException,SQLException{
        try {
            ObservableList<Vehicule> listVehiculeEconomique = VehiculeDAO.getVehiculeEconomique();
            populateTable(listVehiculeEconomique);
            console.setText("Affichage des véhicules de la catégorie économique !");
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Affichage des vehicule de catégorie confort
    @FXML
    private void getVehiculeConfort(ActionEvent event) throws  ClassNotFoundException,SQLException{
        try {
            ObservableList<Vehicule> listVehiculeConfort = VehiculeDAO.getVehiculeConfort();
            populateTable(listVehiculeConfort);
            console.setText("Affichage des véhicules de la catégorie économique !");
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Affichage des vehicule de catégorie luxe
    @FXML
    private void getVehiculeLuxe(ActionEvent event) throws  ClassNotFoundException,SQLException{
        try {
            ObservableList<Vehicule> listVehiculeLuxe = VehiculeDAO.getVehiculeLuxe();
            populateTable(listVehiculeLuxe);
            console.setText("Affichage des véhicules de la catégorie économique !");
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Affichage des vehicule en cours de location
    // appel de la methode dans VehiculeDAO pour recuperer les resultats et les afficher dans la tableView
    @FXML
    private void getVehiculeEnLocation(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Vehicule> listVehiculeEnLocation = VehiculeDAO.getVehiculeEnLocation();
            populateTable(listVehiculeEnLocation);
            console.setText("Affichage des véhicules en location !");
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }
    // affichage des resultats dans la table view
    private void populateTable(ObservableList<Vehicule> listVehicule){
        tableVehicule.setItems(listVehicule);

    }


    /**
     * Initialize.
     */
    public void initialize() {
        cbBoite.getItems().add("MANUELLE");
        cbBoite.getItems().add("AUTOMATIQUE");
        cbCarburant.getItems().add("GAZOLE");
        cbCarburant.getItems().add("ESSENCE");
        cbCarburant.getItems().add("SP95");
        cbCarburant.getItems().add("GPL");
        cbCarburant.getItems().add("ETHANOL");
        cbCarburant.getItems().add("ELECTRIQUE");
        cbCategorie.getItems().add("CONFORT");
        cbCategorie.getItems().add("LUXE");
        cbCategorie.getItems().add("ECONOMIQUE");
        cbReservoire.getItems().add("3/4");
        cbReservoire.getItems().add("1/2");
        cbReservoire.getItems().add("1/4");
        cbReservoire.getItems().add("VIDE");
        cbEtat.getItems().add("NEUF");
        cbEtat.getItems().add("BON_ETAT");
        cbEtat.getItems().add("USEE");
        colMatricule.setCellValueFactory(cellData -> cellData.getValue().matriculeProperty());
        colMarque.setCellValueFactory(cellData -> cellData.getValue().marqueProperty());
        colModele.setCellValueFactory(cellData -> cellData.getValue().modeleProperty());
        colKilometrage.setCellValueFactory(cellData -> cellData.getValue().kilometrageProperty());
        colBoite.setCellValueFactory(cellData -> cellData.getValue().boiteProperty());
        colClimatisation.setCellValueFactory(cellData -> cellData.getValue().climatisationProperty());
        colReservoire.setCellValueFactory(cellData -> cellData.getValue().reservoireProperty());
        colEtat.setCellValueFactory(cellData -> cellData.getValue().etatProperty());
        colCategorie.setCellValueFactory(cellData -> cellData.getValue().categorieProperty());
        colCarburant.setCellValueFactory(cellData -> cellData.getValue().carburantProperty());
        colTarifJour.setCellValueFactory(cellData -> cellData.getValue().tarifJournalierProperty().asObject());
        colCaution.setCellValueFactory(cellData -> cellData.getValue().cautionProperty().asObject());
        ObservableList<Vehicule> listVehicule = null;
        try {
            listVehicule = VehiculeDAO.getAllVehicule();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        populateTable(listVehicule);
    }
}
