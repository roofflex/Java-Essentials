package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCalculator {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("testcalc.txt"))) {
            String methodName = reader.readLine();
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());

            Calculator calculator = new Calculator();
            Class calculatorClass = calculator.getClass();
            Method method = null;

            Method[] calcMethods = calculatorClass.getDeclaredMethods();
            for(Method m : calcMethods){
                if(m.getName().equals(methodName)){
                    method = m;
                }
            }

            method.invoke(calculator, a, b);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
