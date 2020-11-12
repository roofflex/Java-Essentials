package collection.listinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(157);
        for (int i = 0; i < 15; i++){
            list.add(new Random().nextInt(270));
        }
        System.out.println("Unsorted list:" + list);
        Collections.sort(list);
        System.out.println("Sorted list:" + list);
        int index = Collections.binarySearch(list, 157);
        System.out.println("57 is on position " + index);

    }
}
