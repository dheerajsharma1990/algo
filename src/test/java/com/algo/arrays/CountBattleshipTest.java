package com.algo.arrays;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CountBattleshipTest {

    private int countBattleships(char[][] board) {
        int total = 0;
        for (int i = 0; i < board.length; i++) {
            int j = 0;
            while (j < board[i].length) {
                if (board[i][j] == 'X' && j + 1 < board[i].length && board[i][j + 1] == 'X') {
                    while (j < board[i].length && board[i][j] == 'X') {
                        j++;
                    }
                    total++;
                } else {
                    j++;
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            int i = 0;
            while (i < board.length) {
                if (board[i][j] == 'X' && i + 1 < board.length && board[i + 1][j] == 'X') {
                    while (i < board.length && board[i][j] == 'X') {
                        i++;
                    }
                    total++;
                } else {
                    i++;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X'
                        && ((i - 1) < 0 || (board[i - 1][j] == '.'))
                        && ((j - 1) < 0 || (board[i][j - 1] == '.'))
                        && ((i + 1) >= board.length || (board[i + 1][j] == '.'))
                        && ((j + 1) >= board[i].length || (board[i][j + 1] == '.'))) {
                    total++;
                }
            }
        }

        return total;
    }

    @Test
    public void shouldCountBattleShips() {
        //then
        assertThat(countBattleships(new char[][]{{'X', 'X', 'X'}, {'.', '.', '.'}, {'X', '.', '.'}}), is(2));
        assertThat(countBattleships(new char[][]{{'X'}}), is(1));
        assertThat(countBattleships(new char[][]{{'X', 'X', 'X'}}), is(1));
        assertThat(countBattleships(new char[][]{{'X', '.', 'X'}}), is(2));
        assertThat(countBattleships(new char[][]{{'X', '.', 'X'}, {'X', '.', 'X'}}), is(2));
    }
}
