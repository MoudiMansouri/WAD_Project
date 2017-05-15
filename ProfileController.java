/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eduok Etinyene
 */
@WebServlet(urlPatterns = {"/ProfileController"})
public class ProfileController extends HttpServlet {
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome to your Profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text");
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/wad_project";
        String dbName = "";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        Statement st = null;
        
            try {
                conn = DriverManager.getConnection(url + dbName, userName, password);
                System.out.println("connected");
                String uid = (String) request.getSession().getAttribute("ID");
                ArrayList al = null;
                ArrayList pid_list = new ArrayList();
                String query = "select* from emp";
                if(uid!=null && !uid.equals("")){
                   query = "select*from emp where ID = " + uid + ""; 
                
            }
                System.out.println("query" + query);
                st = (Statement) conn.createStatement();
                ResultSet rs = executeQuery(query);
                
                while (rs.next()){
                    al = new ArrayList();
                    al.add(rs.getString(1));
                    al.add(rs.getString(2));
                    al.add(rs.getString(3));
                    al.add(rs.getString(4));
                    System.out.println("al::" + al);
                    pid_list.add(al);
                    
                }
                
                request.setAttribute("piList", pid_list);
                RequestDispatcher view = request.getRequestDispatcher("view.jsp");
                view.forward(request, response);
                conn.close();
                System.out.println("Disconnected");
            } catch (SQLException ex) {
            }
        
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Loading Profile";
    }// </editor-fold>

    private ResultSet executeQuery(String query) {
        return null;
        
    }

}
