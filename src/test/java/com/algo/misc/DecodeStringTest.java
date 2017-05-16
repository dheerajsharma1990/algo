package com.algo.misc;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DecodeStringTest {

    private String decodeString(String s) {
        String p = "1[" + s + "]";
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i = 2;
        numberStack.push(1);
        stringStack.push("[");
        while (i < p.length()) {
            if (p.charAt(i) >= '0' && p.charAt(i) <= '9') {
                int index = p.indexOf('[', i);
                int num = Integer.valueOf(p.substring(i, index));
                numberStack.push(num);
                stringStack.push("[");
                i = index + 1;
            } else if (p.charAt(i) == ']') {
                int times = numberStack.pop();
                String x = "";
                String pop = "";
                while (!(pop = stringStack.pop()).equals("[")) {
                    x = pop + x;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int t = 0; t < times; t++) {
                    stringBuilder.append(x);
                }
                stringStack.push(stringBuilder.toString());
                i++;
            } else {
                while (p.charAt(i) != ']' && !(p.charAt(i) >= '0' && p.charAt(i) <= '9')) {
                    stringStack.push(String.valueOf(p.charAt(i)));
                    i++;
                }
            }
        }
        return stringStack.pop();
    }

    @Test
    public void shouldDecode() {
        assertThat(decodeString("2[ab]"), is("abab"));
        assertThat(decodeString("3[a2[c]]"), is("accaccacc"));
        assertThat(decodeString("2[abc]3[cd]ef"), is("abcabccdcdcdef"));
        assertThat(decodeString("3[a]2[bc]"), is("aaabcbc"));
        assertThat(decodeString("2[a12[b]]"), is("abbbbbbbbbbbbabbbbbbbbbbbb"));
        assertThat(decodeString("ab"), is("ab"));
        assertThat(decodeString("10[ab]"), is("abababababababababab"));
    }
}
