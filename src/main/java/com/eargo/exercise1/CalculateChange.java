package com.eargo.exercise1;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class CalculateChange {


    /**
     * @param cents
     * @return list having minimum coins adding to cents
     * Assuming we have unlimited number of coins of each denomination
     * Greedy approach to get minimum number of coins
     */
    public List<String> getMinimumCoinsGreedy(int cents ) {

        if ( cents < 0 ){
            return null;
        }

        List<String> result = new ArrayList<>();
        Map<String, Integer> mapOFCoinDenomination = new HashMap<>();
        mapOFCoinDenomination.put("Quarters", 0);
        mapOFCoinDenomination.put("Dimes", 0);
        mapOFCoinDenomination.put("Nickel", 0);
        mapOFCoinDenomination.put("Pennies", 0);
        while ( cents > 0 ) {
            /*
            Order is important. If we get a coins array instead we have to sort it first - O(nlogn)
            in descending order to make this greedy strategy work.
            */
            if ( cents >= 25 ) {
                mapOFCoinDenomination.put("Quarters", mapOFCoinDenomination.get("Quarters") + 1 );
                cents -= 25;
            }

            else if ( cents >= 10 ) {
                mapOFCoinDenomination.put("Dimes", mapOFCoinDenomination.get("Dimes") + 1 );
                cents -= 10;
            }

            else if ( cents >= 5 ) {
                mapOFCoinDenomination.put("Nickel", mapOFCoinDenomination.get("Nickel") + 1 );
                cents -= 5;
            }

            else {
                mapOFCoinDenomination.put("Pennies", mapOFCoinDenomination.get("Pennies") + 1 );
                cents -= 1;
            }
        }

        for ( String key : mapOFCoinDenomination.keySet() ) {
            result.add(key + " " + mapOFCoinDenomination.get(key));
        }

        return result;

    }

    /**
     * @param coins denominations of coins
     * @param n number of coins
     * @param cents
     * @return minimum coins required to make the value cents
     * Complexity : Time - O(cents*n) Space - O(cents)
     */
    public int minCoinsRequiredDP(int coins[], int n, int cents ) {


        // dp[i] stores the minimum number of coins required to make the value i
        int dp[] = new int[cents + 1];

        dp[0] = 0;

        for (int i = 1; i <= cents; i++)
            dp[i] = Integer.MAX_VALUE;

        for (int i = 1; i <= cents; i++) {
            for (int j = 0; j < n; j++) {
                if (coins[j] <= i) {
                    int temp = dp[i - coins[j]];
                    if (temp != Integer.MAX_VALUE
                            && temp + 1 < dp[i])
                        dp[i] = temp + 1;
                }
            }
        }

        return dp[cents];

    }
}
