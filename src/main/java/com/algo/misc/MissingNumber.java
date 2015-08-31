package com.algo.misc;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = (length * (length + 1)) / 2;
        int numberSum = 0;
        for (int n : nums) {
            numberSum += n;
        }
        return sum - numberSum;
    }
}
