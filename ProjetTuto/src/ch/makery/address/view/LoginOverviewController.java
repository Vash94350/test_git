package ch.makery.address.view;

import ch.makery.address.MainApp;
import ch.makery.address.managers.LoginManager;
import ch.makery.address.model.Login;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import sun.rmi.runtime.Log;

public class LoginOverviewController {
    @FXML
    private TextField champs_co_email;
    @FXML
    private TextField champs_co_mdp;
    @FXML
    private TextField champs_ins_email;
    @FXML
    private TextField champs_ins_mdp1;
    @FXML
    private TextField champs_ins_mdp2;
    @FXML
    private Button connect;
    @FXML
    private Button inscription;





    // Reference to the main application.
    private MainApp mainApp;

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

    @FXML
    public void loadSignIn() {
        LoginManager lm = new LoginManager();
        Person person = lm.connectUser(champs_co_email.getText(), champs_co_mdp.getText());
    }

    @FXML
    public void loadSignUp() {
        LoginManager lm = new LoginManager();
        String passwd1 = champs_ins_mdp1.getText();
        String passwd2 = champs_ins_mdp2.getText();
        if(passwd1 != null && passwd2 != null && passwd1.equals(passwd2))
            inscription.setOnAction(event -> lm.signUpUser(champs_ins_email.getText(), champs_ins_mdp1.getText()));
        else {

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