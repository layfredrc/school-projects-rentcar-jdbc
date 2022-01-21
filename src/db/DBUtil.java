package db;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

/**
 * The type Db util.
 */
public class DBUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;
    private static String connStr = "jdbc:mysql://localhost/rentcar";

    /**
     * Db connect.
     * Connexion à la base de donnée sous mysql workbench
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
    public static void dbConnect() throws SQLException, ClassNotFoundException{
        try{
            Class.forName(JDBC_DRIVER);
        }catch (ClassNotFoundException e){
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
            throw e;
        }

        System.out.println("JDBC Driver registered");
        try {
            connection = DriverManager.getConnection(connStr,"root","test");
        }catch (SQLException e){
            System.out.println("Connection Failed Check output console");
            throw e;
        }
    }

    /**
     * Db disconnect.
     *
     * @throws SQLException the sql exception
     */
    public static void dbDisconnect() throws SQLException{
        try {
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * Db execute query.
     *
     * @param sqlStmt the sql stmt
     * @throws SQLException           the sql exception
     * @throws ClassNotFoundException the class not found exception
     */
// pour les requetes qui vont nserer / supprimer / update la db
    public static void dbExecuteQuery(String sqlStmt) throws SQLException,ClassNotFoundException{
        Statement stmt = null;
        try{
            dbConnect();

            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        }catch (SQLException e){
            System.out.println("Problem occured at dbExecuteQuery operation" + e);
            throw e;
        }
        finally {
            if(stmt!=null){
                stmt.close();

            }
            dbDisconnect();
        }

    }

    /**
     * Db execute result set.
     *
     * @param sqlQuery the sql query
     * @return the result set
     * @throws ClassNotFoundException the class not found exception
     * @throws SQLException           the sql exception
     */
// recuperer les donnees de la db
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException{
        Statement stmt = null;
        ResultSet res = null;
        CachedRowSetImpl crs = null;
        try{
            dbConnect();
            stmt = connection.createStatement();
            res = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(res);
        }catch (SQLException e){
            System.out.println("Error occured in dbExecute operation" + e);
            throw e;
        }
        finally {
            if(res != null){
                res.close();
            }
            if(stmt != null){
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }
}
