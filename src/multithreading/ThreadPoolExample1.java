package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {
    public static void main(String[] args) throws InterruptedException {
        // Most convenient way to create a threadpool is to use Executors' factory methods:
        // Executors.newFixedThreadPool(int n)  creates a pool with n threads
        // Executors.newSingleThreadExecutor() creates a pool with single thread
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            executorService.execute(new RunnableImpl100());
        }


        // if there are no new tasks for threadpool coming, ALWAYS shut it down,
        // otherwise, the program won't stop running
        executorService.shutdown();
        // awaitTermination() makes the thread it is invoked in to wait until either
        // threadpool completes all its tasks OR the time in awaitTermination() args passes, what happens FIRST
        //      Here: main thread will wait until either threadpool completes all tasks OR 5 seconds pass, what happens first,
        // and continues to printing "Main ends"
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main ends");

    }
}

class RunnableImpl100 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
