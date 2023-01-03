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
    public LottoResult check(LottoTicket lottoTicket) throws IOException {
        List<Integer> winNumberList = this.getWinNumberList();
        Map<Rank, Integer> rankStatus = new HashMap<>(Rank.getInitRankStatus());
        for (List<Integer> lotto: lottoTicket.getLottoList()) {
            Rank rank = this.calcTargetedNumberCount(new HashSet<>(lotto), winNumberList);
            if (rank == null) continue;
            int totalCnt = rankStatus.getOrDefault(rank, rank.ordinal());
            rankStatus.put(rank, totalCnt + 1);
        }
        double rate = this.calcRate(rankStatus, lottoTicket.getMoney());
        return new LottoResult(rankStatus, rate);
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

    private double calcRate(Map<Rank, Integer> rankStatus, int money) {
        int totalMoney = 0;
        for (Rank rank: Rank.values()) {
            totalMoney += rank.getWinningMoney() * rankStatus.get(rank);
        }
        return (((double) totalMoney - money) / (double) money) * 100;
    }
}
