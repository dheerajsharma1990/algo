package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ReplaceWordTest {

    private String replaceWords(List<String> dict, String sentence) {
        Set<String> set = new HashSet<>(dict);
        StringBuilder builder = new StringBuilder();
        for (String word : sentence.split(" ")) {
            boolean wordAdded = false;
            StringBuilder stringBuilder = new StringBuilder();
            for (char ch : word.toCharArray()) {
                String s = stringBuilder.append(ch).toString();
                if (set.contains(s)) {
                    if (builder.length() == 0) {
                        builder.append(s);
                    } else {
                        builder.append(" ").append(s);
                    }
                    wordAdded = true;
                    break;
                }
            }
            if (!wordAdded) {
                if (builder.length() == 0) {
                    builder.append(word);
                } else {
                    builder.append(" ").append(word);
                }
            }
        }
        return builder.toString();
    }

    @Test
    public void shouldGetMaxProductLength() {
        assertThat(replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"), is("the cat was rat by the bat"));
        assertThat(replaceWords(Arrays.asList("a"), "and po"), is("a po"));
        assertThat(replaceWords(Arrays.asList("and", "po"), "and po"), is("and po"));
        assertThat(replaceWords(Arrays.asList("and", "an", "p", "po"), "and po"), is("an p"));
        assertThat(replaceWords(Arrays.asList("and", "p", "po"), "and"), is("and"));
    }
}
