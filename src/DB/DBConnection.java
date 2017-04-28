package DB;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author E-M
 */
public class DBConnection {

    static DBConnection  instance;
    java.sql.Connection con = null;


    public DBConnection() {
//
//        try {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String url = "jdbc:derby://localhost:1527/wad_project";

        System.out.println("ENTERED CLASS ===========");
//
        try {
            Class.forName("com.mysql.jdbc.Driver"); //forces the driver to register itself

//====================== data source ===================
//            Context ctx = new InitialContext();
//            DataSource ds
//                    = (DataSource) ctx.lookup("jdbc/myDatasource");
//            con = ds.getConnection();
// ==========================================================
            con = DriverManager.getConnection(url, "root", "moudiadmin");
        } catch (SQLException | ClassNotFoundException ex) {
            
        }

//        } catch (NamingException | SQLException ex) {
//            Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public static DBConnection getInstance() {

        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    

}
