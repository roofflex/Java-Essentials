package multithreading;

public class ThreadWithLambda {

    public static void main(String[] args) {

        // thread creation using anonymous class
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        }).start();

        // thread creating using lambda (since Runnable is a functional interface)
        new Thread(() -> System.out.println("Goodbye!")).start();
    }
}
