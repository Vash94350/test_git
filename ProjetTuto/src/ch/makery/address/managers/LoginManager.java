package ch.makery.address.managers;

import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import sun.applet.Main;

import java.sql.*;

/**
 * Created by torgu on 02/07/2017.
 */
public class LoginManager {
    private String user = "root";
    private String password = "";
    private Connection connexion = null;
    private String dbName = "muMusique";
    private String url = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false&serverTimezone=UTC";

    public Person connectUser(String email, String passwd) {
        try {
            Person person = checkIdentifiersSignIn(email, passwd);
            if(person.getLogin() != null) {
                MainApp app = new MainApp();
                return person;
            }
            else {
                return null;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person checkIdentifiersSignIn(String email, String passwd) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection(url, user, password);

        String sql = "Select * from compte where email = ? and mdp = ?";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, passwd);
        ResultSet rs = ps.executeQuery();

        Person p = new Person();

        while (rs.next()) {
            p = new Person(rs.getString("email"), rs.getString("mdp"), rs.getString("prenom"), rs.getString("nom"), rs.getString("login"));
        }

        connexion.close();
        return p;
    }

    public void signUpUser(String email, String passwd) {
        try {
            boolean res = checkIdentifiersSignUp(email, passwd);
            if(res) {
                connectUser(email, passwd);
            }
            else {

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkIdentifiersSignUp(String email, String passwd) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connexion = DriverManager.getConnection(url, user, password);

        String sql = "Select * from compte where email = ?";
        PreparedStatement ps = connexion.prepareStatement(sql);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        Person p = new Person();

        while (rs.next()) {
            connexion.close();
            return false;
        }

        sql = "Insert into compte (email, mdp, niveau) values(?, ?, 0)";
        ps = connexion.prepareStatement(sql);
        ps.setString(1, email);
        ps.setString(2, passwd);
        ps.execute();

        connexion.close();
        return true;
    }
}
