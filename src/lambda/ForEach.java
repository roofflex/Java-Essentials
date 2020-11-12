package lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {
        List<String> list = List.of("May", "January", "April", "October", "July");

        // forEach() is using Consumer functional interface, so we can place lambda
        list.forEach(str -> System.out.println(str) );
    }
}
