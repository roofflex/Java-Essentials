package collection.setinterface;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample1 {

    public static void main(String[] args) {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Misha", 2));
        students.add(new Student("Petya", 1));
        students.add(new Student("Ivan", 4));

        System.out.println(students);

        System.out.println(students.last());

        System.out.println(students.headSet(new Student("Ivan", 4)));

        System.out.println(students.subSet(new Student("Ivan", 4), new Student("Petya", 1)));

    }
}

class Student implements Comparable<Student>{
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", course=" + course +
            '}';
    }
}
