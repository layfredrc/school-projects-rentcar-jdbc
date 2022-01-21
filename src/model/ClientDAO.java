package model;

import com.sun.javafx.collections.ObservableListWrapper;
import db.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Client dao.
 */
public class ClientDAO {
    /**
     * Insert client.
     *
     * @param clientId   the client id
     * @param nom        the nom
     * @param prenom     the prenom
     * @param email      the email
     * @param numTel     the num tel
     * @param rue        the rue
     * @param ville      the ville
     * @param codePostal the code postal
     * @param nbLocation the nb location
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void insertClient(int clientId,String nom, String prenom, String email,String numTel,String rue,String ville, int codePostal,int nbLocation) throws SQLException,ClassNotFoundException{
        String sql = "INSERT INTO CLIENT VALUES('"+clientId+"','"+nom+"', '"+prenom+"','"+email+"','"+numTel+"','"+rue+"','"+ville+"','"+codePostal+"','"+nbLocation+"')";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while inserting data" + e);
            e.printStackTrace();
            throw  e;
        }
    }

    /**
     * Update client.
     *
     * @param clientId   the client id
     * @param nom        the nom
     * @param prenom     the prenom
     * @param email      the email
     * @param numTel     the num tel
     * @param rue        the rue
     * @param ville      the ville
     * @param codePostal the code postal
     * @param nbLocation the nb location
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void updateClient(int clientId, String nom, String prenom, String email,String numTel,String rue,String ville, int codePostal, int nbLocation) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE CLIENT SET NOM = '"+nom+"', PRENOM = '"+prenom+"', EMAIL = '"+email+"', NUM_TEL = '"+numTel+"'," +
                "RUE = '"+rue+"', VILLE = '"+ville+"', CODE_POSTAL = '"+codePostal+"', NB_LOC = '"+nbLocation+"' WHERE ID_CLIENT = '"+clientId+"'";
        try {
           DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occur while updating data " + e);
            throw e;
        }

    }

    /**
     * Delete client by id.
     *
     * @param id the id
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void  deleteClientById(int id) throws ClassNotFoundException,SQLException {
        String sql = "DELETE FROM CLIENT WHERE ID_CLIENT = '"+id+"'";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occured while deleting the client" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets all clients.
     *
     * @return the all clients
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getAllClients() throws  ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM CLIENT";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClient = getClientsObjects(rsSet);
            return listClient;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets client aa z.
     *
     * @return the client aa z
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getClientAaZ() throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM CLIENT ORDER BY NOM";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClientAaZ = getClientsObjects(rsSet);
            return listClientAaZ;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets client by nom.
     *
     * @param nom the nom
     * @return the client by nom
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getClientByNom(String nom) throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM CLIENT WHERE NOM = '"+nom+"'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClientByNom = getClientsObjects(rsSet);
            return  listClientByNom;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw  e;
        }
    }

    /**
     * Gets client jamais loue.
     *
     * @return the client jamais loue
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getClientJamaisLoue() throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM CLIENT WHERE NB_LOC = 0";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClientJamaisLoue = getClientsObjects(rsSet);
            return  listClientJamaisLoue;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw  e;
        }
    }

    /**
     * Gets client location en cours.
     *
     * @return the client location en cours
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getClientLocationEnCours() throws ClassNotFoundException,SQLException{
        String sql = "SELECT * from CLIENT C, location loc WHERE C.ID_CLIENT = loc.ID_CLIENT AND loc.DATE_FIN > current_date() AND loc.DATE_DEBUT <= current_date();";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClientJamaisLoue = getClientsObjects(rsSet);
            return  listClientJamaisLoue;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw  e;
        }
    }

    /**
     * Gets client ayant loue un vehicule donne.
     *
     * @param matricule the matricule
     * @return the client ayant loue un vehicule donne
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Client> getClientAyantLoueUnVehiculeDonne(String matricule) throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM CLIENT C, VEHICULE V, LOCATION LOC WHERE V.MATRICULE = LOC.MATRICULE AND C.ID_CLIENT = LOC.ID_CLIENT AND LOC.MATRICULE = '"+matricule+"'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Client> listClientAyantLoueUnVehiculeDonne = getClientsObjects(rsSet);
            return  listClientAyantLoueUnVehiculeDonne;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the client table");
            e.printStackTrace();
            throw  e;
        }
    }
    // Recupere les resultats de la requetes pour les instancier sur un objet Client et pour les afficher dans la tableView
    private static ObservableList<Client> getClientsObjects(ResultSet rsSet) throws SQLException {

        ObservableList<Client> listClient = FXCollections.observableArrayList();
        while(rsSet.next()){
            Client client = new Client();
            client.setIdClient(rsSet.getInt("ID_CLIENT"));
            client.setNomClient(rsSet.getString("NOM"));
            client.setPrenomClient(rsSet.getString("PRENOM"));
            client.setEmailClient(rsSet.getString("EMAIL"));
            client.setTelClient(rsSet.getString("NUM_TEL"));
            client.setRueClient(rsSet.getString("RUE"));
            client.setVilleClient(rsSet.getString("VILLE"));
            client.setCodePostalClient(rsSet.getInt("CODE_POSTAL"));
            client.setNbLocation(rsSet.getInt("NB_LOC"));
            listClient.add(client);

        }

        return listClient;
    }

}
