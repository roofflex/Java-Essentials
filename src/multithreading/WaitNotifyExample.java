package multithreading;

public class WaitNotifyExample {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Consumer consumer = new Consumer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }
}


// Concept: there is a market with 5 items in a glass case,
// if glass case has some bread, consumer may take it 1 by 1, until it's empty
// producer produces bread if the glass case is not full, when consumer doesn't buy bread,
// or while he waits, since the glass case is empty


// wait() and notify() may be invoked ONLY from synchronized context!
// wait() and notify() are invoked on instance that is used to synchronize method (defaults to (this))
// wait() releases the monitor and puts thread on hold until another thread invokes notify()
// notify() DOES NOT release the monitor and wakes up the thread that was on hold
class Market{
    private int breadCount = 0;

    public synchronized void getBread(){
        while (breadCount < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount--;
        System.out.println("Customer took 1 loaf of bread");
        System.out.println(breadCount + " loaves of bread left");
        notify();
    }

    public synchronized void putBread(){
        while(breadCount >= 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        breadCount++;
        System.out.println("Producer has put 1 loaf of bread");
        System.out.println(breadCount + " loaves of bread left");
        notify();
    }
}


class Producer implements Runnable{
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            market.putBread();
        }
    }
}

class Consumer implements Runnable{
    Market market;

    public Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            market.getBread();
        }
    }
}