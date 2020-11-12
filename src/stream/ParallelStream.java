package stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(3.1);
        list.add(5.8);
        list.add(7.4);
        list.add(9.2);


        // use case for parallel stream is when we operate with a lot of elements (100000 and more)
        // and we want to use sum/multiplication
        double result = list.parallelStream().reduce((a, e) -> a+e).get();
        System.out.println(result);
    }
}
