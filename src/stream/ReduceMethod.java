package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceMethod {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 5, 9, 13, 17);


        // reduce method is used to create one element from the whole stream via multiplying / summing / etc its elements

        Optional<Integer> multiplication = list.stream().reduce((accumulator, element) -> accumulator*element);

        System.out.println(multiplication.isPresent() ? multiplication.get() : "Null element");

        List<String> strings = List.of("Hi", "Let's", "Study", "Streams", "Today!");

        String result = strings.stream().reduce("",(accumulator, string) -> accumulator + string + " ");

        System.out.println(result);

    }
}
