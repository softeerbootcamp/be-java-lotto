package kr.codesquad.io;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.other.Money;
import kr.codesquad.domain.winLotto.WinCount;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Console {
    public static Scanner sc = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(Integer.parseInt(sc.nextLine()));
    }

    public Bonus inputBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Bonus(Integer.parseInt(sc.nextLine()));
    }

    public int inputManualLottoAmount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualAmount = Integer.parseInt(sc.nextLine());
        return manualAmount;
    }

    public List<Integer> inputWinLottoNum() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNum();
    }

    public List<Integer> inputLottoNum() {
        String lottoNumInput = sc.nextLine();
        String[] strList = lottoNumInput.split(", ");
        return Arrays.stream(strList)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public void printAmount(int manualAmount, int autoAmount) {
        System.out.println("수동으로 " + manualAmount + "장, 자동으로 " + autoAmount + "개를 구매했습니다.");
    }

    public void printLottoNum(List<Lotto> lottoList) {
        lottoList.stream().forEach(System.out::println);
        System.out.println();
    }

    public void printLottoResult(Money money, Map<WinCount, Integer> lottoResult) {
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

    public void printProfit(Map<WinCount, Integer> lottoResult, Money money) {
        int rewardSum = lottoResult
                .entrySet()
                .stream()
                .mapToInt(lotto -> lotto.getKey().getPrice() * lotto.getValue())
                .sum();

        double ans = (((double) (rewardSum - money.getMoney())) / (double) money.getMoney()) * 100.0;
        System.out.println("총 수익률은 " + Math.floor(ans * 100) / 100.0 + "%입니다.");
    }
}
