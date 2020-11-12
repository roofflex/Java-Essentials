package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumOfNumbersWithCallable {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futures = new ArrayList<>();
        long tenthOfValue = value/10;
        for(int i = 0; i < 10; i++){
             long from = tenthOfValue*i + 1;
             long to = tenthOfValue*(i+1);
            PartialSum partialSumTask = new PartialSum(from, to);
            Future<Long> futurePartialSum = executorService.submit(partialSumTask);
            futures.add(futurePartialSum);
        }
        try {
            for(Future<Long> result : futures) {
                sum += result.get();
            }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
            executorService.shutdown();
        }

        System.out.println("Final sum from 1 to 1000000000 is " + sum);



    }
}

class PartialSum implements Callable<Long>{
    long from;
    long to;
    long localSum;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() throws Exception {
        for(long i = from; i <= to; i++){
            localSum += i;
        }
        System.out.println("Sum from " + from + " to " + to + " = " + localSum);
        return localSum;
    }
}
