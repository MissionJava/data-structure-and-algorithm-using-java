package com.antesh.dsa.dp;

public class MinimumJumpsToReachEndOfArrayProblem {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 6, 1, 0, 9 };
        int n = arr.length;

        System.out.println("Minimum jumps to reach end of the array is: " + minJumps(arr, n));
    }

    public static int minJumps(int[] arr, int n) {

        int[] jumps = new int[n];

        if (n == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }

        jumps[0] = 0;

        for (int i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }

        return jumps[n-1];
    }
}
