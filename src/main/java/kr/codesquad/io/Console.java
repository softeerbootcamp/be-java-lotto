package kr.codesquad.io;

import kr.codesquad.Lotto;
import kr.codesquad.WinNum;

import java.util.List;
import java.util.Scanner;

public class Console {
    public static Scanner sc = new Scanner(System.in);
    public static int[] reward = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    public int inputMoney() {
        printInputMoney();
        int money = sc.nextInt();
        return money;
    }

    public WinNum inputWinNum() {
        printInputWinNum();
        sc.nextLine();
        String winNumInput = sc.nextLine();
        return new WinNum(winNumInput);
    }

    public void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public void printAmount(int amount) {
        System.out.println(amount + "개를 구입했습니다. ");
    }

    public void printLottoNum(List<Lotto> lottoList) {
        for(int i=0;i<lottoList.size();i++) {
            System.out.println(lottoList.get(i).numberList);
        }
        System.out.println();
    }

    public void printLottoResult(int money, int[] correctCnt) {
        System.out.println("\n당첨 통계\n---------");
        int rewardSum = 0;
        for (int i=3;i<=6;i++) {
            System.out.println(i + "개 일치 (" + reward[i] + ") - " + correctCnt[i] + "개");
            rewardSum += reward[i] * correctCnt[i];
        }
        double ans = (((double) (rewardSum - money)) / (double) money) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }
}
