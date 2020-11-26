package workwithfiles.io;

import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) throws IOException {
        File file = new File("test10.txt");
        File file2 = new File("test11.txt");

        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("file2.exists() " + file2.exists());
        System.out.println(file2.createNewFile());
        System.out.println("file2.exists() " + file2.exists());
        // if File object represents not existing directory, to create it we use .mkdir()

        // other methods : .isHidden(), .canWrite(), .canRead(), .canExecute()




    }
}
