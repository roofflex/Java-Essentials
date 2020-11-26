package workwithfiles.nio;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAndFilesExample1 {
    public static void main(String[] args) throws IOException {
        Path filepath = Paths.get("test15.txt");
        Path directoryPath = Paths.get("/Users/roofflex/Programming");

        System.out.println("filepath.getFileName() " + filepath.getFileName());
        System.out.println("directoryPath.getFileName() "  + directoryPath.getFileName());

        System.out.println("---------------------\n");

        System.out.println("filepath.getParent() " + filepath.getParent());
        System.out.println("directoryPath.getParent() "  + directoryPath.getParent());

        System.out.println("---------------------\n");

        System.out.println("filepath.isAbsolute() " + filepath.isAbsolute());



        System.out.println("---------------------\n");

        System.out.println("filepath.toAbsolutePath() " + filepath.toAbsolutePath());




        System.out.println("---------------------\n");

        // .resolve() unites paths
        System.out.println("directoryPath.resolve(filepath) " + directoryPath.resolve(filepath));





        System.out.println("---------------------\n");


        if(!Files.exists(filepath)){
            Files.createFile(filepath);
        }




        System.out.println("---------------------\n");

        System.out.println("Files.isReadable(filepath) " + Files.isReadable(filepath));
        System.out.println("Files.isWriteable(filepath) " + Files.isWritable(filepath));
        System.out.println("Files.isExecutable(filepath) " + Files.isExecutable(filepath));


        System.out.println("---------------------\n");

        System.out.println("Files.size(filepath) " + Files.size(filepath));

        System.out.println("---------------------\n");

        System.out.println("Files.getAttribute(filepath, \"creationTime\") " + Files.getAttribute(filepath, "creationTime"));


        System.out.println("---------------------\n");




        System.out.println("---------------------\n");


    }
}
