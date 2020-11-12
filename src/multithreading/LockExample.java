package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.mobileCall();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.skypeCall();
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                call.telegramCall();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call{
    private Lock lock = new ReentrantLock();

    void mobileCall(){
        lock.lock();
        try {
            System.out.println("Mobile call starts");
            Thread.sleep(3000);
            System.out.println("Mobile call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // VERY IMPORTANT to put lock.unlock() in finally block so the lock releases
        //                              even if exceptions have been thrown
        finally {
            lock.unlock();
        }

    }

    void skypeCall(){
        lock.lock();
        try {
            System.out.println("Skype call starts");
            Thread.sleep(5000);
            System.out.println("Skype call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // VERY IMPORTANT to put lock.unlock() in finally block so the lock releases
        //                              even if exceptions have been thrown
        finally {
            lock.unlock();
        }

    }

    void telegramCall(){
        lock.lock();
        try {
            System.out.println("Telegram call starts");
            Thread.sleep(7000);
            System.out.println("Telegram call ends");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // VERY IMPORTANT to put lock.unlock() in finally block so the lock releases
        //                              even if exceptions have been thrown
        finally {
            lock.unlock();
        }

    }
}