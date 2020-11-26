package workwithfiles.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPhotoExample {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("Stalinka.jpg");
            FileOutputStream outputStream = new FileOutputStream("CopiedPhoto.jpg")) {
            int i;
            while((i = inputStream.read()) != -1){
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }{

        }
    }
}
