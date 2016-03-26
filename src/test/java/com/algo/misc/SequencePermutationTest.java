package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SequencePermutationTest {

    private List<String> permute(String string, int k) {
        List<String> ans = new ArrayList<>();
        permute(ans, new ArrayList<Character>(), string, 0, k);
        return ans;
    }


    private void permute(List<String> ans, List<Character> characters, String string, int i, int k) {
        if (k == 0) {
            ans.add(characters.toString());
            return;
        }

        for (int j = i; j < string.length(); j++) {
            characters.add(string.charAt(j));
            permute(ans, characters, string, j + 1, k - 1);
            characters.remove(characters.size() - 1);
        }
    }

    @Test
    public void shouldPermute() {
        //when
        List<String> ans = permute("abcd", 1);

        //then
        assertThat(ans.size(), is(4));
    }

}
