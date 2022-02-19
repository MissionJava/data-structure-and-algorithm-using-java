package com.antesh.dsa.dp;

/*
    Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm}
    valued coins, how many ways can we make the change? The order of coins doesn’t matter.

    For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
    So output should be 4.

    For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
    So the output should be 5.

    This forming a tree with N as a root and children as a n-s1, n-s2, n-s3 ....and their children as n-s1-s1, n-s1-s2. n-s1-s3 ....
    so it forms a recursion where N is changing but set S will always be same
* */

public class CoinChangeProblemDP {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int m = arr.length;

        System.out.println(coinChangePossibilityCount(4, arr));
        System.out.println(coinChangePossibilityCount(6, new int[]{1,2,5}));
    }

    //Knapsack unbounded solution where we either have to include item or exclude item in the bag and accumulate
    // the results of sub problem to reach final optimal result
    //solution using memoization table, TC: O(amount*coins), SC: O(amount*coins)
    public static int coinChangePossibilityCount(int amount, int[] changes) {
        int[][] memo = new int[changes.length + 1][amount + 1];

        for (int i = 0; i < changes.length + 1; i++) {
            for (int j = 0; j < amount + 1; j++) {
                if (i == 0 && j == 0) {
                    memo[i][j] = 1;
                } else if(i == 0 && j > 0){
                    memo[i][j] = 0;
                } else if (i > j) {
                    memo[i][j] = memo[i-1][j];
                } else {
                    memo[i][j] = memo[i-1][j] + memo[i][j-i];
                }
            }

        }

        return memo[changes.length][amount];
    }
}
