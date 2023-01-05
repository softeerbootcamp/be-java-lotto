package kr.codesquad.view;

import kr.codesquad.domain.Rank;
import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.lotto.LottoNumber;
import kr.codesquad.domain.lotto.Lottos;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public final class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void showRequestTotalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showRequestManualLottoAmount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void showRequestManualLottoNumbers(int manualLottoCount) {
        if (manualLottoCount != 0) {
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        }
    }

    public static void showLottoAmount(int totalLottoCount, int manualLottoCount) {
        System.out.printf("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualLottoCount, totalLottoCount - manualLottoCount);
    }

    public static void showLottoNumbers(Lottos lottos) {
        lottos.getLottoList()
                .stream()
                .map(lotto -> lotto.getLotto().toString())
                .forEach(System.out::println);
    }

    public static void showRequestWinNumber() {
        System.out.println("\n지난 주 당첨번호를 입력해 주세요.");
    }

    public static void showRequestBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void showResultStatistics() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
    }

    public static void showProfitResult(
            double sum,
            int totalPrice
    ) {
        System.out.printf("총 수익률은 %.2f%% 입니다.", ((sum - totalPrice) / totalPrice * 100));
    }

    public static void showLottoListResult(Result result) {
        for (Rank rank : Rank.getSortedRanks()) {
            showLottoResult(result.getResult().get(rank), rank);
        }
    }

    public static void showLottoResult(
            int lottoCount,
            Rank rank
    ) {
        String bonusText = "";
        if (rank.isBonus()) {
            bonusText = ", 보너스 볼 일치";
        }

        System.out.printf("%d개 일치%s(%d원) - %d개\n", rank.getCount(), bonusText, rank.getWinningAmount(), lottoCount);
    }
}
