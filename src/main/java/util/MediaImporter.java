package util;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Purpose of this class is that it will prompt the user if they want the program to
 * scan their files and have the program search for media files that the program supports.
 */
public class MediaImporter {
    /**
     * Purpose of this main method is to test methods in MediaImporter
     * I will probably make a tests later on,
     *
     * @param args
     */
    public static void main(String[] args) {
        importMedia();
    }

    public static void importMedia() {
        final String HOME = "user.home";
        String path = System.getProperty(HOME);
        File fileHome = new File(path);
        System.out.println(fileHome);
        List<File> fileList = Arrays.asList(fileHome.listFiles((file, name) -> {
            return !name.startsWith(".");
        }));

        fileList.forEach(file -> {
            System.out.println(file);
        });
    }
}
