package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MedianFinderTest {

    class MedianFinder {
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer first, Integer second) {
                return second - first;
            }
        });

        public void addNum(int num) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
            if (minHeap.size() + 1 == maxHeap.size()) {
                return (double) maxHeap.peek();
            }
            return (double) minHeap.peek();
        }

    }


    @Test
    public void shouldGetMedian() {
        //given
        MedianFinder medianFinder = new MedianFinder();

        //then
        medianFinder.addNum(1);
        assertThat(medianFinder.findMedian(), is(1d));
        medianFinder.addNum(-1);
        assertThat(medianFinder.findMedian(), is(0d));
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian(), is(1d));
    }

    @Test
    public void shouldGetMedianFor2And3() {
        //given
        MedianFinder medianFinder = new MedianFinder();

        //then
        medianFinder.addNum(2);
        assertThat(medianFinder.findMedian(), is(2.00000));
        medianFinder.addNum(3);
        assertThat(medianFinder.findMedian(), is(2.50000));
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 2;
        double c = (double) ((a + b) / 2);
        System.out.println();
    }
}
