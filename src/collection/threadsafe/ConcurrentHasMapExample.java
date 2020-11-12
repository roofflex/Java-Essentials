package collection.threadsafe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHasMapExample {
    public static void main(String[] args) throws InterruptedException {

        //ConcurrentHashMap can NOT contain null neither as a key, nor as a value
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Max");
        map.put(2, "Andrey");
        map.put(3, "Vasya");
        map.put(4, "Max");
        map.put(5, "Andrey");
        map.put(6, "Vasya");
        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator<Integer> integerIterator = map.keySet().iterator();
            while(integerIterator.hasNext()){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer i = integerIterator.next();
                System.out.println(i + " : " + map.get(i));
            }
        };

        Runnable runnable2 = () -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(7, "Elena");

        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(map);
    }
}
