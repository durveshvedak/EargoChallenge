package com.eargo.exercise3;

import java.util.ArrayList;
import java.util.List;

public class BestBuyAndSell {

    /**
     * @param prices contains price of stock at each day
     * @return list containing buy day and sell day of stock giving max profit
     * Time Complexity O(n2)
     */
    public List<String> bruteForceBestBuyAndSell( int prices[] ) {
        List<String> result = new ArrayList<>();
        int maxprofit = 0;
        int n = prices.length;
        int buyIndex = 0;
        int sellIndex = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                    buyIndex = i+1;
                    sellIndex = j+1;
                }

            }
        }

        result.add("Buy Day " + buyIndex);
        result.add("Sell Day " + sellIndex);

        return result;

    }

    /**
     * @param prices contains price of stock at each day
     * @return list containing buy day and sell day of stock giving max profit
     * Time Complexity O(n)
     */
    public List<String> bestBuyAndSell( int prices[] ) {
        List<String> result = new ArrayList<>();
        int buy = prices[0];
        int maxProfit = Integer.MIN_VALUE;
        int n = prices.length;
        int buyIndex = 0;
        int sellIndex = 0;
        for ( int i = 1; i < n; i++ ) {
            if ( prices[i] < buy ){
                buy = prices[i];
                buyIndex = i+1;
            }
            if ( maxProfit < prices[i] - buy ){
                maxProfit = prices[i] - buy;
                sellIndex = i+1;
            }

        }
        result.add("Buy Day " + buyIndex);
        result.add("Sell Day " + sellIndex);

        return result;

    }
}
