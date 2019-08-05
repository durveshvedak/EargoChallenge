package com.eargo.exercise3;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class BestBuyAndSellTest {

    private BestBuyAndSell bestBuyAndSell;

    @org.junit.Before
    public void setUp() {
        bestBuyAndSell = new BestBuyAndSell();
    }

    @Test
    public void bestBuyAndSell() {

        List<String> expected = new ArrayList<>();
        expected.add("Buy Day " + 6);
        expected.add("Sell Day " + 9);

        int input[] = new int[]{3,8,8,55,38,1,7,42,54,53};
        Assert.assertEquals(expected, bestBuyAndSell.bestBuyAndSell(input));
    }

    @Test
    public void bestBuyAndSellBruteForce() {

        List<String> expected = new ArrayList<>();
        expected.add("Buy Day " + 6);
        expected.add("Sell Day " + 9);

        int input[] = new int[]{3,8,8,55,38,1,7,42,54,53};
        Assert.assertEquals(expected, bestBuyAndSell.bruteForceBestBuyAndSell(input));
    }
}