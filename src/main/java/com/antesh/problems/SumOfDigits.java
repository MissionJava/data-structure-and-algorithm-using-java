package com.antesh.problems;

public class SumOfDigits {

    public static void main(String[] args) {
        int number = 1234;
        System.out.println("sum of digits of " + number + " is " + sumOfDigits(number));
        System.out.println("sum of digits of " + number + " is " + sumInOofOneTime(number));
    }

    //O(n)
    private static int sumOfDigits(int number) {
        if (number == 0) return 0;
        int sum = 0;
        while (number > 0 || sum > 9) {
            if (number == 0) {
                number = sum;
                sum = 0;
            }

            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    public static int sumInOofOneTime(int number) {
        if (number == 0) return 0;

        return number % 9 == 0 ? 9 : number % 9;
    }

}
