package kr.codesquad.view;

import kr.codesquad.enums.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printInputMoneyText() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public void printIssuedLottoCount(Money money) {
        System.out.println(money.calculateLottoCount() + "개를 구매했습니다.");
    }
    private void printNumbers(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.print(list.get(list.size() - 1));
    }

    public void printLottoNumbers(List<List<Integer>> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print("[");
            printNumbers(numbers.get(i));
            System.out.println("]");
        }
    }

    public void printWinningNumberText() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printTotalText(Map<Rank, Integer> score) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank rank : Rank.values()) {
            printDetailText(rank, score.get(rank));
        }
    }
    private void printDetailText(Rank rank, int count) {
        if (rank == Rank.SECOND) {
            System.out.println(rank.getScore() + "개 일치, 보너스 볼 일치(" + rank.getMoney() + "원)- " + count + "개");
            return;
        }
        System.out.println(rank.getScore() + "개 일치 (" + rank.getMoney() + "원)- " + count + "개");
    }

    public void printEarnedRate(double rate) {
        if (rate < 0) {
            System.out.println("총 수익률은 " + (Math.ceil(rate * 100) / 100) + "%입니다.");
            return;
        }
        System.out.println("총 수익률은 " + (Math.floor(rate * 100) / 100) + "%입니다.");
    }

    public void printBonusBallText() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }
}
