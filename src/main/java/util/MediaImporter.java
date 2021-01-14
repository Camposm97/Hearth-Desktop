package util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
        System.out.println("HOME -> " + fileHome);
        System.out.println();
        try {
            List<File> fileList = Arrays.asList(Objects.requireNonNull(fileHome.listFiles((file, name) -> !name.startsWith("."))));

            fileList.forEach(file -> {
                System.out.println(file);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
