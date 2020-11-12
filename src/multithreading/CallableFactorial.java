package multithreading;

import java.util.concurrent.*;

public class CallableFactorial {
    static int factorialResult;

    // Callable is also computing something, as Runnable, BUT
    // it is not void and generic, so it can return any type of data,
    // and it can throw exception

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial2 factorial2 = new Factorial2(5);
        // to operate Callable we can't use .execute()
        // INSTEAD, use .submit()
        // .submit() returns data in Future object parameterized with data type the same as Callable<>)
        // so, Here: Callable<Integer>     --->    Future<Integer>
        // Future object is called that way because it has NO data at the moment it is created,
        // but it gets the result as soon as executorService finishes Callable task (in the future)
        Future<Integer> future =  executorService.submit(factorial2);

        try {
            System.out.println("Awaiting for the result...");
            // future.get() blocks the main thread until needed task in threadpool completes
            // and future acquires its result (Here: until future receives counted factorial)
            factorialResult = future.get();

            System.out.println("Got the result!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());

        }
        // Best practice is to shutdown ExecutorService in finally block
        finally {
            executorService.shutdown();
        }
        System.out.println(factorialResult );
    }
}

class Factorial2 implements Callable<Integer>{
    int f;

    public Factorial2(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if(f <= 0){
            throw new Exception("Incorrect number!");
        }
        int result = 1;
        for(int i = 1; i <= f; i++){
            result *= i;
        }
        Thread.sleep(1500);
        return result;
    }
}