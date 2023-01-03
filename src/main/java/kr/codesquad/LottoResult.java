package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;


public class LottoResult {
    private ArrayList<Integer> result;
    private int lottoCount;
    public LottoResult() {
        result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));
    }
    public ArrayList<Integer> getResult() {
        return result;
    }

    public void updateResult(int index, int cnt) {
        result.set(index, result.get(index) + cnt);
    }

    public void printResult(int purchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("-----");
        System.out.println("3개 일치 (5000원) - " + result.get(LottoMatchType.THREE_MATCH.getMatchCount()));
        System.out.println("4개 일치 (50000원) - " + result.get(LottoMatchType.FOUR_MATCH.getMatchCount()));
        System.out.println("5개 일치 (1500000원) - " + result.get(LottoMatchType.FIVE_MATCH.getMatchCount()));
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + result.get(LottoMatchType.BONUS_MATCH.getMatchCount()));
        System.out.println("6개 일치 (2000000000원) - " + result.get(LottoMatchType.SIX_MATCH.getMatchCount()));
    }

    public void printEarningRate(int purchaseAmount) {
        double output = result.get(LottoMatchType.THREE_MATCH.getMatchCount()) * LottoMatchType.THREE_MATCH.getMoney()
                + result.get(LottoMatchType.FOUR_MATCH.getMatchCount()) * LottoMatchType.FOUR_MATCH.getMoney()
                + result.get(LottoMatchType.FIVE_MATCH.getMatchCount()) * LottoMatchType.FIVE_MATCH.getMoney()
                + result.get(LottoMatchType.SIX_MATCH.getMatchCount()) * LottoMatchType.SIX_MATCH.getMoney()
                + result.get(LottoMatchType.BONUS_MATCH.getMatchCount()) * LottoMatchType.BONUS_MATCH.getMoney();
        double input = purchaseAmount * 1000;

        System.out.println(String.format("%.2f", ((output - input) / input) * 100) + "%");
    }

}
