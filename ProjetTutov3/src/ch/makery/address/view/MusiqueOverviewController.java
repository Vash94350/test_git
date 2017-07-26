package ch.makery.address.view;

import ch.makery.address.annotation.AnnotInfo;
import ch.makery.address.managers.MusicManager;
import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import ch.makery.address.util.IModule;
import ch.makery.address.util.ModuleLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import ch.makery.address.MainApp;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AnnotInfo(
        priority = AnnotInfo.Priority.HIGH,
        tags = {"affichage", "fenetre", "Musique", "gestion event"},
        lastModified = "25/07/2017",
        comsdev = "Fenetre recevant une personne depuis LoginOverview et pouvant afficher ,si chargé, la fenetre plugin",
        name= "MusiqueOverviewController"
)
public class MusiqueOverviewController {

    @FXML
    protected MenuItem seeFriends;

    @FXML
    private Label rapLabel;
    @FXML
    private Label frenchLabel;
    @FXML
    private Label popLabel;
    @FXML
    private Label jazzLabel;
    @FXML
    private Label rockLabel;
    @FXML
    private Label favoritesLabel;

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
    private TableView<Music> musicRockTable;
    @FXML
    private TableColumn<Music, String> bandRockColumn;
    @FXML
    private TableColumn<Music, String> nameRockColumn;

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
    private ChoiceBox<String> styleChoice;

    @FXML
    private ChoiceBox<String> friendList;

    @FXML
    public Label userConnected;

    @FXML
    private Button plugin;

    @FXML
    private Button play;

    @FXML
    private Button addfavoris;

    @FXML
    private Button logout;


    private static BorderPane rLayout;
    private static Person person;

    private HashMap<String, String> friends = new HashMap<>();

    private static final MusiqueOverviewController instance = new MusiqueOverviewController(); //En plus
    public static MusiqueOverviewController getInstance() {
        return instance;
    }//En plus

    private ObservableList<Music> musicRapData = FXCollections.observableArrayList();
    private ObservableList<Music> frenchMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> popMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> jazzMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> rockMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> favoritesMusicData = FXCollections.observableArrayList();
    private ObservableList<Music> musicData = FXCollections.observableArrayList();
    private ObservableList<String> style_of_music = FXCollections.observableArrayList();
    private ObservableList<String> my_friends = FXCollections.observableArrayList();
    private Music allMusics[]=new Music[9];

    public ObservableList<Music> getRapMusicData() {
        return musicRapData;
    }
    public ObservableList<Music> getFrenchMusicData() { return frenchMusicData;}
    public ObservableList<Music> getPopMusicData() { return popMusicData;}
    public ObservableList<Music> getJazzMusicData() { return jazzMusicData;}
    public ObservableList<Music> getRockMusicData() {
        return rockMusicData;
    }
    public ObservableList<Music> getFavoritesMusicData() {
        return favoritesMusicData;
    }
    public Music[] getMusics(){
        return allMusics;
    }


    public ObservableList<String> getStyle_Of_Music() {
        return style_of_music;
    }

