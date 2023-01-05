package kr.codesquad.view;

import kr.codesquad.model.Rank;
import kr.codesquad.model.UserLotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printMoneyReadMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printManualLottoCountReadMessage() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printUserManualLottoReadMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 "+ autoLottoCount + "개를 구매했습니다.");
    }

    public void printUserLotto(UserLotto userLotto) {
        userLotto.getLottos()
                .forEach(System.out::println);
    }

    public void printWinningLottoReadMessage() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberReadMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printResult(Map<Rank, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n----------");

        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NOTHING)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        printWinningResultMessage(ranks, result);
        printProfitRateMessage(profitRate);
    }

    private void printWinningResultMessage(List<Rank> ranks, Map<Rank, Integer> result) {
        ranks.forEach(rank -> {
            System.out.print(rank.getCount()+"개 일치");
            printBonusBallMessage(rank);
            System.out.println(" " + rank.getPrize() + "원)- " + result.getOrDefault(rank, 0) + "개");
        });
    }

    private void printBonusBallMessage(Rank rank) {
        if (rank.isBonus()) {
            System.out.print(", 보너스 볼 일치");
        }
    }

    private void printProfitRateMessage(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "%입니다.");
    }
}
