package ch.makery.address;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.annotation.RunAnnot;
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
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

@AnnotInfo(
        priority = AnnotInfo.Priority.HIGH,
        tags = {"gestion", "roolayout", "referencement", "isplug", "gestion", "fenetre", "general"},
        lastModified = "25/07/2017",
        comsdev = "Fenetre de départ qui permet de gérer la primarystage et le roolayout",
        name= "Mainapp"
)
public class MainApp extends Application {

    private static Stage primaryStage; // notre fenetre
    private BorderPane rootLayout; // le plus haut module de la hierarchie de notre fenetre
    private FXMLLoader loader;
    private static boolean isPlug;


    private static final MainApp instance = new MainApp();
    public static MainApp getInstance() {
        return instance;
    }

    @FXML
    private MenuItem plugIt;

    @FXML
    private MenuItem closer;

    @FXML
    private MenuItem substract;

    public boolean getIsPlug(){
        return isPlug;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // drole d'histoire
        this.primaryStage.setTitle("Mumusique");

        initRootLayout();

        LoginOverviewController loc = new LoginOverviewController();
        loc.showLoginOverview(rootLayout);
    }

    public void initRootLayout() {
        try {
            this.loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load(); // We put in the loader, the BorderPane. after we will go put AnchorPane

            Scene scene = new Scene(rootLayout); // Show the scene containing the root layout.
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() { //like an "fxml constructor"
        plugIt.setOnAction(event -> switchIsPlug());
        plugIt.setText("Activer plugin MuSocial");
        closer.setOnAction(event -> this.primaryStage.close());
        substract.setOnAction(event -> primaryStage.close());
        substract.setOnAction(event -> primaryStage.setIconified(true));
        primaryStage.getIcons().add(new Image("file:ressources/logo.png"));

    }

    public void switchIsPlug(){
        if(isPlug){
            isPlug=false;
            plugIt.setText("Activer plugin MuSocial");
        }else{
            isPlug=true;
            plugIt.setText("Désactiver plugin MuSocial");
        }
        System.out.println(isPlug);
    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args); // c'est le point de départ. Cela va créer un objet MainApp (donc renseigner l'ObservableList, puis executer la methodes start.
        RunAnnot run = new RunAnnot();
        run.PrintAnnot();
    }

    public MainApp() {

    }

}