package ch.makery.address.managers;

import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.model.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by torgu on 02/07/2017.
 */

@AnnotInfo(
        priority = AnnotInfo.Priority.HIGH,
        tags = {"Fonction WebService", "connection/inscription"},
        lastModified = "25/07/2017",
        comsdev = "Fichier pilier de l'application. Sans lui pas d'accès au reste de l'application",
        name= "LoginManager"
)
public class LoginManager {
    private String user = "root";
    private String password = "";
    private Connection connection = null;
    private String dbName = "muMusique";
    private String url = "jdbc:mysql://localhost:3306/"+dbName+"?autoReconnect=true&useSSL=false&serverTimezone=UTC";
    private final String USER_AGENT = "Mozilla/5.0";

    public String connectUser(String email, String passwd) {
        try {
            String response = checkIdentifiersSignInPost(email, passwd);
            return response;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String signUpUser(String email, String passwd, String username, String firstname, String lastname) {
        try {
            String res = checkIdentifiersSignUpPost(email, passwd, username, firstname, lastname);
            if(res.contains("Success")) {
                return connectUser(email, passwd);
            }
            else {
                return res;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkIdentifiersSignUpPost(String email, String passwd, String username, String firstname, String lastname) throws Exception {

        URL url = new URL("http://localhost:8080/signUp");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("email="+email+"&password="+passwd+"&username="+username+"&firstname="+firstname+"&lastname="+lastname);
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
        return response.toString();
    }

    public String checkIdentifiersSignInPost(String email, String psswd) throws Exception {

        URL url = new URL("http://localhost:8080/signIn");
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

        writer.write("email="+email+"&password="+psswd);
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
        return response.toString();

    }
}
