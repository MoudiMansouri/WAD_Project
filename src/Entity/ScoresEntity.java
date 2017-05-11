package Entity;

import javax.persistence.*;

/**
 * Created by Moudi on 5/11/2017.
 */
@Entity
@Table(name = "scores", schema = "wad_project", catalog = "")
public class ScoresEntity {
    private int id;
    private Integer score;
    private ArtistEntity artistByArtist;
    private UsersEntity user;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "score")
    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScoresEntity that = (ScoresEntity) o;

        if (id != that.id) return false;
        if (score != null ? !score.equals(that.score) : that.score != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }



    @ManyToOne
    @JoinColumn(name = "artist", referencedColumnName = "ID")
    public ArtistEntity getArtistByArtist() {
        return artistByArtist;
    }

    public void setArtistByArtist(ArtistEntity artistByArtist) {
        this.artistByArtist = artistByArtist;
    }

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "ID")
    public UsersEntity getUserByUser() {
        return user;
    }

    public void setUserByUser(UsersEntity usersEntity) {
        this.user = usersEntity;
    }
}
