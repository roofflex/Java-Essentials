package collection.listinterface;

import java.util.LinkedList;

public class LinkedListMethods1 {

    public static void main(String[] args) {
        Student student1 = new Student("Vlad", 1);
        Student student2 = new Student("Max", 4);
        Student student3 = new Student("Petr", 2);
        Student student4 = new Student("Sasha", 7);
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(student1);
        studentLinkedList.add(student2);
        studentLinkedList.add(student3);
        studentLinkedList.add(student4);
        System.out.println("students list=" + studentLinkedList);
        System.out.println(studentLinkedList.get(2));
    }
}

class Student{

    private String name;
    private int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
            "name='" + name + '\'' +
            ", course=" + course +
            '}';
    }
}