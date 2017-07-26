package ch.makery.address.modules;

import ch.makery.address.MainApp;
import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import ch.makery.address.view.MusiqueOverviewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.ArrayList;


public class PluginOverviewControler {

    @FXML
    private Button retour;

    @FXML
    private TableView<Music> musicFavoriteTable;
    @FXML
    private TableColumn<Music, String> bandFavoriteColumn;
    @FXML
    private TableColumn<Music, String> nameFavoriteColumn;

    @FXML
    private Label bandNameLabel;
    @FXML
    private Label styleLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label releaseDateLabel;

    @FXML
    private Button play;

    private static final PluginOverviewControler instance = new PluginOverviewControler();
    public static PluginOverviewControler getInstance() {
        return instance;
    }

    private static BorderPane rLayout;
    private static Person person;

    private ObservableList<Music> favoritesMusicData = FXCollections.observableArrayList();

    public ObservableList<Music> getFavoritesMusicData() {
        return favoritesMusicData;
    }

    public PluginOverviewControler(){
    }

    @FXML
    private void initialize() { // like an "fxml constructor"

        bandFavoriteColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameFavoriteColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());

        musicFavoriteTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));

        musicFavoriteTable.setItems(getFavoritesMusicData());
    }

    public void showPluginOverview(BorderPane rootlayout,Person person, String selectedFriendId){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PluginOverview.fxml"));
            loader.setController(this); // affecting controller whithout view (.fxml)
            System.out.println(MainApp.getInstance().getIsPlug());
            AnchorPane musicOverview = (AnchorPane) loader.load();

            rootlayout.setCenter(musicOverview);

            showFavorites(selectedFriendId);

            //drop attribute
            rLayout=rootlayout;
            this.person=person;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showFavorites(String idUser) {
        try {


            MusicManager mm = new MusicManager();

            ArrayList<Music> list = mm.getFavoritesmusics(idUser);

            for (Music music : list) {
                favoritesMusicData.add(new Music(music.getName(), music.getDescription(), music.getDuration(), music.getSinger(), music.getViews(), music.getUrl(), music.getSort(), music.getCountry(), music.getDate(), music.getId()));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMusiqueDetails(Music music) {
        if (music != null) {  // cette methode permet d'écrire du texte dans les label de droite a partir des donné renseigné dans personData(voir mainApp).

            bandNameLabel.setText(music.getSinger());
            styleLabel.setText(music.getSort());
            countryLabel.setText(music.getCountry());
            releaseDateLabel.setText(music.getDate());

            MusiqueOverviewController mOC = new MusiqueOverviewController();
            play.setOnAction(event -> mOC.playMusique(music.getUrl()));

        } else {

            bandNameLabel.setText("");
            styleLabel.setText("");
            countryLabel.setText("");
            releaseDateLabel.setText("");
        }
    }

    @FXML
    public void back(){
        MusiqueOverviewController.getInstance().showMusiqueOverview(person,rLayout);
    }
}