package kr.codesquad;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private final Scanner sc;

    public UserInput() {
        this.sc = new Scanner(System.in);
    }

    public int inputMoney() {
        int money = 0;
        System.out.println("구입금액을 입력해 주세요.");
        money = validateInputOneNumber(money);
        return money;
    }

    public int inputManualLottoCount() {
        int manualLottoCount = 0;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        manualLottoCount = validateInputOneNumber(manualLottoCount);
        return manualLottoCount;
    }

    public List<List<Integer>> inputManualLottoList(int manualLottoCount) {
        List<List<Integer>> manualLottoList = new ArrayList<>(manualLottoCount);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0;i < manualLottoCount;i++) {
            List<Integer> manualLotto = Util.parseInputNumString();
            manualLottoList.add(manualLotto);
        }

        return manualLottoList;
    }

    public List<Integer> inputWinNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Util.parseInputNumString();
    }

    public int inputBonusNum() {
        int bonusNum = 0;
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNum = validateInputOneNumber(bonusNum);
        return bonusNum;
    }

    private int validateInputOneNumber(int num) {
        try {
            num = sc.nextInt();
            sc.nextLine();
        } catch(InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
            e.printStackTrace();
            System.exit(0);
        }

        return num;
    }
}
