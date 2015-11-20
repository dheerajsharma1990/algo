package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SetZeroTest {
    public void setZeroes(List<List<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    if (j == 0) {
                        if (i == 0) {
                            a.get(i).set(j, -3);
                        } else if (a.get(0).get(0) == -1) {
                            a.get(0).set(0, -3);
                            a.get(i).set(j, -1);
                        } else if (a.get(0).get(0) != -3) {
                            a.get(0).set(0, -2);
                            a.get(i).set(j, -1);
                        } else {
                            a.get(i).set(j, -1);
                        }

                    } else {
                        if (i != 0 || a.get(0).get(0) != -3) {
                            a.get(i).set(0, -1);
                        } else {

                        }
                        a.get(0).set(j, -1);
                    }
                }
            }
        }

        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).get(0) == -1) {
                for (int j = 0; j < a.get(i).size(); j++) {
                    a.get(i).set(j, 0);
                }
            }
        }

        for (int i = 1; i < a.get(0).size(); i++) {
            if (a.get(0).get(i) == -1) {
                for (int j = 0; j < a.size(); j++) {
                    a.get(j).set(i, 0);
                }
            }
        }

        if (a.get(0).get(0) == -1) {
            for (int j = 0; j < a.get(0).size(); j++) {
                a.get(0).set(j, 0);
            }
        } else if (a.get(0).get(0) == -2) {
            for (int j = 0; j < a.size(); j++) {
                a.get(j).set(0, 0);
            }
        } else if (a.get(0).get(0) == -3) {
            for (int j = 0; j < a.get(0).size(); j++) {
                a.get(0).set(j, 0);
            }
            for (int j = 0; j < a.size(); j++) {
                a.get(j).set(0, 0);
            }
        }
    }

    @Test
    public void shouldWorkCorrectlyForVariousScenarios() {
        //given
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 1, 1));
        matrix.add(Arrays.asList(1, 0, 1));
        matrix.add(Arrays.asList(1, 1, 1));

        //when
        setZeroes(matrix);

        //then
        assertThat(matrix.size(), is(3));
        assertThat(matrix.get(0), hasItems(1, 0, 1));
        assertThat(matrix.get(1), hasItems(0, 0, 0));
        assertThat(matrix.get(2), hasItems(1, 0, 1));

    }

    @Test
    public void shouldWorkCorrectlyForVariousScenariosBigArrage() {
        //given
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 1, 1, 0));
        matrix.add(Arrays.asList(1, 0, 1, 0));
        matrix.add(Arrays.asList(1, 1, 1, 0));

        //when
        setZeroes(matrix);

        //then
        assertThat(matrix.size(), is(3));
        assertThat(matrix.get(0), hasItems(0, 0, 0, 0));
        assertThat(matrix.get(1), hasItems(0, 0, 0, 0));
        assertThat(matrix.get(2), hasItems(0, 0, 0, 0));

    }

    @Test
    public void shouldWorkCorrectlyForVariousScenariosBeginZer0() {
        //given
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 1, 1));
        matrix.add(Arrays.asList(1, 0, 1));
        matrix.add(Arrays.asList(1, 1, 1));

        //when
        setZeroes(matrix);

        //then
        assertThat(matrix.size(), is(3));
        assertThat(matrix.get(0), hasItems(0, 0, 0));
        assertThat(matrix.get(1), hasItems(0, 0, 0));
        assertThat(matrix.get(2), hasItems(0, 0, 1));

    }

    @Test
    public void shouldWorkCorrectlyForVariousScenariosZeroBoundaries() {
        //given
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(0, 1, 1, 0));
        matrix.add(Arrays.asList(0, 0, 1, 1));
        matrix.add(Arrays.asList(1, 1, 1, 1));

        //when
        setZeroes(matrix);

        //then
        assertThat(matrix.size(), is(3));
        assertThat(matrix.get(0), hasItems(0, 0, 0, 0));
        assertThat(matrix.get(1), hasItems(0, 0, 0, 0));
        assertThat(matrix.get(2), hasItems(0, 0, 1, 0));

    }
}
