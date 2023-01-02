package kr.codesquad;

import java.util.List;

public class OutputView {
    public void printInputMoneyText() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printBoughtLottoCount(long count) {
        System.out.println(count+"개를 구매했습니다.");
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
}
