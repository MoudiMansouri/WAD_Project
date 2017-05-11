package Listeners; /**
 * Created by Moudi on 3/20/2017.
 */




import Entity.ArtistEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;
import java.util.List;

@WebListener()
public class ContextListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    @PersistenceContext
    private EntityManager em;
    // Public constructor is required by servlet spec
    public ContextListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.s
      */
        Query loadArtist = em.createQuery("SELECT artist from ArtistEntity artist");
        List<ArtistEntity> artistEntities = loadArtist.getResultList();
        sce.getServletContext().setAttribute("Artists",artistEntities);
        String rootPath = System.getProperty("catalina.home","C:\\Users\\Moudi\\IdeaProjects\\WAD_Project_Updated\\web");
        ServletContext ctx = sce.getServletContext();
        String path = ctx.getInitParameter("Songs.dir");
        File file = new File(rootPath, File.separator + path);
        if(!file.exists()){
            file.mkdirs();
        }
        ctx.setAttribute("FILES_DIR_FILE",file);
        ctx.setAttribute("FILES_DIR",rootPath + File.separator + path);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
