package Servlet;

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
import java.util.List;

import Entity.ArtistEntity;
import Entity.ScoresEntity;
import Entity.SongsEntity;
import Entity.UsersEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Moudi on 3/29/2017.
 */
@WebServlet(name = "AnswerController")
public class AnswerController extends HttpServlet {
    @PersistenceContext
    private EntityManager em;
    @Resource
    UserTransaction userTransaction;
    @Resource
    private javax.transaction.UserTransaction utx;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Integer num = Integer.parseInt(request.getParameter("num"));
        String answer = request.getParameter("option");
        Integer score = (Integer) request.getSession().getAttribute("score");
        Query ans = em.createQuery("SELECT song.correctAnswer FROM SongsEntity song WHERE song.id=:id").setParameter("id",(num));
        String correct = (String) ans.getSingleResult();
        System.out.println("Answer :" + answer + " , correct : " + correct);

        List<SongsEntity> songsEntities = (List<SongsEntity>) request.getSession().getAttribute("songs");
        if(answer.equals(correct)){
            score += 1;
            request.getSession().setAttribute("score",score);
            if(num == songsEntities.size()){
                String message = "{ \"statuss\":\"stop\", \"score\":" + score + "}";
                ObjectMapper objectMapper  = new ObjectMapper();
                String finalMessage = objectMapper.writeValueAsString(message);

                request.getSession().setAttribute("score",score);
                request.getSession().setAttribute("songs",null);
                ArtistEntity currentArtist = (ArtistEntity) request.getSession().getAttribute("artist");
                Integer currentUser = (Integer) request.getSession().getAttribute("user");
                Query prevScore = em.createQuery("SELECT s FROM ScoresEntity s WHERE s.artistByArtist=:artistName " +
                        "AND s.userByUser.id=:id").setParameter("artistName",currentArtist).setParameter("id",currentUser);
                try{
                    ScoresEntity previousScore  = (ScoresEntity) prevScore.getSingleResult();
                    if(previousScore.getScore() < score){
                        utx.begin();
                        ScoresEntity scoresEntity = em.find(ScoresEntity.class,previousScore.getId());
                        scoresEntity.setScore(score);
                        em.persist(scoresEntity);
                        utx.commit();
                    }
                }catch (Exception ex){
                    ScoresEntity scoresEntity = new ScoresEntity();
                    scoresEntity.setArtistByArtist((ArtistEntity) request.getSession().getAttribute("artist"));
                    scoresEntity.setScore(score);
                    Query user = em.createQuery("select users from UsersEntity users where users.id=:id").setParameter("id",currentUser);
                    UsersEntity usersEntity = (UsersEntity) user.getSingleResult();
                    scoresEntity.setUserByUser(usersEntity);
                    try{
                        utx.begin();
                        em.persist(scoresEntity);
                        utx.commit();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                response.getWriter().write(finalMessage);
            }else{
                String message = "{ \"statuss\":\"continue\", \"score\":" + score + "}";
                ObjectMapper objectMapper  = new ObjectMapper();
                String finalMessage = objectMapper.writeValueAsString(message);
                response.getWriter().write(finalMessage);
            }
        }



    }

}
