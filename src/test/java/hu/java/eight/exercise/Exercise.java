package hu.java.eight.exercise;

import hu.java.eight.exercise.domain.Trader;
import hu.java.eight.exercise.domain.Transaction;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Exercise {
    public List<Transaction> findAllTransactions(final List<Transaction> transactions, final int year) {
        return transactions.stream()
                .filter(t -> t.getYear() == year)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
    }

    public List<String> findAllCities(final List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
    }

    public List<Trader> findTradersByCity(final List<Transaction> transactions, final String city) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals(city))
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
    }

    public String findAllTraders(List<Transaction> transactions) {
        return transactions.stream()
                .map(transaction -> transaction.getTrader())
                .distinct()
                .sorted(comparing(Trader::getName))
                .map(t -> t.getName())
                .reduce((a, b) -> a + " " + b)
                .get();
    }

    public boolean tellIfThereAreAnyTradersBasedInMilan(List<Transaction> transactions) {
        return transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
    }

    public List<Integer> printTransactionValuesFromTradersLivingInCambridge(List<Transaction> transactions) {
        return transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(t -> t.getValue())
                .collect(toList());
    }
}
