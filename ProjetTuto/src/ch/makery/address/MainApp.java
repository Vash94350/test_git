package ch.makery.address;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
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

        showMusiqueOverview(null); // Il faut inserer le Z index ici pour l'instant on ne lance que la fenetre de connection
        //showLoginOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane)loader.load(); // nous mettons notre fichier RootLayout dans notre loader en 1er

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
    public void showMusiqueOverview(Person person) {
        try {
            // Load musique overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MusiqueOverview.fxml"));
            AnchorPane musiqueOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(musiqueOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            MusiqueOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.setMainApp(this, person); // drole d'histoire

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showLoginOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/LoginOverview.fxml"));
            AnchorPane loginOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(loginOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            /*LoginOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.setMainApp(this); // drole d'histoire*/

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
    private ObservableList<Music> musicRapData = FXCollections.observableArrayList();
    private ObservableList<Music> frenchMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> popMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> jazzMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> musicData = FXCollections.observableArrayList();
    private ObservableList<String> style_of_musique = FXCollections.observableArrayList();
    private Music allMusics[]=new Music[9];

    /**
     * Constructor
     */
    public MainApp() {

        // Add some sample data
        int i=0;
        try {


            MusicManager mm = new MusicManager();

            ArrayList<Music> list = mm.getAllmusics();

            for (Music music : list) {
                musicData.add(new Music(music.getName(), music.getDescription(), music.getDuration(), music.getSinger(), music.getViews(), music.getUrl(), music.getSort(), music.getCountry()));
            }

            while (i < musicData.size()) {
                if (musicData.get(i).getSort().equals("Rap")) {
                    musicRapData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Chanson Française")) {
                    frenchMusicData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Pop")) {
                    popMusicData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Jazz")) {
                    jazzMusicData.add(musicData.get(i));
                }
                i++;
            }

            ArrayList<String> sorts = mm.getAllSorts();

            for(String str : sorts) {
                style_of_musique.add(str);
            }
            style_of_musique.add("Aucun filtre");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Music> getRapMusicData() {
        return musicRapData;
    }
    public ObservableList<Music> getFrenchMusicData() { return frenchMusicData;}
    public ObservableList<Music> getPopMusicData() { return popMusicData;}
    public ObservableList<Music> getJazzMusicData() {
        return jazzMusicData;
    }
    public Music[] getMusics(){
        return allMusics;
    }


    public ObservableList<String> getStyle_Of_Musique() {
        return style_of_musique;
    }
}