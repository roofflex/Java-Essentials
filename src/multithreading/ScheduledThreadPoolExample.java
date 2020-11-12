package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {

        // Note: we may want ti use Executors.newCachedThreadPool()
        // it Cached threadpool creates threads inside on demand
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        for(int i = 0; i < 10; i++){
            scheduledExecutorService.execute(new RunnableImpl200());
        }
        // .schedule() schedules execution of a task for given timeunits
        scheduledExecutorService.schedule(new RunnableImpl200(), 3, TimeUnit.SECONDS);

        // scheduleAtFixedRate() is used for tasks that we want to repeat executing
        //      Here: a task will be FIRST executed after 3 seconds and then will be repeated every 1 second
        // period is time between attempts to execute task
        // if the time it takes to execute task is longer than period, then next task will start INSTANTLY
        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);

        // in scheduleWithFixedDelay()   period is the time BETWEEN the END of a task and the START of the next task
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200(), 3, 1, TimeUnit.SECONDS);
        Thread.sleep(15000);
        scheduledExecutorService.shutdown();
    }
}

class RunnableImpl200 implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " begins work");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " ends work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
