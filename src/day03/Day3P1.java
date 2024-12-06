package day03;

import util.FileProcessor;

import java.util.ArrayList;
import java.util.List;

public class Day3P1 {
    List<String> input = FileProcessor.textFileToList("%s.txt".formatted("d03"));

    public static void main(String[] args) {
        Day3P1 d = new Day3P1();
        var mulValuesRaw = d.getMulValues(d.input);
        var mulValues = d.cleanUpLst(mulValuesRaw);

        long answer = 0;

        for (String mulValue : mulValues) {
            var splitted = mulValue.split(",");
            answer += Long.parseLong(splitted[0]) * Long.parseLong(splitted[1]);
        }

        System.out.println("Answer day 3, part 1: " + answer);
    }

    public List<String> getMulValues(List<String> input) {
        List<String> result = new ArrayList<>();

        for (String s : input) {
            String[] muls = s.split("mul");
            for (String mul : muls) {
                if (!mul.isEmpty()) {
                    result.add(mul);
                }
            }
        }

        return result;
    }

    public List<String> cleanUpLst(List<String> input) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (s.startsWith("(")) {
                int j = s.indexOf(")");
                if (j > 0) {
                    String subString = s.substring(1, j);
                    if (subString.matches("^([1-9][0-9]{0,2}),([1-9][0-9]{0,2})$")) {
                        result.add(s.substring(1, j));
                    }
                }
            }
        }

        return result;
    }
}
