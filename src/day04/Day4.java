package day04;

import util.FileProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 {

    public static void main(String[] args) {
        List<String> input = FileProcessor.textFileToList("%s.txt".formatted("d04"));
        int x = input.get(0).length();
        int y = input.size();
        Day4 d = new Day4();

        var xyMap = d.convertListToMap(input);
        System.out.println("answer day 4 part1: " + d.getCountXmas(y, x, xyMap));

        int countXs = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                String currentLetter = xyMap.get(String.format("x%dy%d", j, i));
                if (currentLetter.equals("A")) {
                    String leftTop = xyMap.get(String.format("x%dy%d", j - 1, i - 1));
                    String rightTop = xyMap.get(String.format("x%dy%d", j + 1, i - 1));
                    String rightBottom = xyMap.get(String.format("x%dy%d", j + 1, i + 1));
                    String leftBottom = xyMap.get(String.format("x%dy%d", j - 1, i + 1));

                    if (leftTop != null && rightTop != null && rightBottom != null && leftBottom != null) {
                        if ((leftTop.equals("M") && rightBottom.equals("S")) || (leftTop.equals("S") && rightBottom.equals("M"))) {
                            if ((rightTop.equals("M") && leftBottom.equals("S")) || (rightTop.equals("S") && leftBottom.equals("M"))) {
                                countXs++;
                            }
                        }

                    }
                }

            }
        }
        System.out.println("answer day 4 part2: " + countXs);
    }

    int getCountXmas(int y, int x, Map<String, String> xyMap) {
        int result = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                String currentLetter = xyMap.get(String.format("x%dy%d", j, i));
                if (currentLetter.equals("X")) {
                    //checkHorizontal
                    if (xyMap.get(String.format("x%dy%d", j + 1, i)) != null
                            && xyMap.get(String.format("x%dy%d", j + 1, i)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j + 2, i)) != null
                                && xyMap.get(String.format("x%dy%d", j + 2, i)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j + 3, i)) != null
                                    && xyMap.get(String.format("x%dy%d", j + 3, i)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkHorizontalReversed
                    if (xyMap.get(String.format("x%dy%d", j - 1, i)) != null
                            && xyMap.get(String.format("x%dy%d", j - 1, i)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j - 2, i)) != null
                                && xyMap.get(String.format("x%dy%d", j - 2, i)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j - 3, i)) != null
                                    && xyMap.get(String.format("x%dy%d", j - 3, i)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkVertical
                    if (xyMap.get(String.format("x%dy%d", j, i + 1)) != null
                            && xyMap.get(String.format("x%dy%d", j, i + 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j, i + 2)) != null
                                && xyMap.get(String.format("x%dy%d", j, i + 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j, i + 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j, i + 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkVerticalReversed
                    if (xyMap.get(String.format("x%dy%d", j, i - 1)) != null
                            && xyMap.get(String.format("x%dy%d", j, i - 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j, i - 2)) != null
                                && xyMap.get(String.format("x%dy%d", j, i - 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j, i - 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j, i - 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkDiagonalLeftTopToRightBottom
                    if (xyMap.get(String.format("x%dy%d", j + 1, i + 1)) != null
                            && xyMap.get(String.format("x%dy%d", j + 1, i + 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j + 2, i + 2)) != null
                                && xyMap.get(String.format("x%dy%d", j + 2, i + 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j + 3, i + 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j + 3, i + 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkDiagonalRightTopToLeftBottom
                    if (xyMap.get(String.format("x%dy%d", j - 1, i + 1)) != null
                            && xyMap.get(String.format("x%dy%d", j - 1, i + 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j - 2, i + 2)) != null
                                && xyMap.get(String.format("x%dy%d", j - 2, i + 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j - 3, i + 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j - 3, i + 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkDiagonalLeftBottomToRightTop
                    if (xyMap.get(String.format("x%dy%d", j + 1, i - 1)) != null
                            && xyMap.get(String.format("x%dy%d", j + 1, i - 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j + 2, i - 2)) != null
                                && xyMap.get(String.format("x%dy%d", j + 2, i - 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j + 3, i - 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j + 3, i - 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                    //checkDiagonalRightBottomToLeftTop
                    if (xyMap.get(String.format("x%dy%d", j - 1, i - 1)) != null
                            && xyMap.get(String.format("x%dy%d", j - 1, i - 1)).equals("M")) {
                        if (xyMap.get(String.format("x%dy%d", j - 2, i - 2)) != null
                                && xyMap.get(String.format("x%dy%d", j - 2, i - 2)).equals("A")) {
                            if (xyMap.get(String.format("x%dy%d", j - 3, i - 3)) != null
                                    && xyMap.get(String.format("x%dy%d", j - 3, i - 3)).equals("S")) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public Map<String, String> convertListToMap(List<String> input) {
        Map<String, String> result = new HashMap<>();
        for (int y = 0; y < input.size(); y++) {
            String line = input.get(y);
            String[] split = line.split("");
            for (int x = 0; x < line.length(); x++) {
                result.put(String.format("x%dy%d", x, y), split[x]);
            }
        }

        return result;
    }

}
