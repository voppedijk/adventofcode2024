package day04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day4Test {

    private static final Day4 DAY4 = new Day4();

    @Test
    void canConvertListToMap() {
        Map<String, String> expected = new HashMap<>();
        expected.put("x0y0", ".");
        expected.put("x1y0", ".");
        expected.put("x2y0", "X");
        expected.put("x3y0", ".");
        expected.put("x4y0", ".");
        expected.put("x5y0", ".");
        expected.put("x0y1", ".");
        expected.put("x1y1", "S");
        expected.put("x2y1", "A");
        expected.put("x3y1", "M");
        expected.put("x4y1", "X");
        expected.put("x5y1", ".");
        List<String> input = List.of(
                "..X...",
                ".SAMX.");

        assertEquals(expected, DAY4.convertListToMap(input));
    }

}
