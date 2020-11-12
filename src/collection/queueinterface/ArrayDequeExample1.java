package collection.queueinterface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample1 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(4);
        deque.offerFirst(3);
        deque.offerLast(5);
        deque.offerLast(8);

        System.out.println(deque);

        System.out.println(deque.pollLast());

        System.out.println(deque.peekFirst());
    }
}
