package kr.codesquad;

import kr.codesquad.Exceptions.CustomException;

import java.util.*;

public class Utility {

    public static List<Integer> generateRandomSixNumbers() {
        List<Integer> oneTo45 = new ArrayList<>();
        List<Integer> lotteryNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++)
            oneTo45.add(i);
        Collections.shuffle(oneTo45);
        for (int i = 0; i < 6; i++)
            lotteryNumbers.add(oneTo45.get(i));
        Collections.sort(lotteryNumbers);
        return lotteryNumbers;
    }

    public static boolean isDuplicated(List<Integer> integerList) {
        Set<Integer> set = new HashSet<>(integerList);
        return set.size() != integerList.size();
    }

    public static int parseIntWithRange(String target, int lowerBound, int upperBound) {
        int temp = Integer.parseInt(target);
        if (temp < lowerBound || temp > upperBound) {
            throw new CustomException(String.format("%s가 [%d, %d] 범위에 있어야 합니다.", target, lowerBound, upperBound));
        }
        return temp;
    }

    public static List<Integer> str2IntListWithRange(String target, int lowerBound, int upperBound) {
        List<String> strSplit = List.of(target.split(","));
        List<Integer> numbers = new ArrayList<>();
        for (String num : strSplit) {
            numbers.add(Utility.parseIntWithRange(num.trim(), lowerBound, upperBound));
        }
        return numbers;
    }

}
