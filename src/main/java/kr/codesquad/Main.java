package kr.codesquad;

import kr.codesquad.controller.LottoController;
import kr.codesquad.domain.Lotto;

import java.util.*;

public class Main {
    private static final int LOTTO_PRICE = 1000;
    private static int total_price;
    private static int amount;
    private static List<Lotto> lottoNumbers = new ArrayList<>();
    private static List<Integer> winLotto = new ArrayList<>();
    private static int[] sameCnt = new int[7];

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run();
    }

    public static void requestInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        total_price = sc.nextInt();
    }

    public static void setAmount() {
        amount = total_price / LOTTO_PRICE;
        System.out.println(amount + "개를 구매했습니다.");
    }

    public static void generateLottos() {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto();
            lottoNumbers.add(lotto);
            System.out.println(lotto.getLotto().toString());
        }
    }
    public static void setWinNumber() {
        System.out.println("당첨번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            winLotto.add(sc.nextInt());
        }
    }

    public static void findSameNumber() {
        for (int i = 0; i < amount; i++) {
            List<Integer> tempLotto = lottoNumbers.get(i).getLotto();
            List<Integer> tempWin = winLotto;
            tempLotto.retainAll(tempWin);
            int same = tempLotto.size();
            sameCnt[same]++;
        }
    }

    public static void getResult() {
        int[] price = {5000, 50000, 1500000, 2000000000};
        double sum = 0;
        for (int i = 3; i <= 6; i++) {
            sum += price[i - 3] * sameCnt[i];
        }
        System.out.println("당첨 통계\n---------");
        showResult(sum);
    }

    public static void showResult(double sum) {
        System.out.println(3 + "개 일치 " + "(" + 5000 + "원)" + " - " + sameCnt[3] + "개");
        System.out.println(4 + "개 일치 " + "(" + 50000 + "원)" + " - " + sameCnt[4] + "개");
        System.out.println(5 + "개 일치 " + "(" + 1500000 + "원)" + " - " + sameCnt[5] + "개");
        System.out.println(6 + "개 일치 " + "(" + 2000000000 + "원)" + " - " + sameCnt[6] + "개");
        System.out.printf("총 수익률은 %.2f%% 입니다.", ((sum - total_price) / total_price * 100));
    }

}
