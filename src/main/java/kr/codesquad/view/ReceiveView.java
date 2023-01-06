package kr.codesquad.view;


import kr.codesquad.util.error.EnterErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class ReceiveView {

    private static final String LOTTO_SEPARATE = ",";
    private static final String MANUAL_LOTTO_REGEX = "^[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+,[\\d]+$";

    public static int enterInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> enterManualLottos() {
        Scanner scanner = new Scanner(System.in);
        String inputNumbers = scanner.nextLine();
        validManualLotto(inputNumbers);
        return transInputToList(inputNumbers);
    }

    private static List<Integer> transInputToList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(LOTTO_SEPARATE))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validManualLotto(String inputNumbers) {
        if (!inputNumbers.matches(MANUAL_LOTTO_REGEX)) {
            throw new IllegalArgumentException(EnterErrorMessage.NOT_VALID_LOTTO_NUMBER);
        }
    }

    public static int enterManualTickets(){
        return enterInt();
    }
}
