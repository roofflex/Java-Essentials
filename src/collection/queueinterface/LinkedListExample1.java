package collection.queueinterface;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListExample1 {
    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        queue.add("Petr");
        queue.add("Max");
        queue.add("Oleg");
        queue.add("Masha");

        System.out.println(queue);
        System.out.println(queue.remove());

        queue.remove("Ivan");
        System.out.println(queue.peek());

        // queue.poll copies method remove, but doesn't throw exception if the queue is empty

    }
}
