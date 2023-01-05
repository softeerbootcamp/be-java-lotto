package kr.codesquad.view;

import kr.codesquad.validator.InputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String DELIMITER = ", ";
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "숫자를 입력해야 합니다.";
    private static final String LOTTO_NUMBERS_FORMAT_ERROR_MESSAGE = "로또 번호는 \"" + DELIMITER + "\"를 기준으로 입력해야 합니다.";

    public int readMoney() {
        while (true) {
            try {
                int money = readOneNumber();
                InputValidator.MoneyValidator.validate(money);
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readManualLottoCount(int money) {
        while (true) {
            try {
                int manualLottoCount = readOneNumber();
                InputValidator.ManualLottoCountValidator.validate(money, manualLottoCount);
                return manualLottoCount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int readOneNumber() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_ERROR_MESSAGE);
            }
        }
    }

    public List<Integer> readLottoNumbers() {
        while (true) {
            try {
                List<Integer> numbers = readNumbers();
                InputValidator.LottoNumbersValidator.validate(numbers);
                return numbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> readNumbers() {
        while(true) {
            try {
                String[] numbersStr = scanner.nextLine().split(DELIMITER);
                return Arrays.stream(numbersStr)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                System.out.println(LOTTO_NUMBERS_FORMAT_ERROR_MESSAGE);
            }
        }
    }
}
