package com.algo.arrays;

import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FizzBuzzTest {

    private List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1)
                .mapToObj(i -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "FizzBuzz";
                    }
                    if (i % 3 == 0) {
                        return "Fizz";
                    }
                    if (i % 5 == 0) {
                        return "Buzz";
                    }
                    return String.valueOf(i);
                }).collect(Collectors.toList());
    }

    @Test
    public void shouldTestFizzBuzz() {
        assertThat(fizzBuzz(5).size(), is(5));
        assertThat(fizzBuzz(5).get(2), is("Fizz"));
        assertThat(fizzBuzz(5).get(4), is("Buzz"));
    }
}
