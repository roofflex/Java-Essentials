package stream;

import java.util.stream.Stream;

public class ConcatMethod {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 3, 5, 7, 9, 11);
        Stream<Integer> stream2 = Stream.of(2, 4, 6, 8, 10, 12);

        Stream<Integer> stream3 = Stream.concat(stream1, stream2);

        stream3.forEach(System.out::println);

        System.out.println("////////////////////");
        // distinct method leaves eunique elements
        Stream<Integer> stream4 = Stream.of(1, 2, 5, 1, 7, 5, 8, 2, 1, 1, 7, 2, 5);

        stream4.distinct().forEach(System.out::println);

        System.out.println("////////////////////");

        // count method returns element count as long

        Stream<Integer> stream5 = Stream.of(1, 2, 5, 1, 7, 5, 8, 2, 1, 1, 7, 2, 5);

//        System.out.println(stream5.count());
//        commented as we can not reuse stream after performing operations on it
        System.out.println(stream5.distinct().count());
        System.out.println("////////////////////");

        // peek method is like forEach method(has Consumer<T> as param), but it returns stream instead of void,
        // so peek IS NOT A TERMINAL METHOD

        Stream<Integer> stream6 = Stream.of(1, 2, 5, 1, 7, 5, 8, 2, 5);
        long result = stream6.distinct().peek(System.out::println).count();
        System.out.println("////////////////////");
        System.out.println(result);

    }
}
