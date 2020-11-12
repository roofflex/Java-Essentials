package stream;

import java.util.ArrayList;
import java.util.List;

public class MinMaxMethods {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22,4, 7.8);
        Student st2 = new Student("Masha", 'f', 23,5, 5.8);
        Student st3 = new Student("Katya", 'f', 19,1, 9.1);
        Student st4 = new Student("Zhenya", 'm', 20,3, 6.2);
        Student st5 = new Student("Max", 'm', 22,3, 8.4);
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);


        Student minStudent = students.stream().min((student1, student2) -> student1.getAge()-student2.getAge()).get();

        Student maxStudent = students.stream().max((student1, student2) -> student1.getAge()-student2.getAge()).get();

        System.out.println(minStudent);

        System.out.println(maxStudent);
    }
}
