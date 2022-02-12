package com.antesh.agoda;

/*
*   Suppose we
    have a rod of length 5, which can be cut into smaller pieces of integer lengths 1, 2, 3, or 4. These smaller rods
    can then be further cut into smaller pieces. We stress that the rod pieces can only be cut into pieces of integer
    length; so pieces of size 1/2 or π are not considered in this problem. Now suppose that we can sell rods of
    length 1 for $1, which we denote p1 = 1. Similarly, suppose that the prices for rods of length 2, . . . , 5 are given
    by p2 = 4, p3 = 7, p4 = 8, and p5 = 9 respectively. We make two key assumptions: we will sell all the smaller
    rods, regardless of the cuts; and that each cut is free. Under these assumptions, how should the rod be cut to
    maximize the profit? We note the following cuts and the corresponding profits.
    - If the rod is cut into five pieces of length 1, we stand to make 5 · p1 = $5.
    - If the rod is cut into one piece of length 2 and one piece of length 3, we stand to make p2+p3 = 4+7 = $11.
    -If the rod is cut into two pieces of length 2 and one piece of length 1, we stand to make 2 · p2 + p1 =
    8 + 1 = $9.
    Out of the above options, cutting the rod into one piece of length 2 and one rod of length 3 is the most
    profitable. Of course, there are other possible cuts not listed above, such as cutting the rod into one piece
    of length 1 and one piece of length 4. The goal is to determine the most profitable cut. The Rod-Cutting
    Problem is formalized as follows.
    Definition 1 (Rod-Cutting Problem).
    - Instance: Let n ∈ N be the length of the rod, and let p1, p2, . . . , pn be non-negative real numbers. Here,
    pi
    is the price of a length i rod.
    - Solution: The maximum revenue, which we denote rn, obtained by cutting the rod into smaller pieces
    of integer lengths and selling the smaller rods

* Example:
* For input N =  4, v[i] = {0, 2, 4, 7, 7}
* Output: 2 (cuts of length 1 and 3 gives revenue of 2 + 7 = 9)
*  Explanation:
    In below price by rod length array,
    price 0 at index i=0 is for if rod length: 0,
    price 2 at index i = 1 is for rod length 1
    price 4 at index i = 2 is for rod length 2
    price 7 at index i = 3 is for rod length 3
    price 7 at index i = 4 is for rod length 4
    so on can be extended...

    Input:
     int[] prices = { 2, 4, 7, 7};
     int rod_size = 4;
    Output:
     9
* */
public class MaximumRevenueFromRodCuttingProblem {

    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{2, 4, 7, 7}));
        System.out.println(solution(8, new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(solution(8, new int[]{3, 5, 8, 9, 10, 17, 17, 20}));

    }

    private static int solution(int rod_size, int[] prices) {

        int max_profit = Integer.MIN_VALUE;
        int profit = 0;

        if (rod_size == 1) {
            return prices[0];
        }

        for (int i = rod_size - 1; i >= 0; i--) {
            profit = profit + prices[i];
            int remain = rod_size - i - 1;

            if (remain > 0) {
                profit = profit + solution(remain, prices);
            }
            max_profit = Math.max(max_profit, profit);
            profit = 0;
        }

        return max_profit;
    }

}
