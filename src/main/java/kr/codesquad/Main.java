package kr.codesquad;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static int money;
    public static ArrayList<Lotto> allLotto = new ArrayList<>();
    public static String winNumInput;
    public static WinNum winNum;
    public static int[] correctCnt = new int[7];
    public static int[] reward = {0, 0, 0, 5000, 50000, 1500000, 2000000000};
    public static void main(String[] args) {
        inputMoney();
        makeLottoNum();
        showLottoNum();
        inputWinNum();
        lottoResult();
        showLottoResult();
    }

    static void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        money = sc.nextInt();
        System.out.println(money/1000 + "개를 구매했습니다.");
    }
    static void makeLottoNum() {
        for(int i=0;i<money/1000;i++) {
            Lotto lotto = new Lotto();
            allLotto.add(lotto);
        }
    }
    static void showLottoNum() {
        for(int i=0;i<allLotto.size();i++) {
            System.out.println(allLotto.get(i).numberList);
        }
        System.out.println();
    }
    static void inputWinNum() {
        sc.nextLine();
        System.out.println("당첨 번호를 입력해 주세요.");
        winNumInput = sc.nextLine();
        winNum = new WinNum(winNumInput);
    }
    static void lottoResult() {
        for(int i=0;i<allLotto.size();i++) {
            correctCnt[allLotto.get(i).correctNumCnt(winNum)]++;
        }
        System.out.println();
    }
    static void showLottoResult() {
        System.out.println("당첨 통계\n---------");
        int rewardSum = 0;
        for (int i=3;i<=6;i++) {
            System.out.println(i + "개 일치 (" + reward[i] + ") - " + correctCnt[i] + "개");
            rewardSum += reward[i] * correctCnt[i];
        }
        double ans = (((double) (rewardSum - money)) / (double) money) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }
}