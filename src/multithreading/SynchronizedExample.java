package multithreading;

public class SynchronizedExample {
    public static void main(String[] args) {
        MyRunnableImpl1 runnableImpl1 = new MyRunnableImpl1();
        Thread thread1 = new Thread(runnableImpl1);
        Thread thread2 = new Thread(runnableImpl1);
        Thread thread3 = new Thread(runnableImpl1);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Counter{
    static int count = 0;
}

class MyRunnableImpl1 implements Runnable{

    // Without synchronized keyword output is unpredictable (like 3 4 5 2 6 2 8 9 7), because 2 threads
    // may be changing the variable simultaneously
    //  synchronized guarantees that ONLY 1 thread is using this method(and changing variable) at a time
    public synchronized void increment(){
        Counter.count++;
        System.out.print(Counter.count + " ");
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            increment();
        }
    }
}