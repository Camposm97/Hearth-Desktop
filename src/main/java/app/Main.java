package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.FXUtil;

/**
 * TODO: Import Media Files
 * When the user starts the program for the first time.  The program will prompt the user to scan all the files in their account (home)
 * for media files (javafx supports specific versions of media.  See Media class) or the user can manually choose what folders to search
 * for media.  If possible, the program can scan all the hard drives available on the computer.  I know that I would store all my code
 * in the root folder of a drive.  The user can also have the option of skipping this part and do it another time.
 *
 * It's important to keep in mind that JavaFX supports a limited number of file formats.  I think when the program tries to scan, it will
 * only scan for these supported file formats.  The program should also display a message saying something like:
 *
 * "Unfortunately due to JavaFX limitations, this program can only support these types of files: mp3, mp4, etc."
 *
 * TODO: Design GUI & Algorithm
 * There will be no menu bar.
 * I'm thinking of having the program to open at a "home page" where the user can choose to play music of play movies/videos.
 * The problem is when the user wants to view movies only, how can I differentiate music files from video files because
 * the video files will most likely be in mp4 format, but so can music files.
 * If I can resolve this issue then I can have buttons for displaying only videos or music (search online).
 *
 */
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
