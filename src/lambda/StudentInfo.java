package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentInfo {
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

        StudentInfo studentInfo = new StudentInfo();

        // lambdas are useful in sorting, defining Comparator

        Collections.sort(students, (s1, s2) -> s1.name.compareTo(s2.name));
        System.out.println(students);


        // filtrating with lambda
        studentInfo.testStudents(students, (Student s) -> {return s.age<20;});

        studentInfo.testStudents(students, p -> p.age > 20 && p.avgGrade < 8);

        Predicate<Student> p1 = student -> student.sex == 'f';
        Predicate<Student> p2 = student -> student.avgGrade > 7.5;

        // we can unite predicates with .and() / .or()

        studentInfo.testStudents(students, p1.and(p2));
        System.out.println("---------------");
        System.out.println("Average age: " + calculateAverage(students, student -> Double.valueOf(student.age)));

    }

    public static double calculateAverage(List<Student> list, Function<Student, Double> function){
        double result = 0;
        for(Student s : list){
            result += function.apply(s);
        }
        result /= list.size();
        return result;
    }









    // methods below were used in learning lambda, now not useful

    void testStudents(ArrayList<Student> arrayList, Predicate<Student> predicate){
        for(Student s : arrayList){
            if(predicate.test(s)){
                System.out.println(s);
            }
        }
    }
    void printStudentsOverGrade(ArrayList<Student> arrayList, double grade){
        for(Student s : arrayList){
           if (s.avgGrade > grade){
               System.out.println(s);
           }
        }
    }

    void printStudentsUnderAge(ArrayList<Student> arrayList, int age){
        for(Student s : arrayList){
            if (s.age < age){
                System.out.println(s);
            }
        }
    }

    void printStudentsMixCondition(ArrayList<Student> arrayList, char sex, int age, double grade){
        for(Student s : arrayList){
            if (s.sex == sex && s.age >= age && s.avgGrade > grade){
                System.out.println(s);
            }
        }
    }
}

interface StudentChecks{
    boolean check(Student s);
}

class CheckOverGrade implements StudentChecks{
    @Override
    public boolean check(Student s) {
        return s.avgGrade>8;
    }
}
