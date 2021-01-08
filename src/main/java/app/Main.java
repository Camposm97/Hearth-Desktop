package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.FXUtil;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXUtil.loadFXML("ui/Main.fxml");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
