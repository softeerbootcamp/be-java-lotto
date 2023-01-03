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

}
