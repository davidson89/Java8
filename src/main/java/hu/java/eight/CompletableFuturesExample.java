package hu.java.eight;

import java.text.MessageFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class CompletableFuturesExample {
    private final ExecutorService executor;

    CompletableFuturesExample() {
        this.executor = Executors.newCachedThreadPool();
    }

    public void magic() {
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation();
            }
        });
        doSomethingElse();
        try {
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println(MessageFormat.format("Result: {0}", result));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void doSomethingElse() {
        System.out.println("Do something else...");
    }

    private Double doSomeLongComputation() {
        System.out.println("Do some long computation...");
        return 0.0;
    }
}
