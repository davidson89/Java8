package hu.java.eight.future;

import hu.java.eight.future.domain.Shop;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

import static java.util.stream.Collectors.toList;

final class Client {
    private final List<Shop> shops;

    Client() {
        this.shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavouriteShop"),
                new Shop("BuyItAll"));
    }

    public void magic() {
        final long start = System.nanoTime();

        Future<Double> futurePrice = shops.get(0).getPriceAsync("My favorite product");

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

    public List<String> findPrices(final String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(toList());
    }

    private void doSomethingElse() {
        System.out.println("Do something else...");
    }
}
