package com.antesh.dsa.dp;

/*
* Given n friends, each one can remain single or can be paired up with some other friend. Each friend can be paired
* only once. Find out the total number of ways in which friends can remain single or can be paired up.
* Examples:

    Input  : n = 3
    Output : 4
    Explanation:
        {1}, {2}, {3} : all single
        {1}, {2, 3} : 2 and 3 paired but 1 is single.
        {1, 2}, {3} : 1 and 2 are paired but 3 is single.
        {1, 3}, {2} : 1 and 3 are paired but 2 is single.
        Note that {1, 2} and {2, 1} are considered same.

* Mathematical Explanation:
    The problem is simplified version of how many ways we can divide n elements into multiple groups.
    (here group size will be max of 2 elements).
    In case of n = 3, we have only 2 ways to make a group:
        1) all elements are individual(1,1,1)
        2) a pair and individual (2,1)
    In case of n = 4, we have 3 ways to form a group:
        1) all elements are individual (1,1,1,1)
        2) 2 individuals and one pair (2,1,1)
        3) 2 separate pairs (2,2)

 *
 * For n-th person there are two choices:
    1) n-th person remains single, we recur
    for f(n – 1)
    2) n-th person pairs up with any of the
    remaining n – 1 persons. We get (n – 1) * f(n – 2)

    Therefore, we can recursively write f(n) as:
    f(n) = f(n – 1) + (n – 1) * f(n – 2)

    Since the above recursive formula has overlapping sub-problems, we can solve it using Dynamic Programming.
 * */

import java.util.HashMap;
import java.util.Map;

public class FriendPairingProblemDP {

    //Returns count of ways n people can remain single or paired up
    //TC: O(n), SC: O(n)
    public static int countAllPossibleFriendPairsUsingMemoization(int n) {
        int[] memo = new int[n+1];

        for (int i = 0; i <=n; i++) {
            if (i <= 2) {
                memo[i] = i;
            } else {
                memo[i] = memo[i-1] + (i-1) * memo[i-2];
            }
        }
        return memo[n];
    }

    //Returns count of ways n people can remain single or paired up
    //TC: O(n), SC: O(n)
    public static int countPairRecursively(Integer n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        if (n <= 2) {
            return n;
        }
        memo.put(n, countPairRecursively(n-1, memo) + (n-1) * countPairRecursively(n-2, memo));

        return memo.get(n);
    }


    public static void main(String[] args) {
        int n = 0;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));

        n = 1;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));

        n = 2;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));

        n = 3;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));

        n = 4;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));

        n = 5;
        System.out.println("All possible pair of friends of group size n=" + n + " is " + countAllPossibleFriendPairsUsingMemoization(n));
        System.out.println("All possible pair of friends of group size n=" + n + " using recursion is " + countPairRecursively(n, new HashMap<Integer, Integer>()));
    }
}
