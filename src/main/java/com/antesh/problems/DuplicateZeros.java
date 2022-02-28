package com.antesh.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a fixed-length integer array arr,
 * duplicate each occurrence of zero, shifting the remaining elements to the
 * right.
 * <p>
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to:
 * [1,0,0,2,3,0,0,4]
 */
public class DuplicateZeros {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(duplicateZerosOptimizedSC(new int[]{1, 0, 2, 3, 0, 4, 5, 0})));
        System.out.println(Arrays.toString(duplicateZerosOptimizedTC(new int[]{1, 0, 2, 3, 0, 4, 5, 0})));
    }

    //TC: O(n) but SC: O(n)
    private static int[] duplicateZerosOptimizedTC(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        List<Integer> memo = new ArrayList<>();

        for (int num : arr) {
            if (num == 0) {
                if (memo.size() < arr.length) memo.add(num);
                if (memo.size() < arr.length) memo.add(num);
            } else {
                if (memo.size() < arr.length) memo.add(num);
            }
        }

        return memo.stream().mapToInt(Integer::intValue).toArray();
    }

    //TC: O(n*n) but SC: O(1)
    private static int[] duplicateZerosOptimizedSC(int[] arr) {

        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        for (int start = 0; start < arr.length; start++) {
            if (arr[start] == 0) {
                shiftToRight(arr, start);
                start++;
            }
        }

        return arr;
    }

    private static void shiftToRight(int[] arr, int start) {
        for (int end = arr.length - 1; end > start; end--) {
            arr[end] = arr[end - 1];
        }
    }
}
