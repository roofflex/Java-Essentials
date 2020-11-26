package regex;

public class PrintfFormatExample {

    static void printEmployeeInfo(Employee employee){
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n", employee.id, employee.firstName, employee.lastName, employee.salary*(1 + employee.bonusPercent));
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee(1, "Misha", "Smirnov", 5000, 0.23);
        Employee employee2 = new Employee(23, "Maria", "Yablokova", 710, 0.08);
        Employee employee3 = new Employee(76, "Zarina", "Abdulaeva", 300, 0.35);

        printEmployeeInfo(employee1);
        printEmployeeInfo(employee2);
        printEmployeeInfo(employee3);
    }
}

class Employee{
    int id;
    String firstName;
    String lastName;
    int salary;
    double bonusPercent;

    public Employee(int id, String firstName, String lastName, int salary, double bonusPercent) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.bonusPercent = bonusPercent;
    }
}