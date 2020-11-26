package workwithfiles.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src/workwithfiles/text1.txt");
            int character;
            // fileReader reads file by ints, that way it knows when to stop,
            // because -1 indicates THE END of file
            while((character = fileReader.read()) != -1){
                System.out.println((char) character);
            }
            System.out.println("Done! ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
        }

    }
}
