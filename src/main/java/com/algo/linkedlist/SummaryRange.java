package com.algo.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length != 0) {
            summaryRanges(0, 0, 1, nums, result);
        }
        return result;
    }

    private String createRange(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return String.valueOf(start) + "->" + String.valueOf(end);
    }

    private void summaryRanges(int startIndex, int previousIndex, int currentIndex, int[] numbers, List<String> result) {
        if (currentIndex >= numbers.length) {
            result.add(createRange(numbers[startIndex], numbers[previousIndex]));
        } else if (numbers[previousIndex] + 1 == numbers[currentIndex]) {
            summaryRanges(startIndex, currentIndex, currentIndex + 1, numbers, result);
        } else {
            result.add(createRange(numbers[startIndex], numbers[previousIndex]));
            summaryRanges(currentIndex, currentIndex, currentIndex + 1, numbers, result);
        }
    }

}
