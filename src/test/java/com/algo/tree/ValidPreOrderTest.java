package com.algo.tree;

import org.testng.annotations.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ValidPreOrderTest {
    public boolean isValidSerialization(String preorder) {
        if (preorder.equals("#")) {
            return true;
        }
        Stack<String> characterStack = new Stack<>();
        Stack<Boolean> visited = new Stack<>();
        String[] splits = preorder.split(",");
        for (int i = 0; i < splits.length; i++) {
            String string = splits[i];
            if (!string.equals("#")) {
                characterStack.push(string);
                visited.push(false);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                } else {
                    if (visited.peek().equals(true)) {
                        while (!characterStack.empty() && visited.peek()) {
                            characterStack.pop();
                            visited.pop();
                        }
                        if (characterStack.empty() && i < (splits.length - 1)) {
                            return false;
                        }
                        if (!characterStack.empty()) {
                            visited.pop();
                            visited.push(true);
                        }
                    } else {
                        visited.pop();
                        visited.push(true);
                    }
                }
            }
        }
        return characterStack.empty();
    }

    @Test
    public void shouldTestVariousScenarios() {
        assertThat(isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"), is(false));
        assertThat(isValidSerialization("#"), is(true));
        assertThat(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"), is(true));
        assertThat(isValidSerialization("1,#"), is(false));
        assertThat(isValidSerialization("9,#,#,1"), is(false));
        assertThat(isValidSerialization("9,#,#"), is(true));
        assertThat(isValidSerialization("9,1,#,#,#"), is(true));
        assertThat(isValidSerialization("#,#"), is(false));
        assertThat(isValidSerialization("#,#,1"), is(false));
        assertThat(isValidSerialization("2,3,4,#,#,#"), is(false));
        assertThat(isValidSerialization("2,3,4,#,#,#,#"), is(true));
        assertThat(isValidSerialization("2,3,4,#,#,#,1,#"), is(false));
        assertThat(isValidSerialization("2,3,4,#,#,#,1,#,#"), is(true));
    }

}
