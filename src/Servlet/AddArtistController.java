package Servlet;

import Entity.ArtistEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import java.io.IOException;

/**
 * Created by Moudi on 5/9/2017.
 */
@WebServlet(name = "AddArtistController")
public class AddArtistController extends HttpServlet {
    @PersistenceContext
    private EntityManager em;
    @Resource
    private UserTransaction userTransaction;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello");
        String artistName = request.getParameter("artistName");
        Query ex = em.createQuery("SELECT a FROM ArtistEntity a WHERE a.name=:name").setParameter("name",artistName);
        try{
            ArtistEntity u = (ArtistEntity) ex.getSingleResult();
            ObjectMapper objectMapper = new ObjectMapper();
            String reply = objectMapper.writeValueAsString("Invalid");
            response.getWriter().write(reply);
        }catch (Exception e){

            try {
                userTransaction.begin();
                ArtistEntity artistEntity = new ArtistEntity();
                artistEntity.setName(artistName);
                em.persist(artistEntity);
                userTransaction.commit();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            String reply = objectMapper.writeValueAsString("Valid");
            response.getWriter().write(reply);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
