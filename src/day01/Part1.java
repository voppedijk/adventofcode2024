package day01;

import util.FileProcessor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 {
    List<String> input = FileProcessor.textFileToList("%s.txt".formatted("d01"));
    
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        List<Long> lst1 = part1.createSeperateList(true, part1.input);
        List<Long> lst2 = part1.createSeperateList(false, part1.input);

        System.out.println("result part1: " + part1.calculate(lst1, lst2));

        System.out.println("result part2: " + part1.calculatePart2(lst1, lst2));
    }

    public List<Long> createSeperateList(boolean isFirstPart, List<String> inputLst) {
        List<Long> result = new ArrayList<>();
        for (String s : inputLst) {
            String[] arr = s.split(" +");
            if (isFirstPart) {
                result.add(Long.valueOf(arr[0]));
            } else {
                result.add(Long.valueOf(arr[1]));
            }
        }
        Collections.sort(result);
        return result;
    }

    public Long calculate(List<Long> lst1, List<Long> lst2) {
        Long result = 0L;
        for (int i = 0; i < lst1.size(); i++) {
            Long nr1 = lst1.get(i);
            Long nr2 = lst2.get(i);

            if (nr1 > nr2) {
                result += nr1 - nr2;
            } else {
                result += nr2 - nr1;
            }
        }

        return result;
    }

    public Long calculatePart2(List<Long> lst1, List<Long> lst2) {
        Long result = 0L;
        Long nr1;
        int matchesFound = 0;
        for (int i = 0; i < lst1.size(); i++) {
            nr1 = lst1.get(i);
            matchesFound += Collections.frequency(lst2, nr1);

            if (matchesFound > 0) {
                result += nr1 * matchesFound;
            }
            matchesFound = 0;
        }

        return result;
    }
}
