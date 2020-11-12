package lambda;

import java.util.ArrayList;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Car");
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Map");
        strings.add("Soup");

        strings.removeIf(s -> s.length() < 4);

        System.out.println(strings);
    }
}
