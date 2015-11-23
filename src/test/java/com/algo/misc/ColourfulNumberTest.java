package com.algo.misc;

import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColourfulNumberTest {
    public int colorful(int a) {
        Set<Long> products = new HashSet<>();
        String string = String.valueOf(a);
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                String str = string.substring(i, j + 1);
                long mul = 1;
                for (int k = 0; k < str.length(); k++) {
                    mul = mul * Long.valueOf(String.valueOf(str.charAt(k)));
            }
                if (products.contains(mul)) {
                    return 0;
                } else {
                    products.add(mul);
                }
            }
        }
        return 1;
    }

    @Test
    public void shouldReturn1ForColourfulNumber() {
        assertThat(colorful(3245), is(1));
    }


    @Test
    public void shouldReturn0ForNonColourfulNumber() {
        assertThat(colorful(123), is(0));
    }

}
