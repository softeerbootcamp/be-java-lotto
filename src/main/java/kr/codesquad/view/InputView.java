package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputTotalPrice() {
        return input();
    }

    public static int inputManualLottoAmount() {
        return Integer.parseInt(input());
    }

    public static List<Integer> inputLotto() {
            return Arrays.stream(input().split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }

    public static String inputBonusBall() {
        return input();
    }

    private static String input() {
        return sc.nextLine();
    }
}
