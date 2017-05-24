package ch.makery.address;

import java.io.IOException;

import ch.makery.address.model.Musique;
import ch.makery.address.view.MusiqueOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage; // notre fenetre
    private BorderPane rootLayout; // le plus haut module de la hierarchie de notre fenetre

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage; // drole d'histoire
        this.primaryStage.setTitle("Mumusique");

        initRootLayout();

        showMusiqueOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load(); // nous mettons notre fixhier RootLayout dans notre loader en 1er

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene); // on dit à notre scene qu'elle peut se lancer avec rootLayout qui contient RootLayout
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showMusiqueOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MusiqueOverview.fxml"));
            AnchorPane musiqueOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(musiqueOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            MusiqueOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.setMainApp(this); // drole d'histoire

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
    private ObservableList<Musique> musiqueRecentData = FXCollections.observableArrayList();
    private ObservableList<Musique> musiquePopulaireData = FXCollections.observableArrayList();
    private ObservableList<Musique> musiqueAnnee80Data = FXCollections.observableArrayList();
    private ObservableList<Musique> musiqueInstrumentalData = FXCollections.observableArrayList();
    private ObservableList<Musique> musiqueData = FXCollections.observableArrayList();
    private Musique touteLesMusiques[]=new Musique[9];

    /**
     * Constructor
     */
    public MainApp() {

        // Add some sample data
        int i=0;
        // point d'encrage avec la BDD permettant de réupéré les information sur les musiques.
        musiqueData.add(new Musique("Linkin park","Rock","Angleterre","Instrumental"));
        musiqueData.add(new Musique("Louis Amstrong","Jazz","Etats-Unis","Annee80"));
        musiqueData.add(new Musique("Edith Piaf", "Chanson Française","France","Annee80"));
        musiqueData.add(new Musique("Daft Punk", "Electronique","France","Instrumental"));
        musiqueData.add(new Musique("MC Solaar", "Rap","France","Populaire"));
        musiqueData.add(new Musique("Wati B", "Rap","France","Populaire"));
        musiqueData.add(new Musique("Adele", "pop","Angleterre","Recent"));
        musiqueData.add(new Musique("Jaque Brel", "Chanson Française","Belgique","Annee80"));
        musiqueData.add(new Musique("Francky Vincent", "Chanson Française","France","Populaire"));

        while(i<musiqueData.size()){
            if(musiqueData.get(i).getCategorie()=="Recent") {
                musiqueRecentData.add(musiqueData.get(i));
            }
            if(musiqueData.get(i).getCategorie()=="Instrumental") {
                musiqueInstrumentalData.add(musiqueData.get(i));
            }
            if(musiqueData.get(i).getCategorie()=="Annee80") {
                musiqueAnnee80Data.add(musiqueData.get(i));
            }
            if(musiqueData.get(i).getCategorie()=="Populaire") {
                musiquePopulaireData.add(musiqueData.get(i));
            }
            i++;
        }
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Musique> getmusiqueRecentData() {
        return musiqueRecentData;
    }
    public ObservableList<Musique> getmusiquePopulaireData() {
        return musiquePopulaireData;
    }
    public ObservableList<Musique> getmusiqueAnnee80Data() {
        return musiqueAnnee80Data;
    }
    public ObservableList<Musique> getMusiqueInstrumentalData() {
        return musiqueInstrumentalData;
    }
    public Musique[] getMusiques(){
        return touteLesMusiques;
    }
}