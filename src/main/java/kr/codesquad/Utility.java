package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility {
    private static ArrayList<Integer> allLottoNum;

    public Utility() {
        setAllLottoNum();
    }

    public void setAllLottoNum() {
        this.allLottoNum = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.allLottoNum.add(i);
        }
    }
    public ArrayList<Integer> retRandLottoNum() {
        Collections.shuffle(this.allLottoNum);
        ArrayList<Integer> lottoNums = new ArrayList<>(Lotto_Info.LOTTO_SIZE.getValue());
        for (int i = 0; i < Lotto_Info.LOTTO_SIZE.getValue(); i++) {
            lottoNums.add(this.allLottoNum.get(i));
        }
        return lottoNums;
    }
    public List<Integer> transStringToIntegerList(String str){
        String[] strArr = str.split(",");
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i< strArr.length;i++){
            integerList.add(Integer.parseInt(strArr[i]));
        }
        return integerList;
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
