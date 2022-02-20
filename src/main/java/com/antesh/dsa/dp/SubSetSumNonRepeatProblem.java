package com.antesh.dsa.dp;


/*
*   Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

    Example:

        Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
        Output: True
        There is a subset (4, 5) with sum 9.

        Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
        Output: False
        There is no subset that add up to 30. (We could have achieved 30 if repeated selections of same item was allowed ex. 6 times of 5)

        * Algorithm:
        * find remainder = target - ith item
        * recursively ignore current ith i.e. 0 <= i+1 < set length
        * check if remainder is zero then true else false
        *
    Method 1: Recursion.
        Approach: For the recursive approach we will consider two cases.

        Consider the last element and now the required sum = target sum – value of ‘last’ element and number of elements = total elements – 1
        Leave the ‘last’ element and now the required sum = target sum and number of elements = total elements – 1
        Following is the recursive formula for isSubsetSum() problem.

        isSubsetSum(set, n, sum)
        = isSubsetSum(set, n-1, sum) ||
          isSubsetSum(set, n-1, sum-set[n-1])
        Base Cases:
        isSubsetSum(set, n, sum) = false, if sum > 0 and n == 0
        isSubsetSum(set, n, sum) = true, if sum == 0
* */
public class SubSetSumNonRepeatProblem {

    //Traverse each number in set and calculate remainder = target - number, start i = 0
    //recursively call canSum(remainder, set, start + 1) if true the possible else not possible
    //n-times for loop and recursive worst case call target sum, let's input array size as n and target sum as m then
    //TC: O(n*m), SC: O(n*m)
    public static boolean canSum(int target, int[] set, int start) {

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        for (int i = start; i < set.length; i++) {
            int remainder = target - set[i];
            if (canSum(remainder, set, i+1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Can sum of target sum 9 in subset? " + canSum(9, new int[]{3, 34, 4, 12, 5, 2}, 0));
        System.out.println("Can sum of target sum 30 in subset? " + canSum(30, new int[]{3, 34, 4, 12, 5, 2}, 0));
    }
}
