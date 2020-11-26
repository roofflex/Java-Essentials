package workwithfiles.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        // second param in RandomAccessFile constructor is mode, defines how we work with file
        // for example, "rw" is "read & write" "r" is read only
        try(RandomAccessFile file = new RandomAccessFile("test10.txt", "rw")) {
            // .read() reads one byte from the place of pointer (and moves pointer)
            // .read() returns int, so we have to do a casting
//            int a = file.read();
//            System.out.println((char) a);
            String s1 = file.readLine();
            System.out.println(s1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
