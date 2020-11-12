package stream;

import java.util.Arrays;

public class SortedMethod {
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 5, 7, 8, -1};
        array = Arrays.stream(array).sorted().toArray();

        System.out.println(Arrays.toString(array));
    }
}
