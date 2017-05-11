package com.algo.misc;

public class GuessNumberTest {

    private int guess(int x) {
        return 0;
    }

    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    public int guessNumber(int first, int last) {
        int num = first + (last - first) / 2;
        int ans = guess(num);
        if (ans == 0) {
            return num;
        } else if (ans < 0) {
            return guessNumber(first, num - 1);
        } else {
            return guessNumber(num + 1, last);
        }
    }
}
