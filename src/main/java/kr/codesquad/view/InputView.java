package kr.codesquad.view;

import java.util.Scanner;

public final class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try{
            return Integer.parseInt(SCANNER.nextLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }

    public static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        try{
            int manualLottoCount = Integer.parseInt(SCANNER.nextLine());
            if (manualLottoCount < 0)
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            return manualLottoCount;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
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
        try{
            return Integer.parseInt(SCANNER.nextLine());
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자로 입력해주세요.");
        }
    }
}
