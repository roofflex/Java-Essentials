package collection.mapinterface;

import java.util.LinkedHashMap;

public class LinkedHashMapExample1 {
    public static void main(String[] args) {

        // LinkedHasMap may store elements in order they are put or accessed
        LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        Student st1 = new Student("Petr", "Smelov", "C#");
        Student st2 = new Student("Max", "Dobriy", "C++");
        Student st3 = new Student("John", "Avans", "Ruby");
        linkedHashMap.put(5.8, st1);
        linkedHashMap.put(6.4, st2);
        linkedHashMap.put(7.9, st3);

        System.out.println(linkedHashMap);

        System.out.println(linkedHashMap.get(6.4));

        System.out.println(linkedHashMap);

    }
}
