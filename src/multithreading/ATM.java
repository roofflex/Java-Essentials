package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// ABout LOCK and REENTRANTLOCK

public class ATM {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        new Employee("Alex", lock);
        new Employee("Oleg", lock);
        new Employee("Max", lock);
        new Employee("Sasha", lock);
        new Employee("Igor", lock);
    }
}


// trylock() : returns boolean
// use case: if(lock.trylock){ tasks that we want to do if we successfully lock}
//                      else {tasks to do if lock is unsuccessful}

class Employee extends Thread{
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        try {
        System.out.println(name + " waits...");
        lock.lock();
        System.out.println(name + " uses ATM");
        Thread.sleep(200);
            System.out.println(name + " has ended work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}