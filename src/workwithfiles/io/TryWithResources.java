package workwithfiles.io;

import java.io.FileWriter;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        String helloworld = "Hello, we are" + " now learning to" + " use filewriter";
        // that is try with resources
        // it AUTOMATICALLY closes the resource(filewriter)
        // resource should implement AutoCloseable
        try(FileWriter fileWriter = new FileWriter("text2.txt", true);){
//            for(int i = 0; i < helloworld.length(); i++){
//                fileWriter.write(helloworld.charAt(i)) ;
//            }
            fileWriter.write(helloworld);
            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
