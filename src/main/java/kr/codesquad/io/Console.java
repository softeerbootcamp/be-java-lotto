package kr.codesquad.io;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.winLotto.WinCount;

import java.util.*;

public class Console {
    public static Scanner sc = new Scanner(System.in);

    public static InputView inputView = new InputView();

    public int inputMoney() {
        inputView.inputMoneyView();
        int money = Integer.parseInt(sc.nextLine());
        return money;
    }

    public int inputBonusNum() {
        inputView.inputBonusNumView();
        int bonus = Integer.parseInt(sc.nextLine());
        return bonus;
    }

    public int inputManualLottoAmount() {
        inputView.inputManualLottoAmountView();
        int manualAmount = Integer.parseInt(sc.nextLine());
        return manualAmount;
    }

    public List<Lotto> inputManualLottoNum(int amount) {
        if(amount != 0) {
            inputView.inputManualLottoNumView();
        }
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            manualLottos.add(new Lotto(inputLottoNum()));
        }
        return manualLottos;
    }

    public List<Integer> inputWinLottoNum() {
        inputView.inputWinLottoNumView();
        return inputLottoNum();
    }

    public List<Integer> inputLottoNum() {
        String winNumInput = sc.nextLine();
        List<Integer> lottoNum = new ArrayList<>();
        String[] strList = winNumInput.split(", ");
        for (int i = 0; i < strList.length; i++) {
            lottoNum.add(Integer.parseInt(strList[i]));
        }
        return lottoNum;
    }

    public void printAmount(int manualAmount, int autoAmount) {
        System.out.println("수동으로 " + manualAmount + "장, 자동으로 " + autoAmount + "개를 구매했습니다.");
    }

    public void printLottoNum(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }
        System.out.println();
    }

    public void printLottoResult(int money, Map<WinCount, Integer> lottoResult) {
        System.out.println("\n당첨 통계\n---------");

        Arrays.stream(WinCount.values())
                .forEach(winCount -> {
                    printLottoResultByWinningCount(lottoResult, winCount);

                });
        printProfit(lottoResult, money);
    }

    public void printLottoResultByWinningCount(Map<WinCount, Integer> lottoResult, WinCount winCount) {
        String bonus = (winCount.getIsBonus()) ? ", 보너스 볼 일치" : "";
        if (lottoResult.containsKey(winCount)) {
            System.out.println(winCount.getCount() + "개 일치" + bonus + "(" + winCount.getPrice() + ") - " + lottoResult.get(winCount) + "개");
        }
        if (!lottoResult.containsKey(winCount)) {
            System.out.println(winCount.getCount() + "개 일치" + bonus + "(" + winCount.getPrice() + ") - " + "0개");
        }
    }

    public void printProfit(Map<WinCount, Integer> lottoResult, int money) {
        int rewardSum = 0;
        for (Map.Entry<WinCount, Integer> lotto : lottoResult.entrySet()) {
            rewardSum += lotto.getKey().getPrice() * lotto.getValue();
        }

        double ans = (((double) (rewardSum - money)) / (double) money) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }
}
