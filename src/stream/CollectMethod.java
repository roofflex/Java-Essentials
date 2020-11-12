package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectMethod {
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


        // grouping by course

        Map<Integer, List<Student>> courseStudents = students.stream().map(student -> {student.setName(student.getName().toUpperCase()); return student;})
            .collect(Collectors.groupingBy(e -> e.getCourse()));


        for(Map.Entry<Integer, List<Student>> entry : courseStudents.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


        Map<Boolean, List<Student>> partitionedStudents = students.stream().collect(Collectors.partitioningBy(el -> el.getAvgGrade() > 7));
        for(Map.Entry<Boolean, List<Student>> entry : partitionedStudents.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }



    }
}
