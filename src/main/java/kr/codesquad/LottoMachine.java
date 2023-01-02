package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private final List<Integer> numList;
    private final int priceOfLotto;

    private final List<Integer> moneyOfLottoList = List.of(0 ,0, 0, 5000, 50000, 1500000, 2000000000);

    private final BufferedReader br;

    public LottoMachine(int priceOfLotto) {
        this.numList = new ArrayList<>(45);
        for (int idx = 1; idx <= 45; idx++) numList.add(idx);
        this.priceOfLotto = priceOfLotto;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public LottoTicket buy() throws IOException {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(br.readLine());
        int lottoCnt = money / priceOfLotto;
        List<List<Integer>> lottoList = new ArrayList<>(lottoCnt);
        for (int idx = 0; idx < lottoCnt; idx++) {
            lottoList.add(shuffle());
        }
        System.out.println(lottoCnt + "개를 구매했습니다.");
        lottoList.forEach(System.out::println);
        return new LottoTicket(lottoList, lottoCnt * priceOfLotto);
    }


    public void checkWin(LottoTicket lottoTicket) throws IOException {
        List<Integer> winNumberList = this.getWinNumberList();
        List<Integer> rankList = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        for (List<Integer> lotto: lottoTicket.getLottoList()) {
            int winNumber = this.calcTargetedNumberCount(lotto, winNumberList);
            int totalCnt = rankList.get(winNumber) + 1;
            rankList.set(winNumber, totalCnt);
        }
        this.printResult(rankList, lottoTicket.getMoney());
    }

    private List<Integer> shuffle() {
        List<Integer> numberList = new ArrayList<>(numList);
        Collections.shuffle(numberList);
        return numberList.subList(0, 6);
    }

    private List<Integer> getWinNumberList() throws IOException {
        System.out.println("\n당첨 번호를 입력하세요.");
        List<Integer> winNumSet = new ArrayList<>(6);
        String[] winNumArr  = br.readLine().replaceAll(" ", "").split(",");
        for (String winNum: winNumArr) winNumSet.add(Integer.parseInt(winNum));
        return winNumSet;
    }

    private int calcTargetedNumberCount(List<Integer> lotto, List<Integer> winNumSet) {
        int winNumCnt = 0;
        for (Integer winNum: winNumSet) {
            if (lotto.contains(winNum)) winNumCnt++;
        }
        return winNumCnt;
    }

    private void printResult(List<Integer> rankStatus, int money) {
        System.out.println("\n당첨 통계\n---------");
        int totalPrice = 0;
        for (int idx = 3; idx < 7; idx++) {
            totalPrice += moneyOfLottoList.get(idx) * rankStatus.get(idx);
            System.out.println(idx + "개 일치 (" + moneyOfLottoList.get(idx) + "원) - " + rankStatus.get(idx) + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", (((double) totalPrice - money) / (double) money) * 100) + "%입니다." );
    }
}
