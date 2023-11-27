package com.example.laatutestitapaukset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MainTest {

    @ParameterizedTest(name = "Test {index}: {0} -> {1}")
    @CsvSource({
            "00:00:00, 0",      // Lower bound
            "00:00:01, 1",      // One second
            "00:01:00, 60",     // One minute
            "00:01:01, 61",     // One minute and one second
            "01:00:00, 3600",   // One hour
            "01:00:01, 3601",   // One hour and one second
            "01:01:00, 3660",   // One hour and one minute
            "01:01:01, 3661",   // One hour, one minute and one second
            "10:10:10, 36610",  // Ten hours, ten minutes and ten seconds
            "23:59:59, 86399",  // Upper bound
            "01:00:00:00, 3600" // Upper bound + 1
    })
    public void testTimeToSec(String time, int expected) {
        int actual = TimeUtils.timeToSec(time);
        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "Test {index}: {0} -> {1}")
    @CsvSource({
            "-1, -1",           // Lower bound - 1
            "0, 0:00:00",      // Lower bound
            "1, 0:00:01",      // One second
            "60, 0:01:00",     // One minute
            "61, 0:01:01",     // One minute and one second
            "3600, 1:00:00",   // One hour
            "3601, 1:00:01",   // One hour and one second
            "3660, 1:01:00",   // One hour and one minute
            "3661, 1:01:01",   // One hour, one minute and one second
            "31999, 8:53:19",  // Old upper bound - 1
            "32000, 8:53:20",  // Old upper bound
            "86399, 23:59:59",  // Upper bound - 1
            "86400, -1",  // Upper bound
    })
    public void testSecToTime(int sec, String expected) {
        String actual = TimeUtils.secToTime(sec);
        assertEquals(expected, actual);
    }

}