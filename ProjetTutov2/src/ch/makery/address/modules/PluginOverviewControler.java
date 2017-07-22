package ch.makery.address.modules;

import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import ch.makery.address.util.IModule;
import ch.makery.address.util.ModuleLoader;
import ch.makery.address.view.MusiqueOverviewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import ch.makery.address.MainApp;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PluginOverviewControler {

    @FXML
    protected MenuItem seeFriends;

    @FXML
    private TableView<Music> musicRapTable;
    @FXML
    private TableColumn<Music, String> bandRapColumn;
    @FXML
    private TableColumn<Music, String> nameRapColumn;

    @FXML
    private TableView<Music> musicFrenchTable;
    @FXML
    private TableColumn<Music, String> bandFrenchColumn;
    @FXML
    private TableColumn<Music, String> nameFrenchColumn;

    @FXML
    private TableView<Music> musicPopTable;
    @FXML
    private TableColumn<Music, String> bandPopColumn;
    @FXML
    private TableColumn<Music, String> namePopColumn;

    @FXML
    private TableView<Music> musicJazzTable;
    @FXML
    private TableColumn<Music, String> bandJazzColumn;
    @FXML
    private TableColumn<Music, String> nameJazzColumn;

    @FXML
    private Label bandNameLabel;
    @FXML
    private Label styleLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label releaseDateLabel;
    @FXML
    private ChoiceBox<String> styleChoice;

    @FXML
    private ChoiceBox<String> friendList;

    @FXML
    public Label userConnected;

    @FXML
    private CheckBox plugIn;

    @FXML
    private Button retour;

    public PluginOverviewControler(){

    }

    @FXML
    private void initialize() { // c'est comme un constructeur
    }

    public void showMusiqueOverview(BorderPane rootlayout){
        try {
            // Load musique overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("modules/PluginOverview.fxml"));
            AnchorPane musicOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootlayout.setCenter(musicOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            PluginOverviewControler controller = loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void back(){
        MusiqueOverviewController mOC=new MusiqueOverviewController();
        mOC.showMusiqueOverview();
    }*/
}