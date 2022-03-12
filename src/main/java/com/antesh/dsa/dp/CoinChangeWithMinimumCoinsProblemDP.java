package com.antesh.dsa.dp;

public class CoinChangeWithMinimumCoinsProblemDP {

    public static void main(String[] args) {

        System.out.println(minimumCoinsForChange(4, new int[]{1, 2, 3}));  //2+2 or 1+3
        System.out.println(minimumCoinsForChange(6, new int[]{1, 2, 5}));   //1+5

    }
    //Knapsack unbounded solution where we either have to include item or exclude item in the bag and accumulate
    // the results of sub problem to reach final optimal result
    //solution using memoization table, TC: O(amount*coins), SC: O(amount*coins)
    public static int minimumCoinsForChange(int amount, int[] coins) {
        int[][] memo = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                //base case
                if (i == 0 && j == 0) {
                    memo[i][j] = 0;
                }
                //if amount > 0 but no coins array then Infinity as not possible to make change without any coins
                else if (i == 0 && j > 0) {
                    memo[i][j] = Integer.MAX_VALUE;

                }
                //
                //If amount < new coins included then we have to exclude higher coins than the amount
                else if (coins[i-1] > j) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    //else minimum( (1+ new included coins), excluded coin)
                    memo[i][j] = Math.min((1 + memo[i][j - coins[i-1]]), memo[i - 1][j]);
                }
            }
        }

        //minimum coins required will be at the last row and column
        return memo[coins.length][amount];
    }
}
