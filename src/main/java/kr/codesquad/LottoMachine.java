package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LottoMachine {

    private final Set<Integer> numSet;
    private final int priceOfLotto;

    private final BufferedReader br;

    private List<List<Integer>> lottoList;
    private int money;

    public LottoMachine(int priceOfLotto) {
        this.numSet = new HashSet<>(45);
        for (int idx = 1; idx <= 45; idx++) numSet.add(idx);
        this.priceOfLotto = priceOfLotto;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public List<List<Integer>> buy(int total) {
        int cnt = total / priceOfLotto;
        this.money = cnt * priceOfLotto;

        List<List<Integer>> lottoList = new ArrayList<>(cnt);
        for (int idx = 0; idx < cnt; idx++) {
            lottoList.add(shuffle());
        }
        this.lottoList = lottoList;
        return this.lottoList;
    }


    public void checkWin(List<List<Integer>> lottoList) {
        Set<Integer> winNumSet = this.getWinNumberSet();
        Map<Rank, Integer> rankStatus = new HashMap<>(lottoList.size());
        for (List<Integer> lotto: lottoList) {
            int winNumber = this.calcTargetedNumberCount(lotto, winNumSet);
            Rank rank = Rank.valueOf(winNumber);
            if (rank == null) continue;
            int totalCnt = rankStatus.containsKey(rank) ? rankStatus.get(rank) + 1 : 1;
            rankStatus.put(rank, totalCnt);
        }
    }

    private List<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numSet);
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }

    private Set<Integer> getWinNumberSet() {
        System.out.println("당첨 번호를 입력하세요.");
        Set<Integer> winNumSet = new HashSet<>(6);
        try {
            String[] winNumArr  = br.readLine().split(" ");
            for (String winNum: winNumArr) winNumSet.add(Integer.parseInt(winNum));
            return winNumSet;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int calcTargetedNumberCount(List<Integer> lotto, Set<Integer> winNumSet) {
        int winNumCnt = 0;
        for (Integer winNum: winNumSet) {
            if (lotto.contains(winNum)) winNumCnt++;
        }
        return winNumCnt;
    }
}
