package kr.codesquad.view;


import java.util.*;
import java.util.stream.Collectors;

public class ReceiveView {

    private static final String LOTTO_SEPARATE = ",";

    public static int enterInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> enterManualLottos() {
        Scanner scanner = new Scanner(System.in);
        String inputNumbers = scanner.nextLine();
        return transInputToList(inputNumbers);
    }

    private static List<Integer> transInputToList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(LOTTO_SEPARATE))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int enterManualTickets(){
        return enterInt();
    }
}
