package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.managers.LoginManager;
import ch.makery.address.model.Login;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

import java.io.IOException;

public class LoginOverviewController {
    @FXML
    private TextField fieldEmailConnection;
    @FXML
    private TextField fieldPasswordConnection;
    @FXML
    private TextField fieldEmailLogin;
    @FXML
    private TextField fieldPasswordLogin_1;
    @FXML
    private TextField fieldPasswordLogin_2;
    @FXML
    private Button connect;
    @FXML
    private Button inscription;
    @FXML
    private Label printInformations;

    // Reference to the main application.
    private Stage primaryStage;
    private MainApp mainApp;
    private BorderPane rLayout;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public LoginOverviewController() { //voir initialize
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() { // c'est comme un constructeur
        fieldEmailConnection.setText("test01@test01.com");
        fieldPasswordConnection.setText("test01");
    }

    public void loadSignIn() {
        LoginManager lm = new LoginManager();
        Person person = lm.connectUser(fieldEmailConnection.getText(), fieldPasswordConnection.getText());

        if(person != null) {
            MusiqueOverviewController mOC=new MusiqueOverviewController();
            mOC.showMusiqueOverview(person,rLayout);
        }
        else {
            printInformations.setText("Login ou Mot de passe invalide");
        }
    }

    @FXML
    public void loadSignUp() {
        LoginManager lm = new LoginManager();
        String passwd1 = fieldPasswordLogin_1.getText();
        String passwd2 = fieldPasswordLogin_2.getText();
        Person person = new Person();
        if(passwd1 != null && passwd2 != null && passwd1.equals(passwd2))
            person = lm.signUpUser(fieldEmailLogin.getText(), fieldPasswordLogin_1.getText());
    }

    public void showLoginOverview(BorderPane rootLayout) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setController(this);
            loader.setLocation(MainApp.class.getResource("view/LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview
            this.rLayout = rootLayout;

            //this.setMainApp(app); // drole d'histoire

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param login the person or null
     */
}