package kr.codesquad.view;

import java.util.*;
import java.util.stream.Collectors;

public class ReceiveView {

    private static final String WIN_LOTTO_SEPARATE = ",";


    public static int enterPurchaseAmount() {
        return enterInt();
    }

    public static int enterBonusBall() {
        return enterInt();
    }
    private static int enterInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> enterWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        String inputNumbers = scanner.nextLine();
        return getWinningNumbers(inputNumbers);
    }

    private static List<Integer> getWinningNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(WIN_LOTTO_SEPARATE))
                .mapToInt(Integer::parseInt)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
    }

    public static int enterManualTickets(){
        return enterInt();
    }
}
