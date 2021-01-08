package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.File;
import java.io.IOException;

public class FXUtil {
    /**
     * Loads an FXML file and returns it as a Parent type.  If the file is not found, then it returns null;
     * @param src
     * @return Parent
     */
    public static Parent loadFXML(String src) {
        try {
            File file = new File(src);
            return FXMLLoader.load(file.toURI().toURL());
        } catch (IOException e) {
            return null;
        }
    }
}
