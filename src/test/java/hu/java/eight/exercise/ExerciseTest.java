package hu.java.eight.exercise;

import hu.java.eight.exercise.domain.Trader;
import hu.java.eight.exercise.domain.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
}
