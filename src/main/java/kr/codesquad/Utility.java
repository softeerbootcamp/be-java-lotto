package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class Utility {
    private static ArrayList<Integer> allLottoNum;

    public void setAllLottoNum() {
        this.allLottoNum = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.allLottoNum.add(i);
        }
    }

    public ArrayList<Integer> retRandLottoNum() {
        setAllLottoNum();
        Collections.shuffle(this.allLottoNum);
        ArrayList<Integer> lottoNums = new ArrayList<>(Lotto_Info.LOTTO_SIZE.getValue());
        for (int i = 0; i < Lotto_Info.LOTTO_SIZE.getValue(); i++) {
            lottoNums.add(this.allLottoNum.get(i));
        }
        return lottoNums;
    }
    public void printProfit(int[] jk, int money) {
        double prof, sum = 0;
        int flag = 0;
        System.out.println("\n당첨통계\n---------");
        for (Prizes_Info pr : Prizes_Info.values()) {
            pr.printPrizeByFlag(jk[flag]);
            sum += pr.getValue() * jk[flag];
            flag++;
        }
        prof = (double) ((sum - money) / money);
        System.out.printf("총 수익률은 : %.2f%%입니다\n", prof * 100);
    }
}
