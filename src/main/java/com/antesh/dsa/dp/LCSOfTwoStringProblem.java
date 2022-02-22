package com.antesh.dsa.dp;

public class LCSOfTwoStringProblem {

    //TC: O(m*n) SC: O(m*n)
    public static int lcs(char[] x, char[] y, int m, int n) {
        int[][] memo = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0;
                } else if (x[i-1] == y[j-1]) {
                    memo[i][j] = 1 + memo[i-1][j-1];
                } else {
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }

        return memo[m][n];
    }

    //Using recursion: TC: O(2^N)
    public static int lcsRecursion( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcsRecursion(X, Y, m-1, n-1);
        else
            return max(lcsRecursion(X, Y, m, n-1), lcsRecursion(X, Y, m-1, n));
    }

    /* Utility function to get max of 2 integers */
    static int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();

        int m = x.length;
        int n = y.length;

        System.out.println("LCS length: " + lcs(x,y, m, n));
        System.out.println("Using recursion LCS length: " + lcsRecursion(x,y, m, n));
    }
}
