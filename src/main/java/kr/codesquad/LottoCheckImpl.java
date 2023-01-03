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
            Set<Integer> lottoSet = new HashSet<>(lotto);
            Rank rank = this.calcTargetedNumberCount(lottoSet, winNumberList);
            if (rank == null) continue;
            int totalCnt = rankStatus.getOrDefault(rank, rank.ordinal());
            rankStatus.put(rank, totalCnt + 1);
        }
        this.printResult(rankStatus, lottoTicket.getMoney());
    }

    private List<Integer> getWinNumberList() throws IOException {
        System.out.println("\n당첨 번호를 입력하세요.");
        List<Integer> winNumList = new ArrayList<>(7);
        String[] winNumArr  = br.readLine().replaceAll(" ", "").split(",");
        for (String winNum: winNumArr) winNumList.add(Integer.parseInt(winNum));
        System.out.println("보너스 번호를 입력하세요.");
        int bonus = Integer.parseInt(br.readLine());
        winNumList.add(bonus);
        return winNumList;
    }

    private Rank calcTargetedNumberCount(Set<Integer> lotto, List<Integer> winNumList) {
        int winNumCnt = 0;
        for (int idx = 0; idx < 6; idx++) {
            Integer winNum = winNumList.get(idx);
            if (lotto.contains(winNum)) winNumCnt++;
        }
        boolean isBonus = lotto.contains(winNumList.get(6));
        return Rank.valueOf(winNumCnt, isBonus);
    }

    private void printResult(Map<Rank, Integer> rankStatus, int money) {
        System.out.println("\n당첨 통계\n---------");
        int totalPrice = 0;
        for (Rank rank: Rank.values()) {
            totalPrice += rank.getWinningMoney() * rankStatus.get(rank);
            String stringOfBonus = rank.isBonus() ? ", 보너스 볼 일치" : "";
            System.out.println(rank.getCountOfMatch() + "개 일치" + stringOfBonus + "(" + rank.getWinningMoney() + "원) - " + rankStatus.get(rank) + "개");
        }
        double rate = (((double) totalPrice - money) / (double) money) * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "%입니다.");
    }
}
