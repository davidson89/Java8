package hu.java.eight.future.domain;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public final class Shop {
    private static final long DELAY = 1000L;
    private final Random random;

    public Shop() {
        this.random = ThreadLocalRandom.current();
    }

    public static void delay() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public double getPrice(final String product) {
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(final String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(final String product) {
        delay();
        return Math.random() * product.charAt(0) + product.charAt(1);
    }
}
