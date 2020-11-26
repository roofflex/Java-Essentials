package reflection;

import java.lang.reflect.Field;

public class ReflectionExample3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10, "Max", "IT");
        Class employeeClass = employee.getClass();

        // have to use .getDeclaredField so we can reach the private field
        Field field = employeeClass.getDeclaredField("salary");
        // string below grants access to private field
        field.setAccessible(true);
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee, 780.35);
        System.out.println(employee);
    }
}
