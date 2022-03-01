package com.antesh.problems;

import java.util.Arrays;

/*  Merge 2 sorted arrays and find median

    There are 2 sorted arrays A and B of size n each.
    Write an algorithm to find the median of the array
    obtained after merging the above 2 arrays(i.e. array of length 2n).

    int ar1[] = {1, 12, 15, 26, 38};
    int ar2[] = {2, 13, 17, 30, 45};
    Median is 16

    The complexity should be O(log(n)). for two equal length arrays
 */
public class MergeTwoSortedArraysAndFindMedianProblem {
    public static void main(String[] args) {
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 45};

        System.out.println("Median is " + mergeTwoSortedArrayAndFindMedian(arr1, 0, arr2, 0));

        int[] arr3 = {1, 12, 15, 26};
        int[] arr4 = {2, 13, 17, 30, 45};
        
        System.out.println("Median is " + mergeTwoSortedArrayAndFindMedian(arr3, 0, arr4, 0));

        //If we already have sorted array and need to find median
        System.out.println(findMedian(new int[]{1, 2, 12, 13, 15, 24, 26, 38}));
    }

    //TC: O(m+n)
    private static float mergeTwoSortedArrayAndFindMedian(int[] arr1, int m, int[] arr2, int n) {
        int[] sortedArrResult = new int[arr1.length + arr2.length];

        int start = 0;
        while (m < arr1.length) {
            if (arr1[m] < arr2[n]) {
                sortedArrResult[start++] = arr1[m];
                m++;
            } else {
                sortedArrResult[start++] = arr2[n];
                n++;
            }
        }

        while (n < arr2.length) {
            sortedArrResult[start++] = arr2[n++];
        }

        System.out.println(Arrays.toString(sortedArrResult));

        return findMedian(sortedArrResult);
    }

    private static float findMedian(int[] sortedArr) {
        if (sortedArr.length % 2 == 0) {
            int n1 = (sortedArr.length - 1) / 2;
            int n2 = sortedArr.length / 2;
            return (float) (sortedArr[n1] + sortedArr[n2]) / 2;
        }

        int n1 = (sortedArr.length - 1) / 2;
        int n2 = (sortedArr.length + 1) / 2;

        return (float) (sortedArr[n1] + sortedArr[n2]) / 2;
    }
}
