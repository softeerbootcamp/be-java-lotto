package kr.codesquad.view;

import kr.codesquad.domain.Money;

public class OutputView {
    public void printInputMoneyText() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printIssuedLottoCount(Money money) {
        System.out.println(money.calculateLottoCount() + "개를 구매했습니다.");
    }

    public void printString(String message) {
        System.out.print(message);
    }

    public void printWinningNumberText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusBallText() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printMaulLottoBuyText() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printManualLottoNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
