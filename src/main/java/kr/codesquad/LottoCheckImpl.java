package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LottoCheckImpl implements LottoCheck {

    private final BufferedReader br;

    public LottoCheckImpl() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void check(LottoTicket lottoTicket) throws IOException {
        List<Integer> winNumberList = this.getWinNumberList();
        Map<Rank, Integer> rankStatus = new HashMap<>(Rank.getInitRankStatus());
        for (List<Integer> lotto: lottoTicket.getLottoList()) {
            int winNumber = this.calcTargetedNumberCount(lotto, winNumberList);
            boolean isBonus = this.hasBonusNumber(lotto, -1);
            Rank rank = Rank.valueOf(winNumber, isBonus);
            int totalCnt = rankStatus.getOrDefault(rank, winNumber);
            rankStatus.put(rank, totalCnt + 1);
        }
        this.printResult(rankStatus, lottoTicket.getMoney());
    }

    private List<Integer> getWinNumberList() throws IOException {
        System.out.println("\n당첨 번호를 입력하세요.");
        List<Integer> winNumList = new ArrayList<>(6);
        String[] winNumArr  = br.readLine().replaceAll(" ", "").split(",");
        for (String winNum: winNumArr) winNumList.add(Integer.parseInt(winNum));
        return winNumList;
    }

    private int calcTargetedNumberCount(List<Integer> lotto, List<Integer> winNumList) {
        int winNumCnt = 0;
        for (Integer winNum: winNumList) {
            if (lotto.contains(winNum)) winNumCnt++;
        }
        return winNumCnt;
    }

    private void printResult(Map<Rank, Integer> rankStatus, int money) {
        System.out.println("\n당첨 통계\n---------");
        int totalPrice = 0;
        for (Rank rank: Rank.values()) {
            totalPrice += rank.ordinal() * rankStatus.get(rank);
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원) - " + rankStatus.get(rank) + "개");
        }
        double rate = (((double) totalPrice - money) / (double) money) * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "%입니다.");
    }

    private boolean hasBonusNumber(List<Integer> lotto, int bonusNumber) {
        return false;
    }
}
