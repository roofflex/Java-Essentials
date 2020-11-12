package multithreading;

public class SynchronizedBlock2 {

    static int counter = 0;

    static void increment(){
        // in this example method is static, so in the synchronized block we cannot
        // use synchronized(this), compiler wouldn't allow that!
        // Instead, we should use whole class' monitor to synchronize threads
        synchronized (SynchronizedBlock2.class) {
            counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new R());
        Thread thread2 = new Thread(new R());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class R implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            SynchronizedBlock2.increment();
        }
    }
}
