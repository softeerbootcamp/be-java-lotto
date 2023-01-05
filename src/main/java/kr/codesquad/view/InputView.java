package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static kr.codesquad.validator.InputValidator.MoneyValidator;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자를 입력해야 합니다.";

    public int readMoney() {
        while(true) {
            try {
                int money = readOneNumber();
                MoneyValidator.validate(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readManualLottoCount() {
        int count = readOneNumber();
        return count;
    }

    public int readOneNumber() {
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> readLottoNumbers() {
        String[] numbersStr = scanner.nextLine().split(", ");
        return Arrays.stream(numbersStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
