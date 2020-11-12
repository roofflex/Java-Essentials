package multithreading;

public class SynchronizedMethodsExample {

    static final Object lock = new Object();

    // if we use plain synchronized in method signature it will still work incorrectly
    // (correct - 1 call at a time, as in real life)
    // because synchronized is using (this) by default - monitor on object, and we have 3 different objects,
    // so this way they're still able to run simultaneously,
    // BUT if we use synchronization on 1 object, then threads will run their methods 1 by 1
    // Note: we can use ANY object to synchronize threads (except (this)),
    // but BEST PRACTICE is to use instance of Object named lock, like this:
    //                                  static final Object lock = new Object();
    void mobileCallMethod(){
        synchronized (lock) {
            System.out.println("Mobile call starts");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mobile call ends");
        }
    }

    void skypeCallMethod(){
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ends");
        }
    }

    void telegramCallMethod(){
        synchronized (lock) {
            System.out.println("Telegram call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Telegram call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplTelegram());
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable{
    @Override
    public void run() {
            new SynchronizedMethodsExample().mobileCallMethod();
    }
}

class RunnableImplSkype implements Runnable{
    @Override
    public void run() {
        new SynchronizedMethodsExample().skypeCallMethod();
    }
}

class RunnableImplTelegram implements Runnable{
    @Override
    public void run() {
        new SynchronizedMethodsExample().telegramCallMethod();
    }
}
