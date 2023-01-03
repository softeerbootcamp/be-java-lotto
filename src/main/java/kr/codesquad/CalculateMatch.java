package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateMatch {

    private ArrayList<ArrayList<Integer>> randomLottoList;
    private ArrayList<Integer> myLottoList;
    private static HashMap<Integer, Integer> hitNums = new HashMap<>();
    private static int bonusNum;
    private static int BONUM_NUM = 777;
    private static Fee[] feeList = {Fee.FIRST, Fee.SECOND, Fee.THIRD, Fee.FOURTH, Fee.FIFTH};

    public CalculateMatch(ArrayList<ArrayList<Integer>> randomLottoList, ArrayList<Integer> myLottoList, int bonusNum) {
        this.randomLottoList = randomLottoList;
        this.myLottoList = myLottoList;
        this.bonusNum = bonusNum;
    }

    private int containNum(int target, ArrayList<Integer> tempList){
        if (tempList.contains(target))
            return 1;
        return 0;
    }

    private void getHitStatistics(ArrayList<Integer> randomLotto) {
        int hitNum = 0;
        for(int i = 0; i < 6; i++) {
            hitNum += containNum(myLottoList.get(i), randomLotto);
        }
        if(hitNum == 5 && containNum(this.bonusNum, randomLotto) == 1){
            hitNums.put(BONUM_NUM, hitNums.getOrDefault(BONUM_NUM, 0) + 1);
            return;
        }
        hitNums.put(hitNum, hitNums.getOrDefault(hitNum, 0) + 1);
    }

    public void startCalculate(int numOfLotto){
        for(int i = 0; i < numOfLotto; i++)
            getHitStatistics(randomLottoList.get(i));
    }

    //print result of all lotteries
    public void printResult(int purchasedPrice) {
        int hitPrice = 0;
        for(int rank = 4; rank >= 0; rank--){
            int hitNum = hitNums.getOrDefault(feeList[rank].getNumOfItem(), 0);
            System.out.printf("%s - %d개\n", feeList[rank].getScript(), hitNum);
            hitPrice += hitNum * feeList[rank].getPrice();
        }
        int profit = hitPrice - purchasedPrice;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (float)profit/purchasedPrice*100);
    }

}