    public void getMy_friends(String userId) {
        MusicManager mm = new MusicManager();

        try {
            ArrayList<Person> al = mm.getFriends(userId);
            for (Person person : al) {
                my_friends.add(person.getLogin());
                friends.put(person.getLogin(), person.getId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        friendList.setItems(my_friends);
    }

    public MusiqueOverviewController() { //voir initialize

    }

    @FXML
    private void initialize() { // c'est comme un constructeur

        bandRapColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameRapColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        bandFrenchColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameFrenchColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        bandPopColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        namePopColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        bandJazzColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameJazzColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        bandRockColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameRockColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());
        bandFavoriteColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        nameFavoriteColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNameProperty());

        showMusiqueDetails(null);

        musicRapTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicFrenchTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicPopTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicJazzTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicRockTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicFavoriteTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        styleChoice.setVisible(true); // Pour maitriser si connecter en tant qu'invité ou en tant que connecté

        friendList.setVisible(false);
        plugin.setVisible(false);

        musicRapTable.setItems(getRapMusicData()); // on récupère la personData de la mainApp
        musicFrenchTable.setItems(getFrenchMusicData());
        musicPopTable.setItems(getPopMusicData());
        musicJazzTable.setItems(getJazzMusicData());
        musicRockTable.setItems(getRockMusicData());
        musicFavoriteTable.setItems(getFavoritesMusicData());
        styleChoice.setItems(getStyle_Of_Music());

        styleChoice.setOnAction(event -> filterMusics(styleChoice.getValue())); // choix du genre de musique
        logout.setOnAction(event -> logout(person));

        if(MainApp.getInstance().getIsPlug()){
            plugin.setVisible(true);
            friendList.setVisible(true);
        }else {
            plugin.setVisible(false);
            friendList.setVisible(false);
        }
    }

    private void logout(Person person) {
        LoginOverviewController lOC = new LoginOverviewController();
        lOC.showLoginOverview(rLayout);
    }

    private void filterMusics(String value) {
        if(value.equals("Chanson Francaise")) {
            musicRapTable.setVisible(false);
            musicJazzTable.setVisible(false);
            musicPopTable.setVisible(false);
            musicFavoriteTable.setVisible(false);
            musicRockTable.setVisible(false);
            musicFrenchTable.setVisible(true);

            frenchLabel.setVisible(true);
            rapLabel.setVisible(false);
            rockLabel.setVisible(false);
            jazzLabel.setVisible(false);
            popLabel.setVisible(false);
            favoritesLabel.setVisible(false);
        }
        else if(value.equals("Jazz")) {
            musicRapTable.setVisible(false);
            musicFrenchTable.setVisible(false);
            musicPopTable.setVisible(false);
            musicFavoriteTable.setVisible(false);
            musicRockTable.setVisible(false);
            musicJazzTable.setVisible(true);

            frenchLabel.setVisible(false);
            rapLabel.setVisible(false);
            rockLabel.setVisible(false);
            jazzLabel.setVisible(true);
            popLabel.setVisible(false);
            favoritesLabel.setVisible(false);
        }
        else if(value.equals("Pop")) {
            musicRapTable.setVisible(false);
            musicFrenchTable.setVisible(false);
            musicPopTable.setVisible(true);
            musicFavoriteTable.setVisible(false);
            musicRockTable.setVisible(false);
            musicJazzTable.setVisible(false);

            frenchLabel.setVisible(false);
            rapLabel.setVisible(false);
            rockLabel.setVisible(false);
            jazzLabel.setVisible(false);
            popLabel.setVisible(true);
            favoritesLabel.setVisible(false);
        }
        else if(value.equals("Rap")) {
            musicRapTable.setVisible(true);
            musicFrenchTable.setVisible(false);
            musicPopTable.setVisible(false);
            musicFavoriteTable.setVisible(false);
            musicRockTable.setVisible(false);
            musicJazzTable.setVisible(false);

            frenchLabel.setVisible(false);
            rapLabel.setVisible(true);
            rockLabel.setVisible(false);
            jazzLabel.setVisible(false);
            popLabel.setVisible(false);
            favoritesLabel.setVisible(false);
        }
        else if(value.equals("Rock")) {
            musicRapTable.setVisible(false);
            musicFrenchTable.setVisible(false);
            musicPopTable.setVisible(false);
            musicFavoriteTable.setVisible(false);
            musicRockTable.setVisible(true);
            musicJazzTable.setVisible(false);

            frenchLabel.setVisible(false);
            rapLabel.setVisible(false);
            rockLabel.setVisible(true);
            jazzLabel.setVisible(false);
            popLabel.setVisible(false);
            favoritesLabel.setVisible(false);
        }
        else {
            musicRapTable.setVisible(true);
            musicFrenchTable.setVisible(true);
            musicPopTable.setVisible(true);
            musicFavoriteTable.setVisible(true);
            musicRockTable.setVisible(true);
            musicJazzTable.setVisible(true);

            frenchLabel.setVisible(true);
            rapLabel.setVisible(true);
            rockLabel.setVisible(true);
            jazzLabel.setVisible(true);
            popLabel.setVisible(true);
            favoritesLabel.setVisible(true);
        }
    }


    public void setUserConnected(Person person) {

        if(person != null)
            userConnected.setText(person.getLogin());

    }

    private void showMusiqueDetails(Music music) {
        if (music != null) {  // cette methode permet d'écrire du texte dans les label de droite a partir des donné renseigné dans personData(voir mainApp).

            bandNameLabel.setText(music.getSinger());
            styleLabel.setText(music.getSort());
            countryLabel.setText(music.getCountry());
            releaseDateLabel.setText(music.getDate());

            addfavoris.setOnAction(event -> addToFavoris(music.getId()));
            play.setOnAction(event -> playMusique(music.getUrl()));

        } else {

            bandNameLabel.setText("");
            styleLabel.setText("");
            countryLabel.setText("");
            releaseDateLabel.setText("");
        }
    }

    public void showMusics() {

        int i=0;
        try {


            MusicManager mm = new MusicManager();

            ArrayList<Music> list = mm.getAllmusics();

            for (Music music : list) {
                musicData.add(new Music(music.getName(), music.getDescription(), music.getDuration(), music.getSinger(), music.getViews(), music.getUrl(), music.getSort(), music.getCountry(), music.getDate(), music.getId()));
            }

            while (i < musicData.size()) {
                if (musicData.get(i).getSort().equals("Rap")) {
                    musicRapData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Chanson Francaise")) {
                    frenchMusicData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Pop")) {
                    popMusicData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Jazz")) {
                    jazzMusicData.add(musicData.get(i));
                }
                else if (musicData.get(i).getSort().equals("Rock")) {
                    rockMusicData.add(musicData.get(i));
                }
                i++;
            }

            ArrayList<String> sorts = mm.getAllSorts();

            for(String str : sorts) {
                style_of_music.add(str);
            }
            style_of_music.add("Aucun filtre");
        }
        catch (Exception e) {
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

    public void showMusiqueOverview(Person person,BorderPane rootlayout){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MusiqueOverview.fxml"));
            AnchorPane musicOverview = (AnchorPane) loader.load();

            rootlayout.setCenter(musicOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            MusiqueOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.showMusics();
            controller.showFavorites(person.getId());
            controller.getMy_friends(person.getId());
            this.person=person;
            controller.setUserConnected(person);
            rLayout=rootlayout;
            System.out.println(rLayout);
            System.out.println(rootlayout);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void launchPlugIn(){

        String selectedFriendLogin = friendList.getValue();

        if(selectedFriendLogin != null) {

            String selectedFriendId = friends.get(selectedFriendLogin);

            List<IModule> modules;
            modules = ModuleLoader.loadModules();
            for (IModule module : modules) {
                module.plug(person, rLayout, selectedFriendId);
            }
        }
    }

    @FXML
    public void addToFavoris(String id){
        try {
            MusicManager mm = new MusicManager();
            mm.addToFavorites(id, person.getId());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void playMusique(String URL){
        try {
            if(URL != null) {
                Stage stage = new Stage();
                WebView webview = new WebView();
                webview.getEngine().load("http://172.20.10.7:8888/Lecture.php?Nom=" + URL);
                webview.setPrefSize(400, 200);
                stage.setScene(new Scene(webview));
                stage.show();
                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    public void handle(WindowEvent we) {
                        System.out.println("Stage is closing");
                        webview.getEngine().load(null);
                    }
                });
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    }