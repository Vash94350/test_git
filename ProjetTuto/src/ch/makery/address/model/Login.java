package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
