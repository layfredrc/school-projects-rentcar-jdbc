package model;

import db.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Vehicule dao.
 */
public class VehiculeDAO {
    /**
     * Insert vehicule.
     *
     * @param matricule       the matricule
     * @param marque          the marque
     * @param modele          the modele
     * @param kilometrage     the kilometrage
     * @param boite           the boite
     * @param climatisation   the climatisation
     * @param reservoire      the reservoire
     * @param etat            the etat
     * @param categorie       the categorie
     * @param carburant       the carburant
     * @param tarifJournalier the tarif journalier
     * @param caution         the caution
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void insertVehicule(String matricule, String marque, String modele,String kilometrage,
                                      String boite,int climatisation, String reservoire, String etat, String categorie,
                                      String carburant, int tarifJournalier, int caution)
            throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO VEHICULE VALUES('"+matricule+"','"+marque+"','"+modele+"','"+kilometrage+"','"+boite+"','"+climatisation+"'," +
                "'"+reservoire+"','"+etat+"','"+categorie+"','"+carburant+"','"+tarifJournalier+"','"+caution+"')";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error when inserting to vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Update vehicule.
     *
     * @param matricule       the matricule
     * @param marque          the marque
     * @param modele          the modele
     * @param kilometrage     the kilometrage
     * @param boite           the boite
     * @param climatisation   the climatisation
     * @param reservoire      the reservoire
     * @param etat            the etat
     * @param categorie       the categorie
     * @param carburant       the carburant
     * @param tarifJournalier the tarif journalier
     * @param caution         the caution
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void updateVehicule(String matricule, String marque, String modele,String kilometrage,
                                       String boite,int climatisation, String reservoire, String etat, String categorie,
                                       String carburant, int tarifJournalier, int caution)
            throws ClassNotFoundException,SQLException{
        String sql = "UPDATE VEHICULE SET MARQUE = '"+marque+"', MODELE = '"+modele+"', KILOMETRAGE = '"+kilometrage+"'" +
                ", BOITE = '"+boite+"', CLIMATISATION = '"+climatisation+"', RESERVOIRE = '"+reservoire+"', ETAT = '"+etat+"'" +
                ", CATEGORIE = '"+categorie+"', CARBURANT = '"+carburant+"', TARIF_JOUR = '"+tarifJournalier+"', CAUTION = '"+caution+"'" +
                "WHERE MATRICULE = '"+matricule+"'";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error while updating data in Vehicule" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete vehicule.
     *
     * @param matricule the matricule
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void deleteVehicule(String matricule) throws ClassNotFoundException,SQLException{
        String sql = "DELETE FROM VEHICULE WHERE MATRICULE = '"+matricule+"'";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e ){
            System.out.println("Error while deleting in the vehicule table" + e);
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets vehicule by marque.
     *
     * @param marque the marque
     * @return the vehicule by marque
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getVehiculeByMarque(String marque) throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM VEHICULE WHERE MARQUE = '"+marque+"'";
        try {
           ResultSet rsSet = DBUtil.dbExecute(sql);
           ObservableList<Vehicule> listeVehiculeByMarque = getVehiculeObjects(rsSet);
           return  listeVehiculeByMarque;
        }catch (SQLException e){
           System.out.println("Error occured while Select in Vehicule Table");
           e.printStackTrace();
           throw e;
        }

    }

    /**
     * Gets vehicule economique.
     *
     * @return the vehicule economique
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getVehiculeEconomique()throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM VEHICULE WHERE CATEGORIE = 'ECONOMIQUE'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listeVehiculeEconomique = getVehiculeObjects(rsSet);
            return  listeVehiculeEconomique;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule Table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets vehicule confort.
     *
     * @return the vehicule confort
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getVehiculeConfort()throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM VEHICULE WHERE CATEGORIE = 'CONFORT'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listeVehiculeEconomique = getVehiculeObjects(rsSet);
            return  listeVehiculeEconomique;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule Table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets vehicule luxe.
     *
     * @return the vehicule luxe
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getVehiculeLuxe()throws ClassNotFoundException,SQLException{
        String sql = "SELECT * FROM VEHICULE WHERE CATEGORIE = 'LUXE'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listeVehiculeEconomique = getVehiculeObjects(rsSet);
            return  listeVehiculeEconomique;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule Table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets vehicule en location.
     *
     * @return the vehicule en location
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getVehiculeEnLocation() throws ClassNotFoundException,SQLException{
        String sql = "SELECT * from vehicule V, location loc WHERE V.MATRICULE = loc.MATRICULE AND loc.DATE_FIN > current_date() AND loc.DATE_DEBUT <= current_date()";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listeVehiculeEnLocation = getVehiculeObjects(rsSet);
            return  listeVehiculeEnLocation;
        }catch (SQLException e){
            System.out.println("Error occured while Select in Vehicule Table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Gets all vehicule.
     *
     * @return the all vehicule
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Vehicule> getAllVehicule() throws  ClassNotFoundException, SQLException{
        String sql = "SELECT * FROM VEHICULE";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Vehicule> listVehicule = getVehiculeObjects(rsSet);
            return listVehicule;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Vehicule table");
            e.printStackTrace();
            throw e;
        }
    }






    private static ObservableList<Vehicule> getVehiculeObjects(ResultSet rsSet) throws SQLException {

        ObservableList<Vehicule> listVehicule = FXCollections.observableArrayList();
        while(rsSet.next()){
            Vehicule vehicule = new Vehicule();
            vehicule.setMatricule(rsSet.getString("MATRICULE"));
            vehicule.setMarque(rsSet.getString("MARQUE"));
            vehicule.setModele(rsSet.getString("MODELE"));
            vehicule.setKilometrage(rsSet.getString("KILOMETRAGE"));
            vehicule.setBoite(rsSet.getString("BOITE"));
            vehicule.setClimatisation(rsSet.getBoolean("CLIMATISATION"));
            vehicule.setReservoire(rsSet.getString("RESERVOIRE"));
            vehicule.setEtat(rsSet.getString("ETAT"));
            vehicule.setCategorie(rsSet.getString("CATEGORIE"));
            vehicule.setCarburant(rsSet.getString("CARBURANT"));
            vehicule.setTarifJournalier(rsSet.getInt("TARIF_JOUR"));
            vehicule.setCaution(rsSet.getInt("CAUTION"));
            listVehicule.add(vehicule);
        }

        return listVehicule;
    }
}
