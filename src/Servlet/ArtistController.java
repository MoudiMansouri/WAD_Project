package Servlet;


import Entity.ArtistEntity;
import Entity.SongsEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Moudi on 4/9/2017.
 */

@WebServlet(name = "ArtistController")
public class ArtistController extends HttpServlet {
    @PersistenceContext
    private EntityManager em;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        request.getSession().setAttribute("num",new Integer(0));
        String s = request.getParameter("artist");
        System.out.println(s);
        Query artist = em.createQuery("SELECT artist FROM ArtistEntity artist WHERE artist.name=:name").setParameter("name",s);
        ArtistEntity artistEntity = (ArtistEntity) artist.getSingleResult();
        Query songs = em.createQuery("SELECT s FROM SongsEntity s JOIN s.artistByArtist a WHERE a.name=:name").setParameter("name",s);
        List<SongsEntity> songList= songs.getResultList();
        request.getSession().setAttribute("songs", songList);
        request.getSession().setAttribute("score",0);
        request.getSession().setAttribute("artist", artistEntity);
        requestDispatcher.forward(request,response);
    }
}
