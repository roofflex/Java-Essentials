package collection.queueinterface;

import java.util.PriorityQueue;

public class PriorityQueueExample1 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(3);
        pq.add(8);
        pq.add(1);
        pq.add(9);

        System.out.println(pq.peek());

    }
}

