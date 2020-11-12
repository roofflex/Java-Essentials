package collection.threadsafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Hello");
        list.add("How");
        list.add("Are");
        list.add("You");
        list.add("Today");
        list.add("??");
        System.out.println(list);

        Runnable runnable3 = () -> {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(iterator.next());
            }
        };

        Runnable runnable4 = () -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.remove(4);
            list.add("Doing");
        };

        Thread thread1 = new Thread(runnable3);
        Thread thread2 = new Thread(runnable4);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(list);

    }
}
