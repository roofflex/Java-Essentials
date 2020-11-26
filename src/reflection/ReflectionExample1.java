package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // most used case of creating a Class object
        Class employeeClass = Class.forName("reflection.Employee");

        // option 2
//        Class employeeClass2 = Employee.class;

        // option 3
//        Employee employee = new Employee();
//        Class employeeClass3 = employee.getClass();

        Field idField = employeeClass.getField("id");
        System.out.println("Field type - " + idField.getType());
        System.out.println("\n----------------------\n");

        // this code will NOT show private fields
        Field[] fields = employeeClass.getFields();
        for(Field f : fields){
            System.out.println("Field name - " + f.getName() + ", type - " + f.getType());
        }

        System.out.println("\n----------------------\n");

        // this code WILL show all fields of a class, even private
        Field[] allFields = employeeClass.getDeclaredFields();
        for(Field f : allFields){
            System.out.println("Field name - " + f.getName() + ", type - " + f.getType());
        }

        System.out.println("\n----------------------\n");

        Method incSalMethod = employeeClass.getMethod("setSalary", double.class);
        System.out.println("return type - " + incSalMethod.getReturnType());
        System.out.println("param types - " + Arrays.toString(incSalMethod.getParameterTypes()));

        System.out.println("\n----------------------\n");

        Method[] methods = employeeClass.getMethods();
        for(Method m : methods){
            System.out.println("Method name - " + m.getName() + ", return type - " + m.getReturnType() +
                ", param types - " + Arrays.toString(m.getParameterTypes()));
        }

        // .getMethods returns all the methods, except private: declared, overloaded, methods from the superclass(such as .wait() & .notify())
        // .getDeclared returns all Declared in the class methods

        System.out.println("\n----------------------\n");



        System.out.println("\n----------------------\n");



        System.out.println("\n----------------------\n");
    }
}
