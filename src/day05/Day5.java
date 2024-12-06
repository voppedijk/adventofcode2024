package day05;

import util.FileProcessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {
    static List<String> pageOrderingRules = FileProcessor.textFileToList("%s.txt".formatted("d05"));

    public static void main(String[] args) {
        List<String> pageUpdates = FileProcessor.textFileToList("%s.txt".formatted("d05_2"));
        Day5 day5 = new Day5();
        long answer = 0;
        List<String> invalidRules = new ArrayList<>();

        for (String pageUpdate : pageUpdates) {
            int result = day5.isValidUpdate(pageOrderingRules, pageUpdate);

            if (result == 0) {
                invalidRules.add(pageUpdate);
            } else {
                answer += result;
            }
        }

        System.out.println("Answer day 5, part 1: " + answer); //3608

        long answer2 = 0;
        var fixedLst = day5.fixInvalidList(invalidRules);
        for (String s : fixedLst) {
            answer2 += day5.isValidUpdate(pageOrderingRules, s);
        }
        System.out.println("Answer day 5, part 2: " + answer2); //4922
    }

    public int isValidUpdate(List<String> pageOrderingRules, String pageUpdate) {
        boolean isValid = true;
        String[] pages = pageUpdate.split(",");
        int numberOfUpdates = pages.length;

        for (int i = 0; i < numberOfUpdates - 1; i++) {
            String currentNr = pages[i];
            for (int j = 0; j < numberOfUpdates - i - 1; j++) {
                String nextNr = pages[i + j + 1];
                if (pageOrderingRules.contains(nextNr + "|" + currentNr)) {
                    isValid = false;
                }
            }
        }
        int middle = ((numberOfUpdates / 2) + (numberOfUpdates % 2));
        int middleNr = Integer.parseInt(pages[middle - 1]);
        return isValid ? middleNr : 0;
    }

    public List<String> fixInvalidList(List<String> brokenLst) {
        List<String> result = new ArrayList<>();

        for (String broken : brokenLst) {
            String b = broken;
            boolean invalid = true;
            String[] bArr = b.split(",");
            int length = bArr.length;

            while (invalid) {
                for (int i = 0; i < length - 1; i++) {
                    String currentNr = bArr[i];
                    String nextNr = bArr[i + 1];
                    if (pageOrderingRules.contains(currentNr + "|" + nextNr)) {
                        //correct
                        if (isValidUpdate(pageOrderingRules, b) > 0) {
                            invalid = false;
                        }
                    } else if (pageOrderingRules.contains(nextNr + "|" + currentNr)) {
                        //incorrect
                        var tst = Arrays.stream(bArr).toList();
                        List<String> temp = new ArrayList<>(tst);
                        temp.remove(currentNr);
                        temp.add(currentNr);
                        b = String.join(",", temp);
                        bArr = b.split(",");
                        break;
                    }
                }
            }
            result.add(b);
        }

        return result;
    }
}
