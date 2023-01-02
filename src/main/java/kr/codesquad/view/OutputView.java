package kr.codesquad.view;

import kr.codesquad.model.Lotto;

import java.util.List;

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
}
