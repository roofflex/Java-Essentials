package stream;

import java.util.Arrays;

public class MethodChaining {
    public static void main(String[] args) {
        int[] array = {1, 5, 17, 21, 35, 7, -4, 23, 19, 32, 12, 46, 3};

        // leave only numbers that are divisible by 3 -> multiply them by 5 -> calculate their sum  || using method chaining

        int result = Arrays.stream(array).filter(element -> element % 3 == 0).map(x -> x*5).reduce((accumulator, element) -> accumulator+element).getAsInt();
        System.out.println(result);
    }
}
