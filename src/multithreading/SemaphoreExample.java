package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore phoneBox = new Semaphore(2);
        new Person("Olya", phoneBox);
        new Person("Dima", phoneBox);
        new Person("Vitalik", phoneBox);
        new Person("Azalia", phoneBox);
        new Person("Artyom", phoneBox);

    }
}

class Person extends Thread{
    String name;
    private Semaphore phoneBox;

    public Person(String name, Semaphore phoneBox) {
        this.name = name;
        this.phoneBox = phoneBox;

        // this code will set thread's name and start it on creation
        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waits...");
            // acquire() attempts to use resource, blocks current thread until Semaphore
            // permits the access to the resource, then thread continues its work
            // Semaphore decrements its permit counter
            phoneBox.acquire();
            System.out.println(name + " calls...");
            Thread.sleep(2000);
            System.out.println(name + " ends call");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // .release() releases resource, so Semaphore increments permit counter
            // USE it in FINALLY block to avoid blocking the resource in case of exceptions
            phoneBox.release();
        }
    }
}
