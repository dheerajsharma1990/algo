package com.algo.misc;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CodecTest {

    private Map<String, String> map = new HashMap<>();


    public String encode(String longUrl) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 62);
            if (randomNum < 10) {
                builder.append(randomNum);
            } else if (randomNum < 36) {
                builder.append(Character.toString((char) (97 + (randomNum - 10))));
            } else {
                builder.append(Character.toString((char) (65 + (randomNum - 36))));
            }
        }
        String ans = "http://tinyurl.com/" + builder.toString();
        map.put(ans, longUrl);
        return ans;
    }


    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }



    @Test
    public void shouldCodeDecodeUrl() {
        String code = encode("https://leetcode.com/problems/design-tinyurl");
        String decode = decode(code);
        assertThat(decode, is("https://leetcode.com/problems/design-tinyurl"));
    }

}
