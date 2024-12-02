package day02;

import util.FileProcessor;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    List<String> input = FileProcessor.textFileToList("%s.txt".formatted("d02"));

    public static void main(String[] args) {
        Part2 part2 = new Part2();
        int count = 0;
        int puzzle2 = 0;

        for (String report : part2.input) {
            String[] reportStringArr = report.split(" ");
            int[] reportIntArr = new int[reportStringArr.length];

            for (int i = 0; i < reportStringArr.length; i++) {
                reportIntArr[i] = Integer.parseInt(reportStringArr[i]);
            }

            if ((part2.isIncreasing(reportIntArr) || part2.isDecreasing(reportIntArr))
            && part2.isDifferenceThreeOrLess(reportIntArr)) {
                count++;
            } else {
                if (part2.isValidReportWhenOneDigitRemoved(reportIntArr)) {
                    puzzle2++;
                }
            }
        }

        System.out.println("part 1: " + count); //606
        System.out.println(String.format("part 2: count = %d + extra = %d answer= %d", count, puzzle2, count+puzzle2));
    }

    boolean isValidReportWhenOneDigitRemoved(int[] report) {
        boolean result = false;
        int amountOfDigits = report.length;
        for (int i = 0; i < amountOfDigits; i++) {
            List<Integer> lst = new ArrayList<>(amountOfDigits);
            for (int y : report)
            {
                lst.add(y);
            }
            lst.remove(i);

            int[] arr = lst.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            if ((isIncreasing(arr) || isDecreasing(arr))
                    && isDifferenceThreeOrLess(arr)) {
                result = true;
            }
        }

        return result;
    }


    public boolean isIncreasing(int[] input) {
        int nr = input[0];
        boolean isIncreasing = true;

        for (int i = 1; i < input.length; i++) {
            if (nr >= input[i]) {
                isIncreasing = false;
            }
            nr = input[i];
        }

        return isIncreasing;
    }

    public boolean isDecreasing(int[] input) {
        int nr = input[0];
        boolean isDecreasing = true;

        for (int i = 1; i < input.length; i++) {
            if (nr <= input[i]) {
                isDecreasing = false;
            }
            nr = input[i];
        }

        return isDecreasing;
    }

    public boolean isDifferenceThreeOrLess(int[] input) {
        int nr = input[0];
        boolean isValid = true;

        for (int i = 1; i < input.length; i++) {
            if (nr >= input[i]) {
                if (!(nr - input[i] < 4)) {
                    isValid = false;
                }
            } else {
                if (!(input[i] - nr < 4)) {
                    isValid = false;
                }
            }
            nr = input[i];
        }

        return isValid;
    }
}
