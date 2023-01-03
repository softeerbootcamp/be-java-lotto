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

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printUserLotto(UserLotto userLotto) {
        StringBuilder sb = new StringBuilder();
        userLotto.getLottos()
                .forEach(lotto -> sb.append(lotto.toString()));
        System.out.println(sb);
    }

    public void printWinningLottoReadMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberReadMessage() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printResult(Map<Rank, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n----------");

        StringBuilder sb = new StringBuilder();
        List<Rank> ranks = Arrays.stream(Rank.values()).collect(Collectors.toList());
        Collections.sort(ranks, Collections.reverseOrder());

        ranks.stream()
                .filter(rank -> rank != Rank.NOTHING)
                .forEach(rank -> {
                    sb.append(rank.getCount())
                            .append("개 일치");
                    if (rank == Rank.SECOND) {
                        sb.append(", 보너스 볼 일치");
                    }
                    sb.append(" (")
                            .append(rank.getPrize())
                            .append("원)- ")
                            .append(result.getOrDefault(rank, 0))
                            .append("개\n");
                });
        sb.append("총 수익률은 ")
                .append(String.format("%.2f", profitRate))
                .append("%입니다.");

        System.out.println(sb);
    }
}
