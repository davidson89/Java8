package hu.java.eight.future;

import hu.java.eight.future.domain.Shop;

import java.text.MessageFormat;
import java.util.concurrent.Future;

final class Client {
    private final Shop shop;

    Client() {
        this.shop = new Shop();
    }

    public void magic() {
        final long start = System.nanoTime();

        Future<Double> futurePrice = shop.getPriceAsync("My favorite product");

        final int million = 1_000_000;
        final long invocationTime = ((System.nanoTime() - start) / million);
        System.out.println(MessageFormat.format("Invocation returned after {0} ms", invocationTime));

        doSomethingElse();

        try {
            double price = futurePrice.get();
            System.out.println(MessageFormat.format("Price is: {0}", price));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        final long retrievalTime = ((System.nanoTime() - start) / million);

        System.out.println(MessageFormat.format("Price returned after {0} ms", retrievalTime));
    }

    private void doSomethingElse() {
        System.out.println("Do something else...");
    }
}
