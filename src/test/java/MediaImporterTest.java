import org.junit.Test;
import util.MediaImporter;

import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

public class MediaImporterTest {
    @Test
    public void testImportMedia() {
        TreeSet<String> treeSet = MediaImporter.autoImportMedia();
        treeSet.forEach(s -> {
            System.out.println(s);
        });
        System.out.println("Done");
//        String home = System.getProperty("user.home");
//        try {
//            Path path = Paths.get(home);
//            System.out.println(path);
//
//            Files.walk(Paths.get(home)).filter(Files::isRegularFile).forEach(System.out::println);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testIsSupportedFormat() {
        String path1 = "Hello.m4a";
        String path2 = "Hello.m4v";
        String path3 = "Hello.mp4";
        String path4 = "Hello.mp3";
        String path5 = "Hello.wav";
        String path6 = "Hello.mpeg4";
        String path7 = "Hello.jpg";
        String path8 = "Hello.jpeg";
        String path9 = "Hello.png";
        String path10 = "Hello.bmp";
        String path11 = "Hello.gif";
        List<String> list = List.of(path1, path2, path3, path4, path5, path6, path7, path8, path9, path10, path11);
        for (String s : list) {
            boolean flag = MediaImporter.isSupportedFormat(s);
            assertTrue(flag);
        }
    }
}
