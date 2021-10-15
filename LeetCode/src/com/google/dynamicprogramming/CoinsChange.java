package com.google.dynamicprogramming;

import java.io.IOException;
import java.util.Arrays;

public class CoinsChange {

    private static int coinChangeInternal(int[] coins, int amount, int[] memCache) {

        if (amount == 0) {
            return 1;
        }

        int minCoinsRequired = Integer.MAX_VALUE;
        for (int index = 0; index < coins.length; index++) {
            int remAmt = amount - coins[index];

            // remaining amount is less than zero and if cache value is zero then
            // there are no valid coin denominations possible
            if (remAmt < 0 || memCache[remAmt] == 0) {
                continue;
            }

            // We found the a coin of same denomination as amt. So, result will
            // be always 1.
            if (remAmt == 0) {
                memCache[amount] = 1;
                return 1;
            }

            // Trying to find the cache value.
            if (memCache[remAmt] == -1) {
                memCache[remAmt] = coinChangeInternal(coins, remAmt, memCache);
            }

            // computing the min coins required.
            if (memCache[remAmt] != 0 && memCache[remAmt] < minCoinsRequired) {
                minCoinsRequired = memCache[remAmt];
            }
        }

        if (minCoinsRequired == Integer.MAX_VALUE) {
            memCache[amount] = 0;
        } else {
            memCache[amount] = minCoinsRequired + 1;
        }

        return memCache[amount];
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        // -1 denotes uninitialized.
        // 0 indicates no valid combinations found.
        int[] memCache = new int[amount + 1];
        Arrays.fill(memCache, -1);
        coinChangeInternal(coins, amount, memCache);
        if (memCache[amount] == 0) {
            return -1;
        } else {
            return memCache[amount];
        }
    }

    public static void main(String[] args) throws IOException {
        int[] input = new int[]{1, 2, 5};
        int target = 11;
        System.out.println("Result = " + coinChange(input, target));
    }
}
