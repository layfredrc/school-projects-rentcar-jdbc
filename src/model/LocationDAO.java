package model;

import db.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Location dao.
 */
public class LocationDAO {
    /**
     * Gets all location.
     *
     * @return the all location
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static ObservableList<Location> getAllLocation() throws  ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM LOCATION";
        try{
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Location> listLocation = getLocationObjects(rsSet);
            return listLocation;
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Location table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Insert location.
     *
     * @param matricule the matricule
     * @param idClient  the id client
     * @param dateDebut the date debut
     * @param dateFin   the date fin
     * @param idFacture the id facture
     * @param nbJour    the nb jour
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void insertLocation(String matricule, int idClient,String dateDebut,String dateFin, int idFacture,int nbJour) throws  ClassNotFoundException, SQLException {
        String sql = "INSERT INTO FACTURE VALUES('"+idFacture+"', '"+nbJour+"');";
        String sql2 = "INSERT INTO LOCATION VALUES('"+matricule+"','"+dateDebut+"','"+dateFin+"','"+idClient+"','"+idFacture+"');";
        try{
            DBUtil.dbExecuteQuery(sql);
            DBUtil.dbExecuteQuery(sql2);
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Location table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Update location.
     *
     * @param matricule the matricule
     * @param idClient  the id client
     * @param dateDebut the date debut
     * @param dateFin   the date fin
     * @param idFacture the id facture
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void updateLocation(String matricule, int idClient,String dateDebut,String dateFin, int idFacture) throws  ClassNotFoundException, SQLException {
        String sql = "UPDATE LOCATION SET DATE_DEBUT = '"+dateDebut+"', DATE_FIN = '"+dateFin+"' WHERE MATRICULE = '"+matricule+"' AND ID_CLIENT = '"+idClient+"' AND ID_FACTURE = '"+idFacture+"'";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Location table");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Delete location.
     *
     * @param matricule the matricule
     * @param idClient  the id client
     * @param idFacture the id facture
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
    public static void deleteLocation(String matricule, int idClient, int idFacture) throws  ClassNotFoundException, SQLException {
        String sql = "DELETE FROM LOCATION WHERE MATRICULE = '"+matricule+"'AND ID_CLIENT = '"+idClient+"'AND ID_FACTURE = '"+idFacture+"'";
        try{
            DBUtil.dbExecuteQuery(sql);
        }catch(SQLException e){
            System.out.println("Error occured while fetching the Location table");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Location> getLocationObjects(ResultSet rsSet) throws SQLException {

        ObservableList<Location> listLocation = FXCollections.observableArrayList();
        while(rsSet.next()){
            Location location = new Location();
            location.setMatricule(rsSet.getString("MATRICULE"));
            location.setIdClient(rsSet.getInt("ID_CLIENT"));
            location.setDateDebut(rsSet.getString("DATE_DEBUT"));
            location.setDateFin(rsSet.getString("DATE_FIN"));
            location.setIdFacture(rsSet.getInt("ID_FACTURE"));
            listLocation.add(location);
        }

        return listLocation;
    }






}
