package collection.threadsafe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {
    public static void main(String[] args) {
        // ArrayBlockingQueue is a capacity restricted collection, so arg "capacity" is necessary
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

        // Producer
        new Thread(() -> {
            int i = 0;
            while(true){
                try {
                    queue.put(++i);
                    System.out.println("Producer has added number " + i);
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Consumer
        new Thread(() -> {
            int i = 0;
            while(true){
                try {
                    int j = queue.take();
                    System.out.println("Consumer has taken number " + j);
                    Thread.sleep(9000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
