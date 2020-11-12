package collection.setinterface;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample1 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Lesha");
        set.add("Oleg");
        set.add("Igor");

        System.out.println(set);

        HashSet<Integer> hashSet1 = new HashSet<>();
        hashSet1.add(5);
        hashSet1.add(3);
        hashSet1.add(4);
        hashSet1.add(7);

        HashSet<Integer> hashSet2 = new HashSet<>();
        hashSet2.add(7);
        hashSet2.add(9);
        hashSet2.add(0);
        hashSet2.add(1);
        hashSet2.add(2);

        HashSet<Integer> union = new HashSet<>(hashSet1);
        union.addAll(hashSet2);

        HashSet<Integer> intersect = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);

        HashSet<Integer> subtract = new HashSet<>(hashSet1);
        intersect.retainAll(hashSet2);


        System.out.println("set 1:" + hashSet1);
        System.out.println("set 2:" + hashSet2);
        System.out.println("set union:" + union);
        System.out.println("set intersection:" + intersect);
        System.out.println("set subtraction:" + intersect);

    }
}
