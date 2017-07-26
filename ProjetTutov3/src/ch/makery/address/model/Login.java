package ch.makery.address.model;

import ch.makery.address.annotation.AnnotInfo;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@AnnotInfo(
        priority = AnnotInfo.Priority.LOW,
        tags = {"Getter/setter", "Authentification"},
        lastModified = "23/07/2017",
        comsdev = "Class très peu utilisé, remplacé par Person",
        name= "Login"
)
public class Login {
    private final StringProperty email;
    private final StringProperty password;

    public Login() {
        this(null, null);
    }

    /**
     * Constructor with some initial data.
     *
     * @param email
     * @param password
     */
    public Login(String email, String password) {
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String firstName) {
        this.email.set(firstName);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String firstName) {
        this.password.set(firstName);
    }

    public StringProperty passwordProperty() {
        return password;
    }


}
