/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import DB.DBConnection;
import java.util.ArrayList;


public class UserDAOImpl implements UserDAO {

    DBConnection dbc = DBConnection.getInstance();

    @Override
    public void addUser(String name, String username, String password, String email) {
        boolean resp = false;

        try {
            Statement instr = null;
            try {
                instr = dbc.getCon().createStatement();
            } catch (SQLException ex) {
                
            }

            String sql = "INSERT INTO USERS (name, username, password, email) VALUES ('"+name+"', '"+username+"', '"+password+"', '"+email+"')";
            System.out.println(sql);
            instr.executeUpdate(sql);
            instr.close();
        } catch (SQLException ex) {
            
        }

    }

    @Override
    public ArrayList<Integer> userExists(String user) {
        int id = 0;
        int admin = 0;

        ArrayList<Integer> userInfo = new ArrayList<>();
        
        try {
            Statement instr = null;

            try {
                instr = dbc.getCon().createStatement();
            } catch (SQLException ex) {
               
            }

            String sql = "SELECT * FROM users WHERE username= '" + user + "'";

            ResultSet rs = instr.executeQuery(sql);

            if (rs.next()) {
                id = Integer.parseInt(rs.getString(1));
                admin = Integer.parseInt(rs.getString(10));
                rs.close();
                instr.close();
                userInfo.add(id);
                userInfo.add(admin);

                return userInfo;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return userInfo;
    }
    
    @Override
    public boolean credentialExists(String user){
        try {
            Statement instr = null;

            try {
                instr = dbc.getCon().createStatement();
            } catch (SQLException ex) {
                
            }
            String sql = "SELECT * FROM users WHERE username= '" + user.toLowerCase() + "'";

            ResultSet rs = instr.executeQuery(sql);

            if (rs.next()) {
                rs.close();
                instr.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public boolean credentialsExists(String username, String password){
        try {
            Statement instr = null;

            try {
                instr = dbc.getCon().createStatement();
            } catch (SQLException ex) {
                
            }
        String sql = "SELECT * FROM users WHERE username= '" + username.toLowerCase() + "' AND password= '"+ password + "'";

            ResultSet rs = instr.executeQuery(sql);

            if (rs.next()) {
                rs.close();
                instr.close();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    

}
