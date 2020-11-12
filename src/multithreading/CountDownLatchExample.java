package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    // CountDownLatch synchronizer makes threads wait until
    // the specified it it's constructor arg number of operation has been completed
    // Here: threads won't execute their code until 3 operations are done
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void marketStaffArrivesToPlace() throws InterruptedException{
        Thread.sleep(2000);
        System.out.println("Market staff came to workplace");

        // MARKS that needed operation is done and countdownlatch decrements its counter
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void settingUpThePlace() throws InterruptedException{
        Thread.sleep(2000);
        System.out.println("Market staff has set everything up");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void openingThePlace() throws InterruptedException{
        Thread.sleep(2000);
        System.out.println("Market staff opens the market");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Customer("Olya", countDownLatch);
        new Customer("Dima", countDownLatch);
        new Customer("Vitalik", countDownLatch);
        new Customer("Azalia", countDownLatch);
        new Customer("Artyom", countDownLatch);

        marketStaffArrivesToPlace();
        settingUpThePlace();
        openingThePlace();

    }
}

class Customer extends Thread{
    String name;
    private CountDownLatch countDownLatch;

    public Customer(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;

        this.setName(name);
        this.start();
    }

    @Override
    public void run() {
        try {
            // Blocks the further code from execution until CountDownLatch's counter > 0
            countDownLatch.await();
            System.out.println("Customer " + name + " started shopping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}