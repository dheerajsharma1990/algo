package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class VersionCompareTest {

    public int compareVersion(String version1, String version2) {
        String first[] = version1.split("\\.");
        String second[] = version2.split("\\.");
        int i = 0;
        while (i < first.length && i < second.length) {
            int num1 = Integer.valueOf(first[i]);
            int num2 = Integer.valueOf(second[i]);
            if (num1 < num2) {
                return -1;
            }
            if (num1 > num2) {
                return 1;
            }
            i++;
        }
        if (first.length == second.length) {
            return 0;
        } else if (first.length == i) {
            while (i < second.length) {
                if (Integer.valueOf(second[i]) != 0) {
                    return -1;
                }
                i++;
            }
            return 0;
        } else {
            while (i < first.length) {
                if (Integer.valueOf(first[i]) != 0) {
                    return 1;
                }
                i++;
            }
            return 0;
        }
    }

    @Test
    public void shouldTestVariousScenarios() {
        //then
        assertThat(compareVersion("0.1", "1.1"), is(-1));
        assertThat(compareVersion("0.1", "0.1"), is(0));
        assertThat(compareVersion("1.1", "0.1"), is(1));

        assertThat(compareVersion("0.1.1", "0.1.2"), is(-1));
        assertThat(compareVersion("1.1", "0.1.9"), is(1));
        assertThat(compareVersion("1.1.1", "1.1.2"), is(-1));
        assertThat(compareVersion("1.1.2", "1.1.2.3"), is(-1));
        assertThat(compareVersion("1.1.3", "1.1.2.3"), is(1));
        assertThat(compareVersion("01", "1"), is(0));
        assertThat(compareVersion("01.01.12", "1.1.3"), is(1));
        assertThat(compareVersion("1.0.0", "1.0"), is(0));
    }

}
