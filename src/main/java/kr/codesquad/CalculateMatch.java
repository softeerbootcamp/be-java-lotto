package kr.codesquad;

import kr.codesquad.impl.ResultLotto;
import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;
import java.util.HashMap;

public class CalculateMatch {

    private HashMap<Integer, Integer> hitNums = new HashMap<>();  //맞은 번호의 개수와 횟수
    private static int BONUM_NUM = 777;  //보너스 번호 (dummy)
    private Prize[] prizeList = {Prize.FIRST, Prize.SECOND, Prize.THIRD, Prize.FOURTH, Prize.FIFTH};


    private int containNum(int target, ArrayList<Integer> tempList){
        if (tempList.contains(target))
            return 1;
        return 0;
    }

    //맞은 숫자의 개수와 그 횟수를 계산
    private void getHitStatistics(ArrayList<Integer> randomLotto, ArrayList<Integer> myLotto,  int bonusNum) {
        int hitNum = 0;
        for(int i = 0; i < 6; i++) {
            hitNum += containNum(myLotto.get(i), randomLotto);
        }
        if(hitNum == 5 && containNum(bonusNum, randomLotto) == 1){  //2등 보너스볼일 경우
            hitNums.put(BONUM_NUM, hitNums.getOrDefault(BONUM_NUM, 0) + 1);
            return;
        }
        hitNums.put(hitNum, hitNums.getOrDefault(hitNum, 0) + 1);
    }

    //수동 로또와 자동 리스트를 합하여 리턴
    public ArrayList<ArrayList<Integer>> mergeLottos(LottoTmpl lotto1, LottoTmpl lotto2){
        ArrayList<ArrayList<Integer>> lottoList1 = lotto1.getLottoList();
        ArrayList<ArrayList<Integer>> lottoList2 = lotto1.getLottoList();
        lottoList1.addAll(lottoList2);
        return lottoList1;
    }

    //모든 로또 리스트에 대해 당첨 여부를 확인
    public void startCalculate(LottoTmpl randomLotto, LottoTmpl myLotto, ResultLotto resultLotto, int numOfLotto){
        ArrayList<ArrayList<Integer>> randomLottoList = mergeLottos(randomLotto, myLotto);
        ArrayList<Integer> myLottoList = myLotto.getLottoList().get(0);
        for(int i = 0; i < numOfLotto; i++)
            getHitStatistics(randomLottoList.get(i),myLottoList, resultLotto.getBonusNum());
    }

    //print result of all lotteries
    public void printResult(int purchasedPrice) {
        int hitPrice = 0; //당첨금
        //5등부터 1등까지 출력
        for(int rank = 5; rank >= 1; rank--){
            int hitNum = hitNums.getOrDefault(prizeList[rank-1].getNumOfItem(), 0); //당첨 횟수
            System.out.printf("%s - %d개\n", prizeList[rank-1].getScript(), hitNum);
            hitPrice += hitNum * prizeList[rank-1].getPrice();
        }
        int profit = hitPrice - purchasedPrice;
        System.out.printf("총 수익률은 %.2f%%입니다.\n", (float)profit/purchasedPrice*100);
    }

}
