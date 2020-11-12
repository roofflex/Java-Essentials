package collection.setinterface;

import java.util.LinkedHashSet;

public class LinkedHashSetExample1 {

    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add(4);
        linkedHashSet.add(5);
        linkedHashSet.add(1);
        linkedHashSet.add(3);
        linkedHashSet.add(2);

        System.out.println(linkedHashSet);

    }
}
