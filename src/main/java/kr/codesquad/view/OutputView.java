package kr.codesquad.view;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Lottos;

public class OutputView {
    public static void showRequestTotalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println("당첨번호를 입력해 주세요.");
    }

    public static void showResultStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---------");

    }
}
