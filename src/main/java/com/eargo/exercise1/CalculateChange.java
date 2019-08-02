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
    public List<String> getMinimumCoins( int cents ) {

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
            Order is important. If we get a coins array instead we have to sort it first
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
}
