package collection.mapinterface;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample1 {
    public static void main(String[] args) {
        TreeMap<Double, Student> treeMap = new TreeMap<>();
        Student st1 = new Student("Petr", "Smelov", "C#");
        Student st2 = new Student("Max", "Dobriy", "C++");
        Student st3 = new Student("John", "Avans", "Ruby");
        treeMap.put(5.8, st1);
        treeMap.put(6.4, st2);
        treeMap.put(7.9, st3);

        System.out.println(treeMap);
        System.out.println(treeMap.get(7.9));
        System.out.println(treeMap.descendingMap());

        System.out.println(treeMap.tailMap(6.0));
        System.out.println(treeMap.headMap(6.0));

        System.out.println("Student with lowest grade" + treeMap.firstEntry());
        System.out.println("Student with highest grade" + treeMap.lastEntry());


        TreeMap<Student, Double> studentDoubleTreeMap = new TreeMap<>();
        // to use class as a key in treemap, class has to implement Comparable<>

        studentDoubleTreeMap.put(st1, 5.3);
        studentDoubleTreeMap.put(st2, 8.1);
        studentDoubleTreeMap.put(st3, 4.1);

        System.out.println(studentDoubleTreeMap);

    }
}
