package multithreading;

public class VolatileExample extends Thread {


    // volatile is EXTREMELY important here! It indicates that this variable wiil be stored only in main memory(not in cache)
    // so if one thread changes its state, it will be changed in another almost instantly, otherwise
    // thread "thread" will copy b=true in cache and, when thread "main" sets b to false, nothing happens
    // since b is stored in different cpu's cache
    // Important to know that best practice is to use volatile when only 1 thread changes variable and other threads only read it

    volatile boolean b = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileExample thread = new VolatileExample();
        thread.start();
        Thread.sleep(3000);
        System.out.println("3 seconds passed, time to wake up!");
        thread.b = false;
        thread.join();
        System.out.println("End of program!");
    }

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished! Counter = " + counter);
    }
}
