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

    public List<Integer> inputWinNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] winNum = sc.nextLine().split(", ");

        List<Integer> winNumList = new ArrayList<>();
        for(int i = 0;i < 6;i++) winNumList.add(Integer.parseInt(winNum[i]));

        return winNumList;
    }

    public List<Integer> inputBonusNum(List<Integer> winNumList) {
        System.out.println("보너스 볼을 입력해 주세요.");
        winNumList.add(sc.nextInt());
        return winNumList;
    }
}
