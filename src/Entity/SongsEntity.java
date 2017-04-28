package Entity;

import javax.persistence.*;

/**
 * Created by Moudi on 4/16/2017.
 */
@Entity
@Table(name = "songs", schema = "wad_project")
public class SongsEntity {
    private int id;
    private String fileName;
    private String filePath;
    private String correctAnswer;
    private String varAnswerOne;
    private String varAnswerTwo;
    private String varAnswerThree;
    private String varAnswerFour;
    private ArtistEntity artistEntity;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "correct_answer")
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Basic
    @Column(name = "var_answer_one")
    public String getVarAnswerOne() {
        return varAnswerOne;
    }

    public void setVarAnswerOne(String varAnswerOne) {
        this.varAnswerOne = varAnswerOne;
    }

    @Basic
    @Column(name = "var_answer_two")
    public String getVarAnswerTwo() {
        return varAnswerTwo;
    }

    public void setVarAnswerTwo(String varAnswerTwo) {
        this.varAnswerTwo = varAnswerTwo;
    }

    @Basic
    @Column(name = "var_answer_three")
    public String getVarAnswerThree() {
        return varAnswerThree;
    }

    public void setVarAnswerThree(String varAnswerThree) {
        this.varAnswerThree = varAnswerThree;
    }

    @Basic
    @Column(name = "var_answer_four")
    public String getVarAnswerFour() {
        return varAnswerFour;
    }

    public void setVarAnswerFour(String varAnswerFour) {
        this.varAnswerFour = varAnswerFour;
    }

    @ManyToOne
    @JoinColumn(name = "Artist")
    public ArtistEntity getArtistEntity() {
        return artistEntity;
    }

    public void setArtistEntity(ArtistEntity artistEntity) {
        this.artistEntity = artistEntity;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SongsEntity that = (SongsEntity) o;

        if (id != that.id) return false;
        if (fileName != null ? !fileName.equals(that.fileName) : that.fileName != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (correctAnswer != null ? !correctAnswer.equals(that.correctAnswer) : that.correctAnswer != null)
            return false;
        if (varAnswerOne != null ? !varAnswerOne.equals(that.varAnswerOne) : that.varAnswerOne != null) return false;
        if (varAnswerTwo != null ? !varAnswerTwo.equals(that.varAnswerTwo) : that.varAnswerTwo != null) return false;
        if (varAnswerThree != null ? !varAnswerThree.equals(that.varAnswerThree) : that.varAnswerThree != null)
            return false;
        if (varAnswerFour != null ? !varAnswerFour.equals(that.varAnswerFour) : that.varAnswerFour != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
        result = 31 * result + (varAnswerOne != null ? varAnswerOne.hashCode() : 0);
        result = 31 * result + (varAnswerTwo != null ? varAnswerTwo.hashCode() : 0);
        result = 31 * result + (varAnswerThree != null ? varAnswerThree.hashCode() : 0);
        result = 31 * result + (varAnswerFour != null ? varAnswerFour.hashCode() : 0);
        return result;
    }
}
