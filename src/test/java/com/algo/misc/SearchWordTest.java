package com.algo.misc;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SearchWordTest {

    @Test
    public void shouldTest() {

    }

    @Test
    public void shouldSearchSingleWord() {
        //given
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("a");
        searchWord.addWord("ran");
        searchWord.addWord("rune");
        searchWord.addWord("runner");
        searchWord.addWord("runs");
        searchWord.addWord("add");
        searchWord.addWord("adds");
        searchWord.addWord("adder");
        searchWord.addWord("addee");
        searchWord.search("r.n");
        searchWord.search("ru.n.e");
        searchWord.search("add");
        searchWord.search("add.");
        searchWord.search("adde.");
        searchWord.search(".an.");
        searchWord.search("...s");
        searchWord.search("....e.");
        searchWord.search(".......");
        searchWord.search("..n.r");
        //then
        assertThat(searchWord.search("a"), is(true));
    }

    @Test
    public void shouldReturnTrueForAllDots() {
        //given
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("ab");

        //then
        assertThat(searchWord.search(".."), is(true));
    }

    @Test
    public void shouldReturnForNonMatchingDots() {
        //given
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("ab");

        //then
        assertThat(searchWord.search("..."), is(false));
    }

    @Test
    public void shouldReturnTrueForMatchingRegex() {
        //given
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("abcd");

        //then
        assertThat(searchWord.search("a.c."), is(true));
    }

    @Test
    public void shouldReturnFalseForMatchingRegex() {
        //given
        SearchWord searchWord = new SearchWord();
        searchWord.addWord("abcd");

        //then
        assertThat(searchWord.search("a.d."), is(false));
    }

}