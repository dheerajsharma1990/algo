package com.algo.misc;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {

    public boolean isUgly(int num) {
        while (num != 0 && num % 2 == 0) {
            num = num / 2;
        }

        while (num != 0 && num % 3 == 0) {
            num = num / 3;
        }

        while (num != 0 && num % 5 == 0) {
            num = num / 5;
        }

        return num == 1;
    }

    public List<Integer> uglyNumbers(int start, int end) {
        List<Integer> uglyNumbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isUgly(i)) {
                uglyNumbers.add(i);
            }
        }
        return uglyNumbers;
    }

}
