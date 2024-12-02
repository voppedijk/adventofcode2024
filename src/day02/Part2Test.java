package day02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Part2Test {
    @Test
    void canCheckIfIsIncreasing() {
        int[] input = {1, 2, 3, 4, 5};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isIncreasing(input));
    }

    @Test
    void canCheckIfIsDecreasing() {
        int[] input = {5, 4, 3, 2, 1};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isDecreasing(input));
    }

    @Test
    void canCheckIfNrDifferenceIsThreeOrLess() {
        int[] input = {50, 49, 46};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isDifferenceThreeOrLess(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved() {
        int[] input = {1, 2, 4, 4, 5};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isValidReportWhenOneDigitRemoved(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved2() {
        int[] input = {1, 2, 4, 9, 5};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isValidReportWhenOneDigitRemoved(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved3() {
        int[] input = {1, 2, 8, 4, 5};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isValidReportWhenOneDigitRemoved(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved4() {
        int[] input = {2, 2, 3, 4, 5};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isValidReportWhenOneDigitRemoved(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved5() {
        int[] input = {1, 2, 3, 4, 2};
        Part2 p = new Part2();

        Assertions.assertTrue(p.isValidReportWhenOneDigitRemoved(input));
    }

    @Test
    void canCheckIfReportIsValidWhenDigitRemoved6() {
        int[] input = {2, 2, 3, 3, 5};
        Part2 p = new Part2();

        Assertions.assertFalse(p.isValidReportWhenOneDigitRemoved(input));
    }

}
