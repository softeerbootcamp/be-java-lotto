package kr.codesquad.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public int readOneNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<Integer> readLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split(", ");
        return Arrays.stream(numbersStr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
