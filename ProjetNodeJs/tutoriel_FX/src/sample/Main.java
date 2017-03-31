package sample;

import com.sun.javafx.fxml.builder.JavaFXImageBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sun.awt.image.URLImageSource;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
        public void start(Stage fenetre) throws Exception {

        //definition des dimensions de la fenetre
        int largeurDeLaFenetre=800;
        int hauteurDeLaFenetre=600;
        fenetre.setWidth(largeurDeLaFenetre);
        fenetre.setHeight(hauteurDeLaFenetre);

        //Titre
        fenetre.setTitle("Mumusique!");

            // la racine du sceneGraph est le root
            Group root = new Group();
            Scene mon_Fond = new Scene(root);
            mon_Fond.setFill(Color.DARKBLUE);


            Circle rond = new Circle(10, Color.web("red", 0.8));
            rond.setCenterX(largeurDeLaFenetre/2);
            rond.setCenterY(hauteurDeLaFenetre/2);

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(new Double[]{
                200.0, 220.0,
                250.0, 170.0,
                200.0, 120.0 });
        triangle.setFill(Color.BLACK);

            Rectangle enHaut = new Rectangle(0,0,largeurDeLaFenetre,hauteurDeLaFenetre/6);
        enHaut.setFill(Color.GREEN);

         String imageURI = new File("file:image.png").toURI().toString();
         Image image = new Image("file:image.png");

        ImageView imageView = new ImageView(image);


        Rectangle enBas = new Rectangle(0,hauteurDeLaFenetre-(2*hauteurDeLaFenetre/6),largeurDeLaFenetre,(2*hauteurDeLaFenetre/6));
        enBas.setFill(Color.GRAY);

            // Attention les coordonnées sont celles du panneau, pas de la scène
            Text text = new Text(10, 30, "Mumusique");
            text.setFont(new Font(20));
            text.setFill(Color.WHITE);
        text.setTranslateX(50);
        text.setTranslateY((hauteurDeLaFenetre/6)/3);


            // ajout de tous les éléments de la scène
            root.getChildren().add(rond);
            root.getChildren().add(enHaut);
            root.getChildren().add(text);
            root.getChildren().add(enBas);
            root.getChildren().add(triangle);
            root.getChildren().setAll(imageView);

        GridPane grid = new GridPane();
        grid.add(imageView, 0, 0);
        root.getChildren().add(grid);

            // ajout de la scène sur l'estrade
        fenetre.setScene(mon_Fond);
            // ouvrir le rideau
        fenetre.show();
        }

    public static void main(String[] args) {
        launch(args);
    }
}
