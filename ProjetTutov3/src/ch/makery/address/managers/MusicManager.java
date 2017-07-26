package ch.makery.address.managers;

import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by torgu on 14/06/2017.
 */
@AnnotInfo(
        priority = AnnotInfo.Priority.HIGH,
        tags = {"Chargement", "information", "Musique", "Amis"},
        lastModified = "25/07/2017",
        comsdev = "Indique dans la console si la requête POST ou GET",
        name= "MusicManager"
)
public class MusicManager {

    private String user = "root";
    private String password = "root";
    private Connection connexion = null;
    private String dbName = "muMusique";
    private String url = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private final String USER_AGENT = "Mozilla/5.0";


    public ArrayList<Music> getAllmusics() throws Exception {

        String url = "http://localhost:8080/allMusics";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        String res = response.toString();

        ArrayList<String> listString = new ArrayList<>();
        ArrayList<Music> list = new ArrayList<>();

        res = res.substring(2, res.length() - 1);
        String[] music = res.split("\\{");

        for (int i=0; i<music.length; i++) {
            music[i] = music[i].replaceAll("\"", "").replaceAll("\\}", "");
            String[] information = music[i].split(",");
            for(int j=0; j<information.length; j++) {
                String[] keyValue = information[j].split(":");
                listString.add(keyValue[1]);
            }
            list.add(setMusicInformation(listString));
            listString = new ArrayList<>();
        }

        return list;
    }

    private Music setMusicInformation(ArrayList<String> list) throws SQLException {
        Music music = new Music();

        music.setName(list.get(0));
        music.setCountry(list.get(7));
        music.setDescription(list.get(1));
        music.setDuration(list.get(2));
        music.setSinger(list.get(3));
        music.setSort(list.get(6));
        music.setUrl(list.get(5));
        music.setViews(list.get(4));
        music.setDate(list.get(8));
        music.setId(list.get(9));

        return music;
    }

    public ArrayList<String> getAllSorts() throws Exception {

        String url = "http://localhost:8080/allSorts";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());
        String res = response.toString();

        res = res.replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "");

        String[] sort = res.split(",");
        ArrayList<String> sorts = new ArrayList<>();

        for (int i=0; i<sort.length; i++) {
            sorts.add(sort[i]);
        }

        return sorts;
    }

    public void addToFavorites(String idMusic, String idUser) throws Exception {

        URL url = new URL("http://localhost:8080/addFavorite");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("idMusic="+idMusic+"&idUser="+idUser);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        writer.close();
        reader.close();

        System.out.println(response.toString());
    }

    public ArrayList<Music> getFavoritesmusics(String idUser) throws Exception {
        URL url = new URL("http://localhost:8080/favorites");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("idUser="+idUser);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        writer.close();
        reader.close();

        System.out.println(response.toString());
        String res = response.toString();

        ArrayList<String> listString = new ArrayList<>();
        ArrayList<Music> list = new ArrayList<>();

        if(res.length() > 2) {
            res = res.substring(2, res.length() - 1);
            String[] music = res.split("\\{");

            for (int i = 0; i < music.length; i++) {
                music[i] = music[i].replaceAll("\"", "").replaceAll("\\}", "");
                String[] information = music[i].split(",");
                for (int j = 0; j < information.length; j++) {
                    String[] keyValue = information[j].split(":");
                    listString.add(keyValue[1]);
                }
                list.add(setMusicInformation(listString));
                listString = new ArrayList<>();
            }
        }

        return list;
    }

    public ArrayList<Person> getFriends(String userId) throws  Exception {
        URL url = new URL("http://localhost:8080/friends");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        System.out.println("\nSending 'POST' request to URL : " + url);

        writer.write("idUser="+userId);
        writer.flush();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer response = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        writer.close();
        reader.close();

        System.out.println(response.toString());
        String res = response.toString();

        ArrayList<String> listString = new ArrayList<>();
        ArrayList<Person> list = new ArrayList<>();

        if(res.length() > 2) {
            res = res.substring(2, res.length() - 1);
            String[] person = res.split("\\{");

            for (int i = 0; i < person.length; i++) {
                System.out.println(person);
                person[i] = person[i].replaceAll("\"", "").replaceAll("\\}", "");
                String[] information = person[i].split(",");
                for (int j = 0; j < information.length; j++) {
                    String[] keyValue = information[j].split(":");
                    listString.add(keyValue[1]);
                }
                list.add(setPersonInformation(listString));
                listString = new ArrayList<>();
            }
        }
        return list;
    }

    private Person setPersonInformation(ArrayList<String> list) throws SQLException {
        Person person = new Person();

        person.setEmail(list.get(0));
        person.setPassword(list.get(1));
        person.setFirstName(list.get(2));
        person.setLastName(list.get(3));
        person.setLogin(list.get(4));
        person.setId(list.get(5));

        return person;
    }
}
