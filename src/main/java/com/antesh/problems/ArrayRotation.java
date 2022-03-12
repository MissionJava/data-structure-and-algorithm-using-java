package com.antesh.problems;

import java.util.Arrays;

/*  Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements to right
*
*   Sample 1: { 1, 2, 3, 4, 5, 6, 7 }, d = 2, rotate right
*   output 1: { 6, 7, 1, 2, 3, 4, 5 }
*
*   Sample 1: { 1, 2, 3, 4, 5, 6, 7 }, d = 2, rotate left
*   output 1: { 3, 4, 5, 6, 7, 1, 2 }
 * */
public class ArrayRotation {

    //TC: O(n*d)
    public static void rotateRight(int[] arr, int d) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        int j = 0;
        while (j < d) {
            rotateByOnePosition(arr, n);
            j++;
        }
    }

    private static void rotateByOnePosition(int[] arr, int n) {
        int temp = arr[n - 1];
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            arr[i] = temp;
            temp = current;
        }
    }

    public static void rotateLeft(int[] arr, int d) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        rotateRight(arr, n-d);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rotateRight(arr, 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        rotateRight(arr1, 2);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        rotateLeft(arr2, 2);
        System.out.println(Arrays.toString(arr2));
    }
}
