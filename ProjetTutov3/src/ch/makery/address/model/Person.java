package ch.makery.address.model;

import java.time.LocalDate;

import ch.makery.address.annotation.AnnotInfo;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@AnnotInfo(
        priority = AnnotInfo.Priority.MEDIUM,
        tags = {"stockage", "Utilisateur", "getter/setter"},
        lastModified = "24/07/2017",
        comsdev = "Contient tocken de session pas encore utilisé",
        name= "Person"
)
public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty email;
    private final StringProperty password;
    private final StringProperty login;
    private final StringProperty token_seesion;
    private final StringProperty id;

    /**
     * Default constructor.
     */
    public Person() {
        this(null, null, null, null, null, null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param email
     * @param password
     */
    public Person(String email, String password, String firstname, String lastname, String login, String token_session, String id) {
        this.id = new SimpleStringProperty(id);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.firstName = new SimpleStringProperty(firstname);
        this.lastName = new SimpleStringProperty(lastname);
        this.login = new SimpleStringProperty(login);
        this.token_seesion = new SimpleStringProperty(token_session);
    }

    public String getId() { return id.get();}

    public void setId(String id) { this.id.set(id);}

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getLogin() {
        return login.get();
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {return lastName;}

    public void setToken_seesion(String token_seesion) { this.token_seesion.set(token_seesion);}

    public String getToken_Session() { return token_seesion.get(); }

    public StringProperty token_SessionProperty() { return token_seesion; }
}