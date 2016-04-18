package com.algo.strings;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class Power2Test {
    public int power(String a) {
        int starting = 0;
        int previous = 0;
        while (a.length() > 1) {
            String newString = "";
            int i = 0;
            while (i < a.length()) {
                int value = Integer.valueOf(String.valueOf(a.charAt(i)));
                value = 10 * previous + value;
                if (value == 0) {
                    newString = newString + '0';
                    i++;
                    continue;
                } else if (value == 1) {
                    if ((i + 1) < a.length()) {
                        value = Integer.valueOf(a.substring(i, i + 2));
                        if(!newString.equals("")) {
                            newString += "0";
                        }
                        newString += (value / 2);
                        previous = value % 2;
                        i += 2;
                    } else {
                        return 0;
                    }
                } else {
                    newString += (value / 2);
                    previous = value % 2;
                    i++;
                }
            }
            a = newString;
            if (Integer.valueOf(String.valueOf(a.charAt(a.length() - 1))) % 2 == 1) {
                return 0;
            }
        }
        int i = Integer.valueOf(String.valueOf(a.charAt(a.length() - 1)));
        return i == 2 || i == 4 || i == 8 ? 1 : 0;
    }

    @Test
    public void shouldCheckPowerOf2() {
        assertThat(power("64"), is(1));
        assertThat(power("32"), is(1));
        assertThat(power("1"), is(0));
        assertThat(power("8"), is(1));
        assertThat(power("6"), is(0));
        assertThat(power("255"), is(0));
        assertThat(power("256"), is(1));
        assertThat(power("8192"), is(1));
        assertThat(power("32768"), is(1));
        assertThat(power("65536"), is(1));
        assertThat(power("65535"), is(0));
        assertThat(power("10000000000000000000000000000000000"), is(0));
        assertThat(power("10000000000000000000000000000000000"), is(0));
    }
}
