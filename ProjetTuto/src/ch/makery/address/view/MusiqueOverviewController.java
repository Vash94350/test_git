package ch.makery.address.view;

import ch.makery.address.model.Music;
import ch.makery.address.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;

public class MusiqueOverviewController {
    @FXML
    private TableView<Music> musiqueRecenteTable;
    @FXML
    private TableColumn<Music, String> groupeRecentColumn;
    @FXML
    private TableColumn<Music, String> styleRecentColumn;

    @FXML
    private TableView<Music> musiquePopulaireTable;
    @FXML
    private TableColumn<Music, String> groupePopulaireColumn;
    @FXML
    private TableColumn<Music, String> stylePopulaireColumn;

    @FXML
    private TableView<Music> musiqueAnnee80Table;
    @FXML
    private TableColumn<Music, String> groupeAnnee80Column;
    @FXML
    private TableColumn<Music, String> styleAnnee80Column;

    @FXML
    private TableView<Music> musiqueInstrumentalTable;
    @FXML
    private TableColumn<Music, String> groupeInstrumentalColumn;
    @FXML
    private TableColumn<Music, String> styleInstrumentalColumn;

    @FXML
    private Label nomDuGroupeLabel;
    @FXML
    private Label styleLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label sortieLabel;
    @FXML
    private ChoiceBox<String> choix;

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
        groupeRecentColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        styleRecentColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTypeProperty());
        groupePopulaireColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        stylePopulaireColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTypeProperty());
        groupeInstrumentalColumn.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        styleInstrumentalColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTypeProperty());
        groupeAnnee80Column.setCellValueFactory(
                cellData -> cellData.getValue().getSingerProperty());
        styleAnnee80Column.setCellValueFactory(
                cellData -> cellData.getValue().getTypeProperty());

        // Clear person details.
        showMusiqueDetails(null);

        // Listen for selection changes and show the person details when changed.
        musiqueRecenteTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musiquePopulaireTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musiqueAnnee80Table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        musiqueInstrumentalTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMusiqueDetails(newValue));
        choix.setVisible(true); // Pour maitriser si connecter en tant qu'invité ou en tant que connecté
        //choix.getValue(); Pour recupere le string dans choix.
        choix.setValue("Ma page");
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
        musiqueRecenteTable.setItems(mainApp.getmusiqueRecentData()); // on récupère la personData de la mainApp
        musiquePopulaireTable.setItems(mainApp.getmusiquePopulaireData());
        musiqueInstrumentalTable.setItems(mainApp.getMusiqueInstrumentalData());
        musiqueAnnee80Table.setItems(mainApp.getmusiqueAnnee80Data());

        userConnected.setText(person.getLogin());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param musique the person or null
     */
    private void showMusiqueDetails(Music musique) {
        if (musique != null) {  // cette methode permet d'écrire du texte dans les label de droite a partir des donné renseigné dans personData(voir mainApp).
            // Fill the labels with info from the person object.
            nomDuGroupeLabel.setText(musique.getSinger());
            styleLabel.setText(musique.getSort());
            countryLabel.setText(musique.getCountry());
            //sortieLabel.setText(DateUtil.format(musique.getSortie()));
        } else {
            // Person is null, remove all the text.
            nomDuGroupeLabel.setText("");
            styleLabel.setText("");
            countryLabel.setText("");
            sortieLabel.setText("");
        }
    }
}