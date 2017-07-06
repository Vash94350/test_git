package ch.makery.address.view;

import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MusiqueOverviewController {
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
    private Label userConnected;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MusiqueOverviewController() { //voir initialize
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() { // c'est comme un constructeur
        // Initialize the person table with the two columns.
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

        // Clear person details.
        showMusiqueDetails(null);

        // Listen for selection changes and show the person details when changed.
        musicRapTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicFrenchTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicPopTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musicJazzTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        styleChoice.setVisible(true); // Pour maitriser si connecter en tant qu'invité ou en tant que connecté
        //choix.getValue(); Pour recupere le string dans choix.
        styleChoice.setValue("Ma page");
       // choix.setItems();// mettre une observable list comme ppour les musique
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp, Person person) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        musicRapTable.setItems(mainApp.getRapMusicData()); // on récupère la personData de la mainApp
        musicFrenchTable.setItems(mainApp.getFrenchMusicData());
        musicPopTable.setItems(mainApp.getPopMusicData());
        musicJazzTable.setItems(mainApp.getJazzMusicData());

        if(person != null)
            userConnected.setText(person.getLogin());

        styleChoice.setItems(mainApp.getStyle_Of_Music());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param music the person or null
     */
    private void showMusiqueDetails(Music music) {
        if (music != null) {  // cette methode permet d'écrire du texte dans les label de droite a partir des donné renseigné dans personData(voir mainApp).
            // Fill the labels with info from the person object.
            bandNameLabel.setText(music.getSinger());
            styleLabel.setText(music.getSort());
            countryLabel.setText(music.getCountry());
            releaseDateLabel.setText(music.getDate());
        } else {
            // Person is null, remove all the text.
            bandNameLabel.setText("");
            styleLabel.setText("");
            countryLabel.setText("");
            releaseDateLabel.setText("");
        }
    }

    public void showMusicOverview(Person person, BorderPane rootLayout) {
        try {
            // Load musique overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/MusiqueOverview.fxml"));
            AnchorPane musiqueOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(musiqueOverview); // on met au centre de notre borderpane, qui n'est autre que RootLayout, notre PersonOverview

            // Give the controller access to the main app.
            MusiqueOverviewController controller = loader.getController(); // pour controler ce qui se passe dans la page PersonOverview on associe le fichier controller associé
            controller.setMainApp(mainApp, person); // drole d'histoire

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}