package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapMethod {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Ok");
        strings.add("Bye");
        strings.add("Java");

        System.out.println(strings);

        // changing string values from original to their length, in a loop
//        for(int i = 0; i < strings.size(); i++){
//            strings.set(i, String.valueOf(strings.get(i).length()));
//        }

        // Generating a new list of lengths using stream
        List<Integer> lengths = strings.stream().map(element -> element.length()).collect(Collectors.toList());

        System.out.println(lengths);


        int[] array = {1,2,5,7,9};
        array = Arrays.stream(array).map(element ->
        {
            if (element % 3 == 0){
                element /= 3;
            }
            return element;
        }).toArray();

        System.out.println(Arrays.toString(array));
    }
}
