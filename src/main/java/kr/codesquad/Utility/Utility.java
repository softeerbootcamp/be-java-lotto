package kr.codesquad.Utility;

import kr.codesquad.CustomException;
import kr.codesquad.Enum.Prizes_Info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility extends CustomException{
    private static ArrayList<Integer> allLottoNum;

    static int LOTTO_PRICE = 1000;

    static int LOTTO_SIZE = 6;

    public Utility() {
        setAllLottoNum();
    }

    public int getLottoPrice() {
        return LOTTO_PRICE;
    }

    public void setAllLottoNum() {
        this.allLottoNum = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.allLottoNum.add(i);
        }
    }

    public List<Integer> retRandLottoNum() {
        Collections.shuffle(this.allLottoNum);
        ArrayList<Integer> lottoNums = new ArrayList<>(LOTTO_SIZE);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNums.add(this.allLottoNum.get(i));
        }
        return lottoNums;
    }

    public List<Integer> transManualInputToLottoList(String str) {
        String[] strArr = str.split(",");
        numberCountSix(strArr);
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < strArr.length; i++) {
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
