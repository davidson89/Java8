package hu.java.eight.exercise;

import hu.java.eight.exercise.domain.Trader;
import hu.java.eight.exercise.domain.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.testng.Assert.assertEquals;

public final class ExerciseTest {

    private final Trader raoul = new Trader("Cambridge", "Raoul");
    private final Trader mario = new Trader("Milan", "Mario");
    private final Trader alan = new Trader("Cambridge", "Alan");
    private final Trader brian = new Trader("Cambridge", "Brian");

    private final List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private final Exercise underTest = new Exercise();

    @Test
    public void shouldFindAllTransactionsInTheYear2011AndSortThemByValue() {
        final List<Transaction> expectedOutput = Arrays.asList(transactions.get(0), transactions.get(2));
        final int year = 2011;

        final List<Transaction> actualOutput = underTest.findAllTransactions(transactions, year);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindUniqueCitiesWhereTradersWork() {
        final List<String> expectedOutput = Arrays.asList("Cambridge", "Milan");

        final List<String> actualOutput = underTest.findAllCities(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindAllTradersFromCambridgeAndSortThemByName() {
        final List<Trader> expectedOutput = Arrays.asList(alan, brian, raoul);

        final List<Trader> actualOutput = underTest.findTradersInCambridge(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldReturnAListOfTradersNamesSortedAlphabetically() {
        final String expectedOutput = "Alan Brian Mario Raoul";

        final String actualOutput = underTest.findAllTraders(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldTellIfThereAreAnyTradersBasedInMilan() {
        final boolean expectedOutput = true;

        final boolean actualOutput = underTest.tellIfThereAreAnyTradersBasedInMilan(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldPrintTransactionValuesFromTradersLivingInCambridge() {
        final List<Integer> expectedOutput = Arrays.asList(300, 1000, 400, 950);

        final List<Integer> actualOutput = underTest.printTransactionValuesFromTradersLivingInCambridge(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindTheHighestValueOfAllTransactions() {
        final int expectedOutput = 1000;

        final int actualOutput = underTest.findTheHighestValueOfAllTransactions(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindTheTransactionWithTheSmallestValue() {
        final Transaction expectedOutput = transactions.get(0);

        final Optional<Transaction> actualOutput = underTest.findTheTransactionWithTheSmallestValue(transactions);

        assert actualOutput.isPresent();
        assertEquals(actualOutput.get(), expectedOutput);
    }

    @Test
    public void shouldGroupTransactionsByYearAndByTrader() {
        final Map<Integer, Map<String, List<Transaction>>> expectedOutput = new HashMap<>();
        final Map<String, List<Transaction>> transactionsOf2011 = new HashMap<>();
        final Map<String, List<Transaction>> transactionsOf2012 = new HashMap<>();

        final int year2011 = 2011;
        final int year2012 = 2012;
        final int tr0 = 0;
        final int tr1 = 1;
        final int tr2 = 2;
        final int tr3 = 3;
        final int tr4 = 4;
        final int tr5 = 5;

        transactionsOf2011.put("Brian", singletonList(transactions.get(tr0)));
        transactionsOf2011.put("Raoul", singletonList(transactions.get(tr2)));

        transactionsOf2012.put("Raoul", singletonList(transactions.get(tr1)));
        transactionsOf2012.put("Mario", Arrays.asList(transactions.get(tr3), transactions.get(tr4)));
        transactionsOf2012.put("Alan", singletonList(transactions.get(tr5)));

        expectedOutput.put(year2011, transactionsOf2011);
        expectedOutput.put(year2012, transactionsOf2012);

        final Map<Integer, Map<String, List<Transaction>>> actualOutput = underTest
                .groupByYearAndTrader(transactions);

        assertEquals(actualOutput, expectedOutput);
    }
}
