package com.antesh.dsa.arrays;

/*  You are given an array of 0s and 1s in random order. Segregate 0s on left side and 1s on right side of the array
    [Basically you have to sort the array].
    Traverse array only once.
    Input array   =  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0]
    Output array =  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]

    TC: O(n)
* */

import java.util.Arrays;

public class SortZeroAndOnesArrayProblem {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortZeroAndOnes(new int[]{0, 1, 0, 1, 0, 0, 1, 1, 1, 0})));
        System.out.println(Arrays.toString(sortZeroAndOnes(new int[]{1, 0, 1, 0, 0, 1, 1, 1, 1})));
    }

    private static int[] sortZeroAndOnes(int[] input) {
        int n = input.length;;
        int start = 0;
        int end = n-1;

        //{1, 0, 1}
        while (start < end) {
            if (input[start] == 1) {
                input[end] = input[end] + input[start];   //1+1  = 2    //0+1 = 1
                input[start] = input[end] - input[start]; //2-1 = 1     //1-0 = 0
                input[end] = input[end] - input[start];   //2-1 = 1     //1-0 = 1
                end--;
            } else  {
                start++;
            }
        }
        return input;
    }
}
