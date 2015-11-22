package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GrayCodeGenTest {
    public List<Integer> grayCode(int a) {
        List<Integer> answer = new ArrayList<>();
        BitSet bitSet = new BitSet(a);
        for (int i = 0; i < a; i++) {
            bitSet.clear(i);
        }
        addBinary(answer, a, bitSet, 0);
        return answer;
    }

    private void addBinary(List<Integer> answer, int a, BitSet temp, int i) {
        if (i == a) {
            int bitInteger = 0;
            for (int x = 0; x < a; x++) {
                bitInteger = bitInteger << 1;
                bitInteger |= temp.get(x) ? 1 : 0;
            }
            answer.add(bitInteger);
            return;
        }
        addBinary(answer, a, temp, i + 1);
        temp.flip(i);
        addBinary(answer, a, temp, i + 1);

    }

    @Test
    public void shouldGenerateGrayCode() {
        assertThat(grayCode(3).get(1), is(1));
        assertThat(grayCode(3).get(3), is(2));
        assertThat(grayCode(1).get(0), is(0));
        assertThat(grayCode(1).get(1), is(1));
        assertThat(grayCode(2).get(0), is(0));
        assertThat(grayCode(2).get(1), is(1));
        assertThat(grayCode(2).get(2), is(3));
        assertThat(grayCode(2).get(3), is(2));


    }
}
