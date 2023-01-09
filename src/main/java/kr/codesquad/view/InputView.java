package kr.codesquad.view;

import java.util.Scanner;

public final class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return validateInput(SCANNER.nextLine());
    }

    public static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return validateInput(SCANNER.nextLine());
    }

    public static String inputWinningNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return SCANNER.nextLine();
    }

    public static String inputManualNumber() {
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return validateInput(SCANNER.nextLine());
    }

    public static int validateInput(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(input+"은 숫자가 아닙니다."+" 숫자로 입력해주세요.");
        }
    }
}
