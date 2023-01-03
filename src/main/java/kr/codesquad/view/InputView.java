package kr.codesquad.view;

import kr.codesquad.model.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public int readMoney() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Lotto readWinningLotto() {
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split(", ");
        List<Integer> numbers = Arrays.stream(numbersStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new Lotto(numbers);
    }

    public int readBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
