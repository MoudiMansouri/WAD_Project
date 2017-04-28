package Database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Moudi on 4/9/2017.
 */
public class ConnectionController {

    public static Connection getConnection() throws ClassNotFoundException, NamingException {
        Class.forName("com.mysql.jdbc.Driver");
        Context context = new InitialContext();
        javax.sql.DataSource ds = (javax.sql.DataSource) context.lookup("java:/WADproject");
        String url = "jdbc:mysql://localhost:3306/wad_project";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "root", "moudiadmin");
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
