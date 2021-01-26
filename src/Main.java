import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/contenedor-principal.fxml"));
        primaryStage.setTitle("Venado's Boutique");
        primaryStage.setScene(new Scene(root, 620, 400));
        primaryStage.show();
        Image ico = new Image("resources/37901.jpg");
        primaryStage.getIcons().add(ico);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
