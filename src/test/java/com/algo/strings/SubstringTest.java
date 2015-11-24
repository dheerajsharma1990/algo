package com.algo.strings;

import org.testng.annotations.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubstringTest {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        if (b.size()==0 || a.length()==0)
            return null;

        ArrayList<Integer> solution = new ArrayList<Integer>();

        //Preprocess the words into the map
        HashMap<String,ArrayList<Integer>> map = new HashMap<String,ArrayList<Integer>>();
        for(int i=0; i<b.size(); i++)
        {
            if(map.containsKey(b.get(i)))
            {
                ArrayList<Integer> temp = map.get(b.get(i));
                temp.add(i);
            }
            else
            {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(b.get(i), temp);
            }
        }

        int size = b.get(0).length();
        //the windows advance by size, so have to repeat it size times to obtain all the possible windows
        for(int i=0; i<size; i++)
        {
            int found[]=new int[b.size()];
            int wordsFound=0;
            for(int j=0; j<(a.length()-i)/size; j++)
            {
                //Remove the word that goes out of the window
                if(j>=b.size())
                {
                    String temp = a.substring((j-b.size())*size+i,i+(j-b.size())*size+size);
                    if(map.containsKey(temp))
                    {
                        if(found[map.get(temp).get(0)]--<=map.get(temp).size())
                            wordsFound--;
                    }
                }

                //Adding the new word to the window
                String temp = a.substring(j*size+i,i+j*size+size);
                if(map.containsKey(temp))
                {
                    if(found[map.get(temp).get(0)]++ < map.get(temp).size())
                        wordsFound++;
                }

                //Check if the window has all the words
                if(wordsFound==b.size())
                    solution.add((j-b.size()+1)*size+i);
            }
        }
        return solution;
    }

    @Test
    public void shouldReturnCorrectIndexesOfSubString() {
        assertThat(findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")).size(), is(2));
        assertThat(findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")).get(0), is(0));
        assertThat(findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar")).get(1), is(9));
    }

    @Test
    public void shouldReturnCorrectIndexesOfSubStringWithDuplicates() {
        assertThat(findSubstring("bar", Arrays.asList("bar")).size(), is(1));
        assertThat(findSubstring("bar", Arrays.asList("bar")).get(0), is(0));
        assertThat(findSubstring("barbar", Arrays.asList("bar", "bar")).size(), is(1));
        assertThat(findSubstring("barbar", Arrays.asList("bar", "bar")).get(0), is(0));
        assertThat(findSubstring("barbar", Arrays.asList("barbar")).size(), is(1));
        assertThat(findSubstring("barbar", Arrays.asList("barbar")).get(0), is(0));
        assertThat(findSubstring("barbar", Arrays.asList("barbara")).size(), is(0));
        assertThat(findSubstring("barbarbarbar", Arrays.asList("bar")).size(), is(4));
        assertThat(findSubstring("barbarbarbar", Arrays.asList("bar")), hasItems(0, 3, 6, 9));
        assertThat(findSubstring("barfoobarfoo", Arrays.asList("bar", "foo")), hasItems(0, 3, 6));
    }
}
