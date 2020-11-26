package workwithfiles.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample2 {
    public static void main(String[] args) {
        Employee employee = new Employee("Maria", "It", 21, 500);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("employee.bin"))){
            objectOutputStream.writeObject(employee);
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
