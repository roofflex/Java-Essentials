package collection.mapinterface;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {

    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1000, "Ivan Petrov");
        hashMap.put(235, "Maxim Ivanov");
        hashMap.put(768, "Yarosvav Krasnov");
        hashMap.put(146, "Mihail Fomenko");

        System.out.println(hashMap);
        System.out.println(hashMap.get(768));

        System.out.println(hashMap.containsValue("Maxim Ivanov"));

        System.out.println(hashMap.keySet());
        System.out.println(hashMap.values());

        // HashMap has 2 optional params in Constructor - initial capacity(size of array of buckets) and load factor(how much the table can be loaded)
        HashMap<Integer, String> map = new HashMap<>(16,0.75f);
    }
}
