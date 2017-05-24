package ch.makery.address.view;

import ch.makery.address.model.Musique;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.util.DateUtil;

import java.time.LocalDate;

public class MusiqueOverviewController {
    @FXML
    private TableView<Musique> musiqueRecenteTable;
    @FXML
    private TableColumn<Musique, String> groupeRecentColumn;
    @FXML
    private TableColumn<Musique, String> styleRecentColumn;

    @FXML
    private TableView<Musique> musiquePopulaireTable;
    @FXML
    private TableColumn<Musique, String> groupePopulaireColumn;
    @FXML
    private TableColumn<Musique, String> stylePopulaireColumn;

    @FXML
    private TableView<Musique> musiqueAnnee80Table;
    @FXML
    private TableColumn<Musique, String> groupeAnnee80Column;
    @FXML
    private TableColumn<Musique, String> styleAnnee80Column;

    @FXML
    private TableView<Musique> musiqueInstrumentalTable;
    @FXML
    private TableColumn<Musique, String> groupeInstrumentalColumn;
    @FXML
    private TableColumn<Musique, String> styleInstrumentalColumn;

    @FXML
    private Label nomDuGroupeLabel;
    @FXML
    private Label styleLabel;
    @FXML
    private Label countryLabel;
    @FXML
    private Label sortieLabel;

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
                cellData -> cellData.getValue().nomDeGroupeProperty());
        styleRecentColumn.setCellValueFactory(
                cellData -> cellData.getValue().styleProperty());
        groupePopulaireColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomDeGroupeProperty());
        stylePopulaireColumn.setCellValueFactory(
                cellData -> cellData.getValue().styleProperty());
        groupeInstrumentalColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomDeGroupeProperty());
        styleInstrumentalColumn.setCellValueFactory(
                cellData -> cellData.getValue().styleProperty());
        groupeAnnee80Column.setCellValueFactory(
                cellData -> cellData.getValue().nomDeGroupeProperty());
        styleAnnee80Column.setCellValueFactory(
                cellData -> cellData.getValue().styleProperty());

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
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        musiqueRecenteTable.setItems(mainApp.getmusiqueRecentData()); // on récupère la personData de la mainApp
        musiquePopulaireTable.setItems(mainApp.getmusiquePopulaireData());
        musiqueInstrumentalTable.setItems(mainApp.getMusiqueInstrumentalData());
        musiqueAnnee80Table.setItems(mainApp.getmusiqueAnnee80Data());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param musique the person or null
     */
    private void showMusiqueDetails(Musique musique) {
        if (musique != null) {  // cette methode permet d'écrire du texte dans les label de droite a partir des donné renseigné dans personData(voir mainApp).
            // Fill the labels with info from the person object.
            nomDuGroupeLabel.setText(musique.getNomDeGroupe());
            styleLabel.setText(musique.getStryle());
            countryLabel.setText(musique.getCountry());
            sortieLabel.setText(DateUtil.format(musique.getSortie()));
        } else {
            // Person is null, remove all the text.
            nomDuGroupeLabel.setText("");
            styleLabel.setText("");
            countryLabel.setText("");
            sortieLabel.setText("");
        }
    }
}