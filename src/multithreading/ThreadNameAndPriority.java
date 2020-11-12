package multithreading;

public class ThreadNameAndPriority {
    public static void main(String[] args) {
        MyThread5 thread5 = new MyThread5();
        System.out.println("Name of thread5 = " + thread5.getName() + ", priority of thread5 = " + thread5.getPriority());

        // high priority of the thread does NOT guarantee that it will start earlier than the thread with lower priority
        thread5.setName("myThread5");
        thread5.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Name of thread5 = " + thread5.getName() + ", priority of thread5 = " + thread5.getPriority());
    }
}

// DO NOT SELF-INITIATE METHOD .run() on Threads!  It will cause errors. Always use thread.start();

class MyThread5 extends Thread{
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
