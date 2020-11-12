package multithreading;

public class SleepAndJoinMethods extends Thread{
    public static void main(String[] args) throws InterruptedException {
        SleepAndJoinMethods thread1 = new SleepAndJoinMethods();
        Thread thread2 = new Thread(new MyRunnable1());

        System.out.println("thread1 state: " + thread1.getState());

        thread1.start();
        System.out.println("thread1 state: " + thread1.getState());
        thread2.start();


        // method join pauses the operations in current thread until the thread that it was invoked on is completed
        // so here it is like that:
        // join() methods are invoked inside main thread, they're invoked on thread1 & thread2
        // that means that the further operations in main will be completed ONLY AFTER thread1 & thread2 complete their work!
        thread1.join();
        thread2.join();

        System.out.println("thread1 state: " + thread1.getState());

        // if we use join() with param, like thread1.join(1500) 1500 are millis,
        // thread main waits until EITHER thread1 completes its work OR 1500 milliseconds pass and continues its work
        System.out.println("Completed!");
    }

    // THREAD STATES:
    //  New -> Runnable(Ready -> Running) -> Terminated
    //

    @Override
    public void run() {
        for(int i = 5; i > 0; i--){
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyRunnable1 implements Runnable{
    @Override
    public void run() {
        for(int i = 1; i < 10; i++){
            try{
                Thread.sleep(1000);

            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
