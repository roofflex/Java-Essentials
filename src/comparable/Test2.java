package comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(10, "Ivan", "Ovchinnikov", 36000));
        employeeList.add(new Employee(23, "Alexei", "Ivanov", 27000));
        employeeList.add(new Employee(17, "Zaur", "Mehanov", 32000));

        System.out.println("Before sorting:");
        System.out.println(employeeList + "\n");
        Collections.sort(employeeList);  // sorting using Comparable interface, sort by id
        System.out.println("After sorting by id:");
        System.out.println(employeeList + "\n");
        Collections.sort(employeeList, new EmployeeSalaryComparator()); // sorting using Comparator, sort by salary
        System.out.println("After sorting by salary:");
        System.out.println(employeeList);

    }
}


class Employee implements Comparable<Employee> {
    int id;
    String firstName;
    String lastName;
    int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", salary=" + salary +
            '}';
    }

    @Override
    public int compareTo(Employee comparedEmployee) {
        if (this.id == comparedEmployee.id) {
            return 0;
        } else if (this.id < comparedEmployee.id) {
            return -1;
        } else {
            return 1;
        }

        // for Integers, there is a simpler way
        // return this.id-comparedEmployee.id

        // or, if we declare id as Integer, we can use
        // return this.id.compareTo(comparedEmployee.id)
    }
}

class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.salary - o2.salary;
    }
}