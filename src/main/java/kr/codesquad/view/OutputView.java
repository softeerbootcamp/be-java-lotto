package kr.codesquad.view;

import kr.codesquad.model.Rank;
import kr.codesquad.model.User;
import kr.codesquad.model.WinningResult;
import kr.codesquad.model.lotto.Lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String LOTTO_PURCHASE_MONEY_READ_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_READ_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_READ_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_READ_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_READ_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_GAME_RESULT_START_MESSAGE = "\n당첨 통계\n--------";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public void printMoneyReadMessage() {
        System.out.println(LOTTO_PURCHASE_MONEY_READ_MESSAGE);
    }

    public void printManualLottoCountReadMessage() {
        System.out.println(MANUAL_LOTTO_COUNT_READ_MESSAGE);
    }

    public void printUserManualLottoReadMessage() {
        System.out.println(MANUAL_LOTTO_NUMBER_READ_MESSAGE);
    }

    public void printUser(User user) {
        printLottoCount(user.getManualLottoCount(), user.getAutoLottoCount());
        printUserLotto(user.getLottos());
    }

    public void printLottoCount(int manualLottoCount, int autoLottoCount) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + autoLottoCount + "개를 구매했습니다.");
    }

    public void printUserLotto(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public void printWinningLottoReadMessage() {
        System.out.println(WINNING_NUMBER_READ_MESSAGE);
    }

    public void printBonusNumberReadMessage() {
        System.out.println(BONUS_NUMBER_READ_MESSAGE);
    }

    public void printResult(WinningResult winningResult, int money) {
        System.out.println(LOTTO_GAME_RESULT_START_MESSAGE);
        Map<Rank, Integer> result = winningResult.getResult();

        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NOTHING)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        printWinningResultMessage(ranks, result);

        double profitRate = winningResult.calculateProfitRate(money);
        printProfitRateMessage(profitRate);
    }

    private void printWinningResultMessage(List<Rank> ranks, Map<Rank, Integer> result) {
        ranks.forEach(rank -> {
            System.out.print(rank.getCount() + "개 일치");
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
