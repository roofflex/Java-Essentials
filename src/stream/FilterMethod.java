package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterMethod {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22,4, 7.8);
        Student st2 = new Student("Masha", 'f', 23,5, 5.8);
        Student st3 = new Student("Katya", 'f', 19,1, 9.1);
        Student st4 = new Student("Zhenya", 'm', 20,3, 6.2);
        Student st5 = new Student("Max", 'm', 22,3, 8.4);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        System.out.println(students);

        List<Student> filteredStudents = students.stream().filter(student -> student.getAge() > 20 && student.getCourse() < 5).collect(Collectors.toList());


        System.out.println(filteredStudents);

        Stream<Student> studentStream = Stream.of(st1, st2, st3, st4, st5);
    }
}

class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public int getCourse() {
        return course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", sex=" + sex +
            ", age=" + age +
            ", course=" + course +
            ", avgGrade=" + avgGrade +
            '}';
    }
}