package hu.java.eight.exercise;

import hu.java.eight.exercise.domain.Trader;
import hu.java.eight.exercise.domain.Transaction;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ExerciseTest {

    Trader raoul = new Trader("Cambridge", "Raoul");
    Trader mario = new Trader("Milan", "Mario");
    Trader alan = new Trader("Cambridge", "Alan");
    Trader brian = new Trader("Cambridge", "Brian");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    private Exercise underTest = new Exercise();

    @Test
    public void shouldFindAllTransactionsInTheYear2011AndSortThemByValue() {
        List<Transaction> expectedOutput = Arrays.asList(transactions.get(0), transactions.get(2));

        List<Transaction> actualOutput = underTest.findAllTransactions(transactions, 2011);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindUniqueCitiesWhereTradersWork() {
        List<String> expectedOutput = Arrays.asList("Cambridge", "Milan");

        List<String> actualOutput = underTest.findAllCities(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldFindAllTradersFromCambridgeAndSortThemByName() {
        List<Trader> expectedOutput = Arrays.asList(alan, brian, raoul);

        List<Trader> actualOutput = underTest.findTradersByCity(transactions, "Cambridge");

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldReturnAListOfTradersNamesSortedAlphabetically() {
        String expectedOutput = "Alan Brian Mario Raoul";

        String actualOutput = underTest.findAllTraders(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldTellIfThereAreAnyTradersBasedInMilan() {
        boolean expectedOutput = true;

        boolean actualOutput = underTest.tellIfThereAreAnyTradersBasedInMilan(transactions);

        assertEquals(actualOutput, expectedOutput);
    }

    @Test
    public void shouldPrintTransactionValuesFromTradersLivingInCambridge() {
        List<Integer> expectedOutput = Arrays.asList(300, 1000, 400, 950);

        List<Integer> actualOutput = underTest.printTransactionValuesFromTradersLivingInCambridge(transactions);

        assertEquals(actualOutput, expectedOutput);
    }
}
