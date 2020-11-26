package workwithfiles.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesExample2 {
    public static void main(String[] args) throws IOException {
        Path filepath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("/Users/roofflex/Programming");


        // .copy() copies single file or a folder, but NOT including the files in that folder
        Files.copy(filepath, directoryPath.resolve(filepath), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Done!");

        Files.move(filepath, directoryPath.resolve("test15.txt"));

        // Files doesn't have a rename method, but
        // we can rename files by invoking .move() with changing filename in target
        // Here we rename test10.txt to quote.txt
        Path test10 = Paths.get("test10.txt");
        Files.move(test10, test10.toAbsolutePath().getParent().resolve("quote.txt"));

        Files.delete(Paths.get("test5.txt"));
    }
}
