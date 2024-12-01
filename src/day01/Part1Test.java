package day01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Part1Test {

    @Test
    void canCreateSeperateSortedListForFirstPart() {
        List<String> inputLst = new ArrayList<>();
        inputLst.add("87501   76559");
        inputLst.add("70867   16862");
        inputLst.add("12959   38527");
        List<Long> result = List.of(12959L, 70867L, 87501L);

        Part1 p1 = new Part1();
        List<Long> part1List = p1.createSeperateList(true, inputLst);

        assertEquals(result, part1List);
    }

    @Test
    void canCreateSeperateSortedListForSecondPart() {
        List<String> inputLst = new ArrayList<>();
        inputLst.add("87501   76559");
        inputLst.add("70867   16862");
        inputLst.add("12959   38527");
        List<Long> result = List.of(16862L, 38527L, 76559L);

        Part1 p1 = new Part1();
        List<Long> part1List = p1.createSeperateList(false, inputLst);

        assertEquals(result, part1List);
    }

    @Test
    void canCalculateTwoLists() {
        List<Long> lst1 = List.of(1L, 2L, 2L);
        List<Long> lst2 = List.of(4L, 5L, 6L);

        Part1 p1 = new Part1();
        Long result = p1.calculate(lst1, lst2);

        assertEquals(10L, result);
    }

    @Test
    void canCalculateTwoLists2() {
        List<Long> lst2 = List.of(1L, 2L, 2L);
        List<Long> lst1 = List.of(4L, 5L, 6L);

        Part1 p1 = new Part1();
        Long result = p1.calculate(lst1, lst2);

        assertEquals(10L, result);
    }

    @Test
    void canCalculateTwoLists3() {
        List<Long> lst2 = List.of(1L, 5L, 2L);
        List<Long> lst1 = List.of(4L, 2L, 6L);

        Part1 p1 = new Part1();
        Long result = p1.calculate(lst1, lst2);

        assertEquals(10L, result);
    }

    @Test
    void canCalculatePart2() {
        List<Long> lst2 = List.of(1L, 5L, 7L);
        List<Long> lst1 = List.of(5L, 5L, 7L);

        Part1 p1 = new Part1();
        Long result = p1.calculatePart2(lst1, lst2);

        assertEquals(17L, result);
    }
}
