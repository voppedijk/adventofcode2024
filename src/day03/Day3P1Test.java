package day03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day3P1Test {

    @Test
    void canSplitStringsForMul() {
        Day3P1 d = new Day3P1();
        List<String> input = List.of("when()mul(73,623)when()mul(793,458)'~where()how()?how(569,237)/[mul(709,198)mul(395,622)$!what()select()^@/what()+mul(970,343)mul(75,7)^))mul(61,40)select");
        List<String> expected = List.of("when()", "(73,623)when()", "(793,458)'~where()how()?how(569,237)/[", "(709,198)", "(395,622)$!what()select()^@/what()+", "(970,343)", "(75,7)^))", "(61,40)select");
        List<String> result = d.getMulValues(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void canSplitStringsForMulWhenStartingWithMul() {
        Day3P1 d = new Day3P1();
        List<String> input = List.of("mul(213,399)mul(50,339)");
        List<String> expected = List.of("(213,399)", "(50,339)");
        List<String> result = d.getMulValues(input);

        Assertions.assertEquals(expected, result);
    }

    @Test
    void canCleanUpList() {
        Day3P1 d = new Day3P1();
        List<String> input = List.of("when()", "(73,623)when()", "(793,458)'~where()how()?how(569,237)/[", "(709,198)", "(709,198-)");
        List<String> expected = List.of("73,623", "793,458", "709,198");
        List<String> result = d.cleanUpLst(input);

        Assertions.assertEquals(expected, result);
    }
}
