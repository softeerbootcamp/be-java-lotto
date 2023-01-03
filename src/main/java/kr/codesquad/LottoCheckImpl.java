package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCheckImpl implements LottoCheck {

    private final BufferedReader br;

    public LottoCheckImpl() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }
    @Override
    public void check(LottoTicket lottoTicket) throws IOException {
        List<Integer> winNumberList = this.getWinNumberList();
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));
        for (List<Integer> lotto: lottoTicket.getLottoList()) {
            int winNumber = this.calcTargetedNumberCount(lotto, winNumberList);
            int totalCnt = result.get(winNumber) + 1;
            result.set(winNumber, totalCnt);
        }
        this.printResult(result, lottoTicket.getMoney());
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

    private void printResult(List<Integer> rankStatus, int money) {
        System.out.println("\n당첨 통계\n---------");
        int totalPrice = 0;
        for (int idx = 3; idx < 7; idx++) {
            totalPrice += moneyOfLottoList.get(idx) * rankStatus.get(idx);
            System.out.println(idx + "개 일치 (" + moneyOfLottoList.get(idx) + "원) - " + rankStatus.get(idx) + "개");
        }
        double rate = (((double) totalPrice - money) / (double) money) * 100;
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "%입니다.");
    }
}
