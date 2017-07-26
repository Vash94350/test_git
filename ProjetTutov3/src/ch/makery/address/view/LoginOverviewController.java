package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.managers.LoginManager;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

@AnnotInfo(
        priority = AnnotInfo.Priority.HIGH,
        tags = {"affichage", "fenetre", "login", "gestion event"},
        lastModified = "24/07/2017",
        comsdev = "Recois en argument la rootlayout et permet de se diriger vers MusicOverviewController",
        name= "LoginOverviewController"
)
public class LoginOverviewController {
    @FXML
    private TextField fieldEmailConnection;
    @FXML
    private PasswordField fieldPasswordConnection;
    @FXML
    private TextField fieldEmailLogin;
    @FXML
    private PasswordField fieldPasswordLogin_1;
    @FXML
    private PasswordField fieldPasswordLogin_2;
    @FXML
    private Button connect;
    @FXML
    private Button inscription;
    @FXML
    private TextField fieldPseudoLogin;
    @FXML
    private TextField fieldLastNameLogin;
    @FXML
    private TextField fieldFirstNameLogin;
    @FXML
    private Label printInformations;
    @FXML
    private Label errorSignUp;

    private Stage primaryStage;
    private MainApp mainApp;
    private BorderPane rLayout;

    public LoginOverviewController() { //voir initialize
    }

    @FXML
    private void initialize() { // c'est comme un constructeur
    }

    public void loadSignIn() {
        LoginManager lm = new LoginManager();

        if(fieldEmailConnection != null && fieldPasswordConnection != null && !fieldEmailConnection.getText().equals("") && !fieldPasswordConnection.getText().equals("")) {

            String session = lm.connectUser(fieldEmailConnection.getText(), fieldPasswordConnection.getText());

            if (session.contains("id_token")) {
                ArrayList<String> al = new ArrayList<>();

                session = session.replace('{', ' ');
                session = session.replace('}', ' ');
                String[] pair = session.split(",");

                for (int i = 0; i < pair.length; i++) {
                    String[] value = pair[i].split(":");
                    value[1] = value[1].replaceAll("\"", "");
                    al.add(value[1]);
                }

                Person person = new Person(al.get(0), al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6));

                MusiqueOverviewController.getInstance().showMusiqueOverview(person, rLayout);
            } else {
                printInformations.setText(session);
            }
        }
        else {
            printInformations.setText("Vous devez renseigner les deux champs");
        }
    }

    @FXML
    public void loadSignUp() {
        LoginManager lm = new LoginManager();
        String passwd1 = fieldPasswordLogin_1.getText();
        String passwd2 = fieldPasswordLogin_2.getText();
        String pseudo = fieldPseudoLogin.getText();
        String email = fieldEmailLogin.getText();
        String name = fieldLastNameLogin.getText();
        String firstname = fieldFirstNameLogin.getText();
        String session = "";

        if(!pseudo.equals("") && !email.equals("") && !name.equals("") && !firstname.equals("")) {

            if (passwd1 != null && passwd2 != null && passwd1.equals(passwd2) && !passwd1.equals("") && !passwd2.equals("")) {
                session = lm.signUpUser(fieldEmailLogin.getText(), fieldPasswordLogin_1.getText(), fieldPseudoLogin.getText(), fieldFirstNameLogin.getText(), fieldLastNameLogin.getText());

                if (session.contains("id_token")) {
                    ArrayList<String> al = new ArrayList<>();

                    session = session.replace('{', ' ');
                    session = session.replace('}', ' ');
                    String[] pair = session.split(",");

                    for (int i = 0; i < pair.length; i++) {
                        String[] value = pair[i].split(":");
                        value[1] = value[1].replaceAll("\"", "");
                        al.add(value[1]);
                    }

                    Person person = new Person(al.get(0), al.get(1), al.get(2), al.get(3), al.get(4), al.get(5), al.get(6));

                    MusiqueOverviewController.getInstance().showMusiqueOverview(person, rLayout);
                } else {
                    errorSignUp.setText(session);
                }
            } else {
                errorSignUp.setText("Les mots de passe renseignés ne sont pas identiques");
            }
        }
        else {
            errorSignUp.setText("Veuillez renseigner tous les champs");
        }
    }

    public void showLoginOverview(BorderPane rootLayout) {
        try {

            LoginOverviewController lOC = new LoginOverviewController();

            FXMLLoader loader = new FXMLLoader();
            loader.setController(lOC);
            loader.setLocation(MainApp.class.getResource("view/LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            rootLayout.setCenter(loginOverview);
            lOC.rLayout = rootLayout;

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
            rLayout.setCenter(musicOverview);

            // Give the controller access to the main app.
            MusiqueOverviewController controller = loader.getController();
            controller.setUserConnected(person);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}