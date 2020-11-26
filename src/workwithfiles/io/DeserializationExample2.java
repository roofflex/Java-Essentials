package workwithfiles.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample2 {
    public static void main(String[] args) {
        Employee employee;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("employee.bin"))){
            employee = (Employee) objectInputStream.readObject();
            System.out.println(employee);
            System.out.println("Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
