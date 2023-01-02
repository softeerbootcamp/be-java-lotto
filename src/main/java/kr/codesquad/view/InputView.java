package kr.codesquad.view;

import kr.codesquad.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static int readMoney() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Lotto readWinningLotto() {
        Scanner scanner = new Scanner(System.in);
        String numbersStr = scanner.next();
        numbersStr = numbersStr.replaceAll("[^0-9]", "");
        List<Integer> numbers = Arrays.stream(numbersStr.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }
}
