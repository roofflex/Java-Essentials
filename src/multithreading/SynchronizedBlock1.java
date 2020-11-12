package multithreading;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImpl2 runnableImpl2 = new MyRunnableImpl2();
        Thread thread1 = new Thread(runnableImpl2);
        Thread thread2 = new Thread(runnableImpl2);
        Thread thread3 = new Thread(runnableImpl2);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}

class Counter2{
    static int count = 0;
}

class MyRunnableImpl2 implements Runnable{


    public void doWork1(){
        // synchronized block - need to explicitly point out monitor of which object/class we are using to synchronize threads
        synchronized (this) {
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i++){
            doWork1();
        }
    }
}
