package multithreading;

public class DeadLockExample {
    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread10 thread10 = new Thread10();
        Thread20 thread20 = new Thread20();
        thread10.start();
        thread20.start();
    }

}

// DeadLock is when threads synchronize on 2 objects at different points, so that
// neither of them is able to proceed and the further processes can not be run,
// the program is in a dead lock
// Here thread10 synchronizes by lock1 first, then lock2
// and thread20 lock2 -> lock1
// This will eventually lead to a deadlock

// LiveLock is like a deadlock, but threads DO some work WITH NO RESULT

// Lock Starvation is when thread(s) with low priority wait for a VERY LONG time to run
//                          (threads with high priority constantly overtake them)

class Thread10 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread10: Attemp to take control of monitor of lock1");
        synchronized (DeadLockExample.lock1){
            System.out.println("Thread10: Took control of monitor of lock1");
            System.out.println("Thread10: Attemp to take control of monitor of lock2");
            synchronized (DeadLockExample.lock2){
                System.out.println("Thread10: Took control of monitors of lock1 and lock2");
            }
        }
    }
}

class Thread20 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread20: Attemp to take control of monitor of lock1");
        synchronized (DeadLockExample.lock2){
            System.out.println("Thread20: Took control of monitor of lock2");
            System.out.println("Thread20: Attemp to take control of monitor of lock1");
            synchronized (DeadLockExample.lock2){
                System.out.println("Thread20: Took control of monitors of lock2 and lock1");
            }
        }
    }
}