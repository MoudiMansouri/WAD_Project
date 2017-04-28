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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request,response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        Integer num = Integer.parseInt(request.getParameter("num"));
        System.out.println("Number is now :" + num);
        String answer = request.getParameter("option");
        Integer score = (Integer) request.getSession().getAttribute("score");
        Query ans = em.createQuery("SELECT song.correctAnswer FROM SongsEntity song WHERE song.id=:id").setParameter("id",(num));
        String correct = (String) ans.getSingleResult();
        if(answer.equals(correct)){
            score += 1;
            System.out.println("Correct! Score is now : " + score);
            request.getSession().setAttribute("score",score);
        }
        if(num == 3){
            System.out.println("Your score is " + request.getSession().getAttribute("score"));
            request.getSession().setAttribute("score",score);

            request.getSession().setAttribute("songs",null);
            ObjectMapper objectMapper = new ObjectMapper();
            String sendScore = objectMapper.writeValueAsString(new Integer(score));
            System.out.println(sendScore);
            response.getWriter().write(sendScore);
        }
    }
}
