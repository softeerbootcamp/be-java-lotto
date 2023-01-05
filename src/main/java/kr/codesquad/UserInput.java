package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private final Scanner sc;

    public UserInput() {
        this.sc = new Scanner(System.in);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        sc.nextLine();
        return money;
    }

    public int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int manualLottoCount = sc.nextInt();
        sc.nextLine();
        return manualLottoCount;
    }

    public List<List<Integer>> inputManualLottoList(int manualLottoCount) {
        List<List<Integer>> manualLottoList = new ArrayList<>(manualLottoCount);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for(int i = 0;i < manualLottoCount;i++) {
            String[] eachManualLotto = sc.nextLine().split(", ");

            int eachManualLottoCount = eachManualLotto.length;
            List<Integer> manualLotto = new ArrayList<>(eachManualLottoCount);
            for (String eachManualLottoNum : eachManualLotto) manualLotto.add(Integer.parseInt(eachManualLottoNum));

            manualLottoList.add(manualLotto);
        }

        return manualLottoList;
    }

    public List<Integer> inputWinNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winNum = sc.nextLine().split(", ");

        List<Integer> winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(winNum[i]));

        return winNumList;
    }

    public int inputBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = sc.nextInt();
        sc.nextLine();
        return bonusNum;
    }
}
