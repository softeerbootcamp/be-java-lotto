package kr.codesquad.view;

import kr.codesquad.model.Lotto;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void printMoneyReadMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount+"개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lotto -> sb.append(lotto.toString()));
        System.out.println(sb);
    }

    public static void printWinningLottoReadMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printResult(Map<Integer, Integer> result, double profitRate) {
        System.out.println("당첨 통계\n----------");

        System.out.println("3개 일치 (5000원)- " + result.get(3) + "개");
        System.out.println("4개 일치 (50000원)- " + result.get(4) + "개");
        System.out.println("5개 일치 (1500000원)- " + result.get(5) + "개");
        System.out.println("6개 일치 (2000000000원)- " + result.get(6) + "개");

        System.out.println("총 수익률은 " + String.format("%.2f", profitRate) + "%입니다.");
    }
}
