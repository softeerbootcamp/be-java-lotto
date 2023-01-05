package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Lottos;
import kr.codesquad.domain.Rank;
import kr.codesquad.domain.Result;

public class OutputView {
    public static void showRequestTotalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void showRequestManualLottoAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void showRequestManualLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void showLottoAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void showLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottoList()) {
            System.out.println(lotto.getLotto().toString());
        }
    }

    public static void showRequestWinNumber() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
    }

    public static void showRequestBonusball() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void showResultStatistics() {
        System.out.println("당첨 통계");
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
