/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

public interface UserDAO {
    
    public abstract void addUser(String name, String username, String password, String email);
    
    public abstract ArrayList<Integer> userExists(String user);
    
    public abstract boolean credentialExists(String user);
    
    public abstract boolean credentialsExists(String username, String password);
    
}
