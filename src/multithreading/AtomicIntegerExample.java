package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

//    static int counter = 0;

    // AtomicInteger solves the problem of Data Race
    // while using less resources than making a method synchronized
    // May use it, when there's a need to do basic operations in multiple threads

    //AtomicInteger is a class that allows us to work with integers,
    // using atomic methods
    // Note : if we have int a, a++ IS NOT an atomic operation, since we have to:
    // get the value, increment the value, set the new value
    static AtomicInteger counter = new AtomicInteger(0);

    public static void increment(){
        counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnableImpl11());
        Thread thread2 = new Thread(new MyRunnableImpl11());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }

}

class MyRunnableImpl11 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            AtomicIntegerExample.increment();
        }
    }
}
