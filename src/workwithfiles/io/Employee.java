package workwithfiles.io;

import java.io.Serializable;

// In order to serialize object, to put it into binary file, class has to implement Serializable
// Serializable is just a marker-interface, it has no methods
public class Employee implements Serializable {
    // serialVersionUID is used so that if we modify the class and serialize it
    // and someone with its previous version fails to deserialize it,
    // we explicitly tell them "wrong serialVersionUID" (you use the old version, can not deserialize)
    static final long serialVersionUID = 1;
    String name;
    String department;
    int age;
    // transient - временный
    // transient keyword is used when the data is confidential and should NOT be written in binary files
    // transient prevents this field from being written in binary file
    transient double salary;

    public Employee(String name, String department, int age, double salary) {
        this.name = name;
        this.department = department;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", department='" + department + '\'' +
            ", age=" + age +
            ", salary=" + salary +
            '}';
    }
}
