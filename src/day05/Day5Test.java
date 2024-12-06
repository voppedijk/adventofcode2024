package day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Day5Test {
    private Day5 day5 = new Day5();

    @Test
    void canCheckValidSingleUpdateLine() {
        List<String> pageOrderingRules = List.of(
                "47|53",
                "97|13",
                "97|61",
                "97|47",
                "75|29",
                "61|13",
                "75|53",
                "29|13",
                "97|29",
                "53|29",
                "61|53",
                "97|53",
                "61|29",
                "47|13",
                "75|47",
                "97|75",
                "47|61",
                "75|61",
                "47|29",
                "75|13",
                "53|13"
        );
        String pageUpdate = "75,47,61,53,29";

        assertEquals(61, day5.isValidUpdate(pageOrderingRules, pageUpdate));
    }

    @Test
    void canCheckInvalidSingleUpdateLine() {
        List<String> pageOrderingRules = List.of(
                "47|53",
                "97|13",
                "97|61",
                "97|47",
                "75|29",
                "61|13",
                "75|53",
                "29|13",
                "97|29",
                "53|29",
                "61|53",
                "97|53",
                "61|29",
                "47|13",
                "75|47",
                "97|75",
                "47|61",
                "75|61",
                "47|29",
                "75|13",
                "53|13"
        );
        String pageUpdate = "47,75,61,53,29";

        assertEquals(0, day5.isValidUpdate(pageOrderingRules, pageUpdate));
    }

    @Test
    void canFixRules() {
        List<String> broken = List.of("85,55,32,19,12"
                , "71,52,34,31,94,16,24,58,53,55,87,41,23,28,96,84,13,32,85,29,42,97,57"
        );

        List<String> result = List.of("55,85,32,19,12"
                , "55,85,32,19,12, 23,41,55,16,97,34,84,94,53,71,85,52,32,24,13,96,58,87,57,42,28,29,31");

        assertEquals(result, day5.fixInvalidList(broken));
    }

}
