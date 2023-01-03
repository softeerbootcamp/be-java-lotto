package kr.codesquad.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        String[] splitNumber = inputNumbers.split(WIN_LOTTO_SEPARATE);
        List<Integer> winningNumbers = getWinningNumbers(splitNumber);
        return winningNumbers;
    }

    private static List<Integer> getWinningNumbers(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : split) {
            winningNumbers.add(Integer.valueOf(number.trim()));
        }
        return winningNumbers;
    }
}
