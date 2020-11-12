package workwithfiles;

import java.io.*;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("text2.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("copiedtext.txt"))){
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
