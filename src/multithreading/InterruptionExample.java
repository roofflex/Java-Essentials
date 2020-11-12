package multithreading;

public class InterruptionExample {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MAIN STARTS");
        InterruptedThread interruptedThread = new InterruptedThread();
        interruptedThread.start();
        Thread.sleep(2000);
        // .interrupt() only informs thread that we want to interrupt it
        // we may use isInterrupted() inside target thread to speed it up
        // by breaking the loop or skipping some code etc. (interrupt it)
        interruptedThread.interrupt();
        interruptedThread.join();
        System.out.println("MAIN ENDS");
    }
}

class InterruptedThread extends Thread{
    double sqrtSum = 0;

    @Override
    public void run() {
        for(int i = 1; i <= 1000000000; i++){
            if(isInterrupted()){
                System.out.println("Thread is being interrupted");
                System.out.println("We finished our work.");
                System.out.println("Sum = " + sqrtSum);
                // stops our thread if it is tried to be interrupted
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("The thread is being interrupted during sleep. Finishing work...");
                System.out.println("Sum = " + sqrtSum);
                return;
            }
        }
        System.out.println("Sum = " + sqrtSum);
    }
}