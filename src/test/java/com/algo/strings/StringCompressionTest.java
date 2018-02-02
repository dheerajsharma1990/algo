package com.algo.strings;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StringCompressionTest {

    private int compress(char[] chars) {
        int k = 0;
        for (int i = 0; i < chars.length; ) {
            int j = i;
            char x = chars[j];
            while (i < chars.length && chars[j] == chars[i]) {
                i++;
            }
            int count = i - j == 1 ? 0 : i - j;
            int length = getLength(count);
            int index = length;
            while (count != 0) {
                int num = count % 10;
                count = count / 10;
                chars[k + index] = (char) (48 + num);
                index--;
            }
            chars[k] = x;
            k = k + length + 1;
        }
        if (k < chars.length) {
            chars[k] = '\0';
        }
        return k;
    }

    private int getLength(int count) {
        int length = 0;
        for (int x = 1; count >= x; x *= 10) {
            length++;
        }
        return length;
    }

    @Test
    public void shouldCompressString() {
        //given
        char[] string = new char[]{'a', 'a', 'b', 'b'};

        //then
        assertThat(compress(string), is(4));
        assertThat(new String(string), is("a2b2"));
    }

    @Test
    public void shouldCompressSingleChar() {
        //given
        char[] string = new char[]{'a'};

        //then
        assertThat(compress(string), is(1));
        assertThat(new String(string), is("a"));
    }

    @Test
    public void shouldCompressSingleCharString() {
        //given
        char[] string = new char[]{'a', 'a', 'a'};

        //then
        int compress = compress(string);
        assertThat(compress, is(2));
        assertThat(new String(string).substring(0, compress), is("a3"));
    }

    @Test
    public void shouldCompressMultipleCharString() {
        //given
        char[] string = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};

        //then
        int compress = compress(string);
        assertThat(compress, is(4));
        assertThat(new String(string).substring(0, compress), is("ab12"));
    }

    @Test
    public void shouldCompressMultipleCharStringSingleAppearance() {
        //given
        char[] string = new char[]{'a', 'b'};

        //then
        int compress = compress(string);
        assertThat(compress, is(2));
        assertThat(new String(string).substring(0, compress), is("ab"));
    }

    @Test
    public void shouldCompressMultipleCharStringThreeCharacters() {
        //given
        char[] string = new char[]{'a', 'a', 'b', 'b', 'b', 'c'};

        //then
        int compress = compress(string);
        assertThat(compress, is(5));
        assertThat(new String(string).substring(0, compress), is("a2b3c"));
    }

    @Test
    public void shouldCompressMultipleCharStringThreeCharacters1() {
        //given
        char[] string = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};

        //then
        int compress = compress(string);
        assertThat(compress, is(6));
        assertThat(new String(string).substring(0, compress), is("a3b2a2"));
    }
}
