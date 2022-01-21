package app;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Client;
import model.ClientDAO;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The type Client controller.
 */
public class ClientController {
    @FXML
    private Button vehiculeBtn;
    @FXML
    private Button locationBtn;
    @FXML
    private Button factureBtn;
    @FXML
    private TextField inputClientID;
    @FXML
    private TextField inputEmailClient;
    @FXML
    private TextField inputNomClient;
    @FXML
    private TextField inputPrenomClient;
    @FXML
    private TextField inputRueClient;
    @FXML
    private TextField inputVilleClient;
    @FXML
    private TextField inputTelClient;
    @FXML
    private TextField inputCodePostalClient;
    @FXML
    private TextField inputVehiculeClient;
    @FXML
    private Button addClientBtn;
    @FXML
    private Button deleteClientBtn;
    @FXML
    private Button updateClientBtn;
    @FXML
    private TextArea console;
    @FXML
    private TextField inputNbLocation;
    @FXML
    private TableColumn<Client,Integer> colClientID;
    @FXML
    private TableColumn<Client,String> colClientNom;
    @FXML
    private TableColumn<Client,String> colClientPrenom;
    @FXML
    private TableColumn<Client,String> colClientEmail;
    @FXML
    private TableColumn<Client,String> colClientTelephone;
    @FXML
    private TableColumn<Client,String> colClientRue;
    @FXML
    private TableColumn<Client,String> colClientVille;
    @FXML
    private TableColumn<Client,Integer> colClientCodePostal;
    @FXML
    private TableColumn<Client,Integer> colNbLocation;
    @FXML
    private TableView<Client> tableClient;

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
    // Permet d'insérer un nouveau client dans la table Client de la BDD rentcar
    // Utilisation de la methode de ClientDAO : nous recuperons les champs rempli par l'utilisateur pour
    // les insérer dans la requete de ClientDAO
    @FXML
    private void insertClient(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            ClientDAO.insertClient(Integer.parseInt(inputClientID.getText()), inputNomClient.getText(), inputPrenomClient.getText(),
                    inputEmailClient.getText(), inputTelClient.getText(), inputRueClient.getText(),
                    inputVilleClient.getText(), Integer.parseInt(inputCodePostalClient.getText()), Integer.parseInt(inputNbLocation.getText()));
            initialize();
            console.setText("Ajout réussi !\nles valeurs ont été insérés dans\n la  table CLIENT");
        } catch (SQLException e) {
            console.setText(String.valueOf(e));
            System.out.println("Exception occur in Insertion" + e);
            e.printStackTrace();
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Permet de modifier un client dans la table Client de la BDD rentcar
    // Utilisation de la methode de ClientDAO : nous recuperons les champs rempli par l'utilisateur pour
    // les insérer dans la requete de ClientDAO
    @FXML
    private void updateClient(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
            ClientDAO.updateClient(Integer.parseInt(inputClientID.getText()), inputNomClient.getText(),inputPrenomClient.getText(),
                inputEmailClient.getText(),inputTelClient.getText(),inputRueClient.getText(),inputVilleClient.getText(),
                Integer.parseInt(inputCodePostalClient.getText()),Integer.parseInt(inputNbLocation.getText()));
            initialize();
                console.setText("Modification réussie pour le client " + inputClientID.getText());
            }catch (SQLException e){
                System.out.println("Exception occur in update " + e);
                e.printStackTrace();
                throw e;
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Permet de supprimer un client dans la table Client de la BDD rentcar
    // Utilisation de la methode de ClientDAO : nous recuperons les champs rempli par l'utilisateur pour
    // les insérer dans la requete de ClientDAO
    @FXML
    private void deleteClient(ActionEvent event) throws ClassNotFoundException, SQLException{
        try{
            ClientDAO.deleteClientById(Integer.parseInt(inputClientID.getText()));
            initialize();
            console.setText("Client " + inputClientID.getText() + " supprimé avec succès ! ");
        }catch (SQLException e){
            System.out.println("Exception occured in delete" + e);
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Afficher les clients par ordre alphabetiques
    @FXML
    private void getClientAaZ(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Client> listClientAaZ = ClientDAO.getClientAaZ();
            populateTable(listClientAaZ);
            console.setText("Affichage des clients par ordre alphabétique !");
        }catch (SQLException e){
            System.out.println("Exception occured in SELECT " + e );
            e.printStackTrace();
            throw e;
        }
    }
    // Afficher les clients par nom
    @FXML
    private void getClientByNom(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Client> listClientByNom = ClientDAO.getClientByNom(inputNomClient.getText());
            populateTable(listClientByNom);
            console.setText("Recherche du client par nom !");
        }catch (SQLException e){
            System.out.println("Exception occured in SELECT " + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Afficher les clients n'ayant jamais utiliser le service
    @FXML
    private void getClientJamaisLoue(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Client> listClientJamaisLoue = ClientDAO.getClientJamaisLoue();
            populateTable(listClientJamaisLoue);
            console.setText("Affichage des clients qui n'ont jamais loué !");
        }catch (SQLException e){
            System.out.println("Exception occured in SELECT " + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Afficher les clients ayant une location en cours
    @FXML
    private void getClientLocationEnCours(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Client> listClientLocationEnCours = ClientDAO.getClientLocationEnCours();
            populateTable(listClientLocationEnCours);
            console.setText("Affichage des clients qui ont une location en cours !");
        }catch (SQLException e){
            System.out.println("Exception occured in SELECT " + e);
            e.printStackTrace();
            throw e;
        }
    }
    // Afficher les clients ayant loué le vehicule donné
    @FXML
    private void getClientAyantLouerUnVehiculeDonne(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            ObservableList<Client> listClientAyantLouerUnVehiculeDonne = ClientDAO.getClientAyantLoueUnVehiculeDonne(inputVehiculeClient.getText());
            populateTable(listClientAyantLouerUnVehiculeDonne);
            console.setText("Affichage des clients qui ont \nloué le véhicule " + inputVehiculeClient.getText()+" !");
        }catch (SQLException e){
            System.out.println("Exception occured in SELECT " + e);
            e.printStackTrace();
            throw e;
        }
    }
    // se lance lors du chargement de la page et permet de remplir la TABLE VIEW avec les données de la requete
    // getAllClients, ce qui affiche toute la table Client.
    @FXML
    private void initialize() throws Exception{
        colClientID.setCellValueFactory(cellData -> cellData.getValue().idClientProperty().asObject());
        colClientNom.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        colClientPrenom.setCellValueFactory(cellData -> cellData.getValue().prenomClientProperty());
        colClientEmail.setCellValueFactory(cellData -> cellData.getValue().emailClientProperty());
        colClientTelephone.setCellValueFactory(cellData -> cellData.getValue().telClientProperty());
        colClientRue.setCellValueFactory(cellData -> cellData.getValue().rueClientProperty());
        colClientVille.setCellValueFactory(cellData -> cellData.getValue().villeClientProperty());
        colClientCodePostal.setCellValueFactory(cellData -> cellData.getValue().codePostalClientProperty().asObject());
        colNbLocation.setCellValueFactory(cellData -> cellData.getValue().nbLocationProperty().asObject());
        ObservableList<Client> listClient = ClientDAO.getAllClients();
        populateTable(listClient);
    }


    // Afficher les résultats dans la tableView
    private void populateTable(ObservableList<Client> listClient){
        tableClient.setItems(listClient);

    }
}

