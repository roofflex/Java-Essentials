package stream;

import java.util.Arrays;

public class ForEachMethod {
    public static void main(String[] args) {
        int[] array = {1,2,5,7,9};
        Arrays.stream(array).forEach(element -> {
            element *= 2;
            System.out.print(element + " ");
        });

        Arrays.stream(array).forEach(System.out::println);
    }
}
