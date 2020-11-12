package multithreading;

public class DaemonExample {
    public static void main(String[] args) {
        System.out.println("Main thread starts");
        UserThread userThread = new UserThread();
        userThread.setName("User thread");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("Daemon thread");
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
        System.out.println("Main thread ends");
    }
}

class UserThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for(char i = 'A'; i <= 'J'; i++){
            try {
                sleep(500);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DaemonThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for(int i = 1; i < 100; i++){
            try {
                sleep(200);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
