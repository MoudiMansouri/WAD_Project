/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.UserDAO;
import DAO.UserDAOImpl;
import java.util.ArrayList;

/**
 *
 * @author E-M
 */
public class LoginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    DBController dbCtrl = new DBController();
    UserDAO userDAO = new UserDAOImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Map<String, String[]> params = request.getParameterMap();

            String username = params.get("uname")[0];
//            String password = params.get("password")[0];
            ArrayList<Integer> userInfo = userDAO.userExists(username);
            System.out.println("size " + userInfo.size());
            int id = userInfo.get(0);
//            int admin = userInfo.get(1);

            if (id > 0) {
                System.out.println("id " + id);
                request.getSession().setAttribute("user", id);
                System.out.println("id --- " + id);
//                if(admin > 0){
//                    request.getSession().setAttribute("admin", admin);
//                }
                RequestDispatcher rd = request.getRequestDispatcher("/menu.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("error", "Username and password not correct!");
                RequestDispatcher rd = request.getRequestDispatcher("/LoginViewjsp.jsp");
                rd.forward(request, response);
            }

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
        processRequest(request, response);
//        String username = request.getParameter("uname");
//        String password = request.getParameter("password");
//        Boolean credentialsExist;
//        try (PrintWriter out = response.getWriter()) {
//            credentialsExist = userDAO.credentialExists(username, password);
//            out.println(credentialsExist);
//        }
//
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
