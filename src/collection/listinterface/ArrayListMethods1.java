package collection.listinterface;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListMethods1 {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Misha");
        names.add("Stas");
        names.add("Kostya");

        names.set(1, "Ivan");

        names.remove(0);

        System.out.println(names.indexOf("Kostya"));
        System.out.println(names);

        Collections.reverse(names);

        System.out.println("Reversed list:" + names);

        names.clear();


    }
}
