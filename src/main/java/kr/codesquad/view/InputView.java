package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Scanner sc = new Scanner(System.in);

    public static String inputTotalPrice() {
        return input();
    }

    public static int inputManualLottoAmount() {
        return Integer.parseInt(input());
    }

    public static String inputManualLotto() {
        return input();
    }

    public static List<String> inputWinLotto() {
        return Arrays.asList(
                input().trim().split(DELIMITER)
        );
    }

    public static String inputBonusBall() {
        return input();
    }

    private static String input() {
        return sc.nextLine();
    }
}
