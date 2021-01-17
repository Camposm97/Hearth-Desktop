package util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Purpose of this class is that it will prompt the user if they want the program to
 * scan their files and have the program search for media files that the program supports.
 * Looks for files that have the following extensions:
 * m4a, m4v, mp4, mp3, wav, mpeg4, jpg, jpeg, png, bmp, gif
 */
public class MediaImporter {
    /*
     * Purpose of this main method is to test methods in MediaImporter
     * I will probably make a tests later on,
     *
     * @param args
     */
    public static void main(String[] args) {
//        autoImportMedia();
    }

    /**
     * Starts scanning for media files from a given source
     *
     * @param src
     */
    public static void importMedia(String src) {
        File file = new File(src);
        if (file.exists()) {
            if (file.isDirectory()) {
                // scan for files and directories
            } else if (file.isFile()) {
                // check if is a supported file
            }
        }
    }

    /**
     * Starts scanning for media files from the user's root directory.
     */
    public static void autoImportMedia() {
        final String HOME = "user.home";
        String path = System.getProperty(HOME);
        File fileHome = new File(path);
        System.out.println("HOME -> " + fileHome);
        System.out.println();
        try {
            List<File> fileList = Arrays.asList(Objects.requireNonNull(fileHome.listFiles((file, name) -> !name.startsWith("."))));
            fileList.forEach(file -> {
                if (file.isDirectory()) {
                    // scan this directory for files and more directories for media files.
                }
                if (file.isFile()) {

                }
                System.out.println(file);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scanFiles() {

    }

    public static boolean isSupportedFormat(String path) {
        return path.endsWith(".m4a") || path.endsWith(".m4v") || path.endsWith(".mp4") || path.endsWith(".mp3") || path.endsWith(".wav") || path.endsWith(".mpeg4") || path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png") || path.endsWith(".bmp") || path.endsWith(".gif");
    }
}
