package model;

import db.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Facture dao.
 */
public class FactureDAO {

    /**
     * Gets duree location.
     *
     * @param idFacture the id facture
     * @return the duree location
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Facture> getDureeLocation(int idFacture) throws ClassNotFoundException, SQLException{
        String sql = "SELECT DUREE_LOC FROM FACTURE WHERE ID_FACTURE = '"+idFacture+"' ";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Facture> dureeLocation = getDureeObject(rsSet);
            return dureeLocation;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Facture table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets duree object.
     *
     * @param rsSet the rs set
     * @return the duree object
     * @throws SQLException the sql exception
     */
    public static ObservableList<Facture> getDureeObject(ResultSet rsSet)throws SQLException{
        ObservableList<Facture> factures = FXCollections.observableArrayList();
        while (rsSet.next()){
            Facture facture = new Facture();
            facture.setDuree(rsSet.getInt("DUREE_LOC"));
            factures.add(facture);
        }
        return factures;
    }

    /**
     * Gets tarif j location.
     *
     * @param matricule the matricule
     * @return the tarif j location
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Facture> getTarifJLocation(String matricule) throws ClassNotFoundException, SQLException{
        String sql = "SELECT TARIF_JOUR FROM VEHICULE WHERE MATRICULE = '"+matricule+"' ";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Facture> tarifJLocation = getTarifJObject(rsSet);
            return tarifJLocation;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Facture table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets tarif j object.
     *
     * @param rsSet the rs set
     * @return the tarif j object
     * @throws SQLException the sql exception
     */
    public static ObservableList<Facture> getTarifJObject(ResultSet rsSet)throws SQLException{
        ObservableList<Facture> factures = FXCollections.observableArrayList();
        while (rsSet.next()){
            Facture facture = new Facture();
            facture.setTarifJ(rsSet.getInt("TARIF_JOUR"));
            factures.add(facture);
        }
        return factures;
    }

    /**
     * Gets etat vehicule.
     *
     * @param matricule the matricule
     * @return the etat vehicule
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Facture> getEtatVehicule(String matricule) throws ClassNotFoundException, SQLException{
        String sql = "SELECT ETAT FROM VEHICULE WHERE MATRICULE = '"+matricule+"' ";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Facture> etatLocation = getEtatObject(rsSet);
            return etatLocation;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Facture table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets etat object.
     *
     * @param rsSet the rs set
     * @return the etat object
     * @throws SQLException the sql exception
     */
    public static ObservableList<Facture> getEtatObject(ResultSet rsSet)throws SQLException{
        ObservableList<Facture> factures = FXCollections.observableArrayList();
        while (rsSet.next()){
            Facture facture = new Facture();
            facture.setEtat(rsSet.getString("ETAT"));
            factures.add(facture);
        }
        return factures;
    }


    /**
     * Gets reservoir vehicule.
     *
     * @param matricule the matricule
     * @return the reservoir vehicule
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Facture> getReservoirVehicule(String matricule) throws ClassNotFoundException, SQLException{
        String sql = "SELECT RESERVOIRE FROM VEHICULE WHERE MATRICULE = '"+matricule+"' ";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Facture> reservoireLocation = getReservoireObject(rsSet);
            return reservoireLocation;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Facture table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets reservoire object.
     *
     * @param rsSet the rs set
     * @return the reservoire object
     * @throws SQLException the sql exception
     */
    public static ObservableList<Facture> getReservoireObject(ResultSet rsSet)throws SQLException{
        ObservableList<Facture> factures = FXCollections.observableArrayList();
        while (rsSet.next()){
            Facture facture = new Facture();
            facture.setEtat(rsSet.getString("RESERVOIRE"));
            factures.add(facture);
        }
        return factures;
    }


}
