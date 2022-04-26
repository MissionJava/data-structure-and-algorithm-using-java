package com.antesh.dsa.binarysearch;
/*
    Given an array of integers nums which is sorted in ascending order, and an integer target,
    write a function to search target in nums. If target exists, then return its index.
    Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
        Input: nums = [-1,0,3,5,9,12], target = 9
        Output: 4
        Explanation: 9 exists in nums and its index is 4
    Example 2:
        Input: nums = [-1,0,3,5,9,12], target = 2
        Output: -1
        Explanation: 2 does not exist in nums so return -1
*/

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArr = {10, 20, 30, 40, 50};

        System.out.println(binarySearch(sortedArr,0, sortedArr.length-1, 50));
        System.out.println(binarySearch(sortedArr,0, sortedArr.length-1, 60));
    }

    private static int binarySearch(int[] sortedArr, int low, int high, int target) {
        if (sortedArr.length == 0) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high -  low)/2;

            if (target == sortedArr[mid]) {
                return sortedArr[mid];
            } else if (target < sortedArr[mid]) {
                return binarySearch(sortedArr, low, mid-1, target);
            }
            return binarySearch(sortedArr, mid+1, high, target);
        }
        return -1;
    }

}
