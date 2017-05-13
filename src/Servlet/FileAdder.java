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
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import Entity.ArtistEntity;
import Entity.SongsEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Created by Moudi on 5/9/2017.
 */
@WebServlet(name = "FileAdder")
public class FileAdder extends HttpServlet {
    @PersistenceContext
    private EntityManager em;
    @Resource
    private UserTransaction userTransaction;

    private ServletFileUpload uploader = null;

    @Override
    public void init() throws ServletException{
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileItemFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileItemFactory);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try{
            List<FileItem> fileItemList = uploader.parseRequest(request);
            Iterator<FileItem> fileItemsIterator = fileItemList.iterator();
            SongsEntity songsEntity = new SongsEntity();

            while(fileItemsIterator.hasNext()){
                FileItem fileItem = fileItemsIterator.next();
                if(fileItem.isFormField()){
                    if(fileItem.getFieldName().equals("varAnswerOne")){
                        songsEntity.setVarAnswerOne(fileItem.getString());
                    }else if (fileItem.getFieldName().equals("varAnswerTwo")){
                        songsEntity.setVarAnswerTwo(fileItem.getString());
                    }else if (fileItem.getFieldName().equals("varAnswerThree")){
                        songsEntity.setVarAnswerThree(fileItem.getString());
                    }else if (fileItem.getFieldName().equals("varAnswerFour")){
                        songsEntity.setVarAnswerFour(fileItem.getString());
                    }else if(fileItem.getFieldName().equals("artist")){
                        Query artist = em.createQuery("SELECT a FROM ArtistEntity a where a.name=:name").setParameter("name",fileItem.getString());
                        ArtistEntity artistEntity = (ArtistEntity) artist.getSingleResult();
                        songsEntity.setArtistByArtist(artistEntity);
                    }else if(fileItem.getFieldName().equals("option")){
                        songsEntity.setCorrectAnswer(fileItem.getString());
                    }
                }else{
                    songsEntity.setFileName(fileItem.getName());
                    songsEntity.setFilePath("songs/"+ fileItem.getName());
                    File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
                    fileItem.write(file);
                }
            }
            try{
                userTransaction.begin();
                em.persist(songsEntity);
                userTransaction.commit();
                ObjectMapper objectMapper = new ObjectMapper();
                String success = "Success";
                String reply = objectMapper.writeValueAsString(success);
                response.getWriter().write(reply);
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
            ObjectMapper objectMapper = new ObjectMapper();
            String reply = objectMapper.writeValueAsString("Server error encountered");
            response.getWriter().write(reply);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
