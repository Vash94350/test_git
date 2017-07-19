package ch.makery.address;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import ch.makery.address.view.LoginOverviewController;
import ch.makery.address.view.MusiqueOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage; // notre fenetre
    private BorderPane rootLayout; // le plus haut module de la hierarchie de notre fenetre
    private FXMLLoader loader;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // drole d'histoire
        this.primaryStage.setTitle("Mumusique");

        initRootLayout();
        LoginOverviewController loc = new LoginOverviewController();
        //showMusicOverview(null); // Il faut inserer le Z index ici pour l'instant on ne lance que la fenetre de connection
        loc.showLoginOverview(rootLayout);
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            this.loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load(); // nous mettons notre fichier RootLayout dans notre loader en 1er
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene); // on dit à notre scene qu'elle peut se lancer avec rootLayout qui contient RootLayout
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args); // c'est le point de départ. Cela va créer un objet MainApp (donc renseigner l'ObservableList, puis executer la methodes start.
    }

    /**
     * The data as an observable list of Persons.
     */

    /**
     * Constructor
     */
    public MainApp() {

    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */

}