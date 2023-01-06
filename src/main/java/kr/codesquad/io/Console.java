package kr.codesquad.io;

import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.other.Bonus;
import kr.codesquad.domain.other.Money;
import kr.codesquad.domain.winLotto.WinCount;
import kr.codesquad.domain.winLotto.WinResult;

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

    public void printLottoResult(Money money, WinResult winResult) {
        System.out.println("\n당첨 통계\n---------");
        winResult.printWinResultSentence();
        winResult.printProfit(money);
    }
}
