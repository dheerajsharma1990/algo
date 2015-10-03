package com.algo.misc;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeMeasureTest {

    class TimeMeasure {
        public List<String> getAllValidAngles(String diffInString) {
            double hourAngle = -0.5;
            double minuteAngle = -6.0;
            int mul4Value;
            if (!diffInString.contains(".")) {
                mul4Value = Integer.valueOf(diffInString) * 30000;
            } else {
                String afterDot = diffInString.substring(diffInString.indexOf('.') + 1);
                if (afterDot.length() < 4) {
                    for (int i = 0; i < 4 - afterDot.length(); i++) {
                        afterDot = afterDot + "0";
                    }
                }
                mul4Value = Integer.valueOf(diffInString.substring(0, diffInString.indexOf('.')) + afterDot) * 3;
            }
            List<String> validAngles = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    minuteAngle += 6.0;
                    hourAngle += 0.5;
                    int first = (int) (Math.abs(hourAngle - minuteAngle) * 30000);
                    int second = (int) ((360 - Math.abs((hourAngle - minuteAngle))) * 30000);
                    if ((Math.abs(first - mul4Value) < 250) || (Math.abs(second - mul4Value) < 250)) {
                        validAngles.add(String.format("%02d:%02d", i, j));
                    }
                }
                minuteAngle = -6.0;
            }
            return validAngles;
        }
    }

    private final TimeMeasure timeMeasure = new TimeMeasure();

    @Test
    public void shouldReturnCorrectTimeForVariousScenarios() {
        //when
        List<String> allValidAngles = timeMeasure.getAllValidAngles("0");

        //then
        assertThat(allValidAngles.size(), is(1));
        assertThat(allValidAngles.get(0), is("00:00"));

        //when
        allValidAngles = timeMeasure.getAllValidAngles("30");

        //then
        assertThat(allValidAngles.size(), is(2));
        assertThat(allValidAngles.get(0), is("01:00"));
        assertThat(allValidAngles.get(1), is("11:00"));

        //then
        for (int i = 1; i <= 179; i++) {
            assertThat(timeMeasure.getAllValidAngles(String.valueOf(i)).size(), is(2));

        }
    }


}
