package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FlatMapMethod {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22,4, 7.8);
        Student st2 = new Student("Masha", 'f', 23,5, 5.8);
        Student st3 = new Student("Katya", 'f', 19,1, 9.1);
        Student st4 = new Student("Zhenya", 'm', 20,3, 6.2);
        Student st5 = new Student("Max", 'm', 22,3, 8.4);

        Faculty f1 = new Faculty("Economics");

        Faculty f2 = new Faculty("Applied Mathematics");

        f1.addStudent(st1);
        f1.addStudent(st2);
        f1.addStudent(st3);

        f2.addStudent(st4);
        f2.addStudent(st5);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(f1);
        faculties.add(f2);

        // flatMap allows us to access elements in collection, that is stored in one more collection
        // here it is like that: first we have faculties in stream, flatMap gets list of students(from faculty)
        // and creates stream from them
        faculties.stream().flatMap(faculty -> faculty.getStudents().stream()).forEach(e -> System.out.println(e.getName()));

    }
}

class Faculty{
    String name;
    List<Student> students;

    public Faculty(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student s){
        students.add(s);
    }
}
