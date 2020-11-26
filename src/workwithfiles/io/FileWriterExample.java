package workwithfiles.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        String helloworld = "Hello, we are" + " now learning to" + " use filewriter";
        FileWriter fileWriter = null;
        try {
            // second param "true" tells filewriter to add new info in the end of file, and not overwrite existing info
             fileWriter = new FileWriter("/Users/roofflex/Programming/Java Essentials/src/workwithfiles/text1.txt", true);
//            for(int i = 0; i < helloworld.length(); i++){
//                fileWriter.write(helloworld.charAt(i)) ;
//            }
            fileWriter.write(helloworld);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Don't forget to close the writer in finally block!
        finally {
            fileWriter.close();
        }

    }
}
