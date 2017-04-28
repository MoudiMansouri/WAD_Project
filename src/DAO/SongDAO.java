package DAO;

public class SongDAO {

    String name;

    public SongDAO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SongDAO{" +
                "name='" + name + '\'' +
                '}';
    }
}
