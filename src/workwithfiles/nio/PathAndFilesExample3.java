package workwithfiles.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathAndFilesExample3 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test10.txt");

//        Files.createFile(filePath);

        String conversation = "-Hi\n-Hi!\n-How are you?\n-Great, thanks. And you?";

//        Files.write(filePath, conversation.getBytes());

        List<String> lines = Files.readAllLines(filePath);
        for(String line : lines){
            System.out.println(line);
        }

    }
}
