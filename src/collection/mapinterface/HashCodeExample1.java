package collection.mapinterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeExample1 {
    public static void main(String[] args) {
        Map<Student, Double> hashMap = new HashMap<>();
        Student st1 = new Student("Petr", "Smelov", "C#");
        Student st2 = new Student("Max", "Dobriy", "C++");
        Student st3 = new Student("John", "Avans", "Ruby");

        hashMap.put(st1, 7.8);
        hashMap.put(st2, 6.7);
        hashMap.put(st3, 9.1);

        System.out.println(hashMap);

        Student st4 = new Student("Petr", "Smelov", "C#");

        boolean result = hashMap.containsKey(st4);
        System.out.println("result = " + result);
    }
}
class Student implements Comparable<Student>{

    private String firstName;
    private String lastName;
    private String course;

    public Student(String firstName, String lastName, String course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", course='" + course + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) &&
            Objects.equals(lastName, student.lastName) &&
            Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, course);
    }

    @Override
    public int compareTo(Student o) {
        return this.lastName.compareTo(o.lastName);
    }
}
