package collection.listinterface;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExample {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Misha");
        names.add("Stas");
        names.add("Kostya");

        Iterator<String> stringIterator = names.iterator();

        while(stringIterator.hasNext()){

            // iterator.next() retrieves element, iterator.remove() removes element from collection
            System.out.println(stringIterator.next());
        }
    }
}
