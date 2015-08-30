package com.algo.misc;

import java.util.*;

public class SearchWord {

    private Map<Integer, Set<String>> strings = new HashMap<>();

    public void addWord(String word) {
        String newWord = word + "T";
        if (strings.containsKey(newWord.length())) {
            strings.get(newWord.length()).add(newWord);
        } else {
            Set<String> set = new HashSet<>();
            set.add(newWord);
            strings.put(newWord.length(), set);
        }
    }

    public boolean search(String word) {
        String suffixWord = word + "T";
        if (strings.containsKey(suffixWord.length())) {
            for (String string : strings.get(suffixWord.length())) {
                if (string.length() >= suffixWord.length()) {
                    boolean matched = true;
                    for (int i = 0; i < suffixWord.length(); i++) {
                        char ch = suffixWord.charAt(i);
                        if (ch != '.') {
                            if (string.charAt(i) != ch) {
                                matched = false;
                                break;
                            }
                        }
                    }
                    if (matched) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
