package ch.makery.address.managers;

import ch.makery.address.classes.Music;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by torgu on 14/06/2017.
 */
public class MusicManager {

    private String user = "root";
    private String password = "";
    private Connection connexion = null;
    private String dbName = "muMusique";
    private String url = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false&serverTimezone=UTC";


    public ArrayList<Music> getAllmusics() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection(url, user, password);

        ArrayList<Music> list = new ArrayList<>();

        String sql = "Select * from musique";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            list.add(setMusicInformation(rs));
        }

        return list;
    }

    private Music setMusicInformation(ResultSet rs) throws SQLException {
        Music music = new Music();

        music.setName(rs.getString("nom"));
        music.setCountry(rs.getString("pays"));
        music.setDescription(rs.getString("description"));
        music.setDuration(rs.getString("durée"));
        music.setSinger(rs.getString("chanteur"));
        music.setSort(rs.getString("genre"));
        music.setType(rs.getString("type"));
        music.setUrl(rs.getString("chemin"));
        music.setViews(rs.getInt("vue"));

        return music;
    }
}
