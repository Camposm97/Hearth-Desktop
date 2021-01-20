package util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Purpose of this class is that it will prompt the user if they want the program to
 * scan their files and have the program search for media files that the program supports.
 * Looks for files that have the following extensions:
 * m4a, m4v, mp4, mp3, wav, mpeg4, jpg, jpeg, png, bmp, gif
 */
public class MediaImporter {
    /**
     * Starts scanning for media files from a given source
     *
     * @param fileSrc
     */
    public static TreeSet<String> importMedia(File fileSrc) {
        TreeSet<String> treeSet = new TreeSet<>();
        if (fileSrc.exists()) {
            if (fileSrc.isDirectory()) {
                File[] files = fileSrc.listFiles((f, name) -> !name.startsWith("."));
                if (files != null) {
                    Arrays.stream(files).forEach(f -> {
                        treeSet.addAll(importMedia(f));
                    });
                }
            } else if (fileSrc.isFile()) {
                if (isSupportedFormat(fileSrc.getPath())) {
                    treeSet.add(fileSrc.getPath());
                }
            }
        }
        return treeSet;
    }

    /**
     * Starts scanning for media files from the user's root directory.
     */
    public static TreeSet<String> autoImportMedia() {
        final String HOME = "user.home";
        String path = System.getProperty(HOME);
        File fileHome = new File(path);
        TreeSet<String> treeSet = new TreeSet<>();
        System.out.println("HOME -> " + fileHome);
        System.out.println();
        try {
            List<File> fileList = Arrays.asList(Objects.requireNonNull(fileHome.listFiles((f, name) -> !name.startsWith("."))));
            fileList.forEach(file -> {
                if (file.isDirectory() && !file.getPath().contains("AppData")) {
                    // scan this directory for files and more directories for media files.
                    treeSet.addAll(importMedia(file));
                } else if (file.isFile()) {
                    if (isSupportedFormat(file.getPath())) {
                        treeSet.add(file.getPath());
                    }
                }
                System.out.println(file);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        return treeSet;
    }

    public static boolean isSupportedFormat(String path) {
        path = path.toLowerCase();
        return path.endsWith(".m4a") || path.endsWith(".m4v") || path.endsWith(".mp4") || path.endsWith(".mp3") || path.endsWith(".wav") || path.endsWith(".mpeg4") || path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png") || path.endsWith(".bmp") || path.endsWith(".gif");
    }
}
