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
    }

    public void loadSignIn() {
        LoginManager lm = new LoginManager();
        Person person = lm.connectUser(fieldEmailConnection.getText(), fieldPasswordConnection.getText());

        if(person != null) {
            System.out.println(rLayout);

            showMusicOverview(person);
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

        else {

        }
    }

    public void showLoginOverview(BorderPane rootLayout) {
        try {

            LoginOverviewController lOC = new LoginOverviewController();

            FXMLLoader loader = new FXMLLoader();
            loader.setController(lOC);
            loader.setLocation(MainApp.class.getResource("view/LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview
            lOC.rLayout = rootLayout;


            //this.setMainApp(app); // drole d'histoire

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMusicOverview(Person person) {
        try {
            // Load musique overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MusiqueOverview.fxml"));
            AnchorPane musicOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rLayout.setCenter(musicOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            MusiqueOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.setMainApp(mainApp, person); // drole d'histoire


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