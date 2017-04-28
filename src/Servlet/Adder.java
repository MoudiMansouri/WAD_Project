//package Servlet;
//
//import Entity.Artist;
//
//import javax.annotation.Resource;
//import javax.persistence.Entity;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.transaction.*;
//import java.io.IOException;
//
///**
// * Created by Moudi on 4/11/2017.
// */
//@WebServlet(name = "Adder")
//public class Adder extends HttpServlet {
//
//    @PersistenceContext(unitName = "NewPersistenceUnit")
//    private EntityManager em;
//    @Resource
//    private javax.transaction.UserTransaction utx;
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            Artist a = new Artist();
//            a.setName("Someone");
//        try {
//            utx.begin();
//            em.persist(a);
//            utx.commit();
//            System.out.println("ADDED");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Artist a2 = em.find(Artist.class,1);
//        System.out.println(a2.getName());
//
//
//
//    }
//
//
//
//
//}
