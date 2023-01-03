package kr.codesquad.io;

import kr.codesquad.Lotto;
import kr.codesquad.WinningCount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {
    public static Scanner sc = new Scanner(System.in);

    public int inputMoney() {
        printInputMoney();
        int money = sc.nextInt();
        return money;
    }

    public Lotto inputWinNum() {
        printInputWinNum();
        sc.nextLine();
        String winNumInput = sc.nextLine();
        Lotto lotto = new Lotto();
        String[] strList = winNumInput.split(", ");
        for (int i = 0; i < strList.length; i++) {
            lotto.numberList.add(Integer.parseInt(strList[i]));
        }
        return lotto;
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
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i).numberList);
        }
        System.out.println();
    }

    public void printLottoResult(int money, Map<WinningCount, Integer> lottoResult) {
        System.out.println("\n당첨 통계\n---------");

        Arrays.stream(WinningCount.values())
                .forEach(winningCount -> {
                printLottoResultByWinningCount(lottoResult, winningCount);

        });
        printProfit(lottoResult, money);
    }

    public void printLottoResultByWinningCount(Map<WinningCount, Integer> lottoResult, WinningCount winningCount) {
        if (lottoResult.containsKey(winningCount)) {
            System.out.println(winningCount.getCount() + "개 일치 (" + winningCount.getPrice() + ") - " + lottoResult.get(winningCount) + "개");
        }
        if (!lottoResult.containsKey(winningCount)) {
            System.out.println(winningCount.getCount() + "개 일치 (" + winningCount.getPrice() + ") - " + "0개");

        }
    }

    public void printProfit(Map<WinningCount, Integer> lottoResult, int money) {
        int rewardSum = 0;
        for(Map.Entry<WinningCount, Integer> lotto : lottoResult.entrySet()) {
            rewardSum += lotto.getKey().getPrice() * lotto.getValue();
        }

        double ans = (((double) (rewardSum - money)) / (double) money) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }
}
