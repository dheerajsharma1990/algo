package com.algo.misc;

public class BadVersionTest {

    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    private int firstBadVersion(int start, int end) {
        if (start == end || (start + 1) == end) {
            return isBadVersion(start) ? start : end;
        } else {
            int mid = start + ((end - start) / 2);
            if (isBadVersion(mid)) {
                return firstBadVersion(start, mid);
            } else {
                return firstBadVersion(mid, end);
            }
        }
    }

    private boolean isBadVersion(int n) {
        return n > 0;
    }

}
