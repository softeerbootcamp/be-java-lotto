package kr.codesquad;

import java.util.ArrayList;

public class Lotto {
    private final ArrayList<Integer> lottoNums;

    public Lotto(){
        lottoNums = Utility.generateRandomSixNumbers();
        System.out.println(lottoNums);
    }

    public int getRightCount(ArrayList<Integer> prize_nums){
        int count = 0;
        for(Integer expect_no : lottoNums){
            count = countUpIfContain(prize_nums, expect_no, count);
        }
        return count;
    }

    public int countUpIfContain(ArrayList<Integer> prize_nums, int expect_no, int count){
        if(prize_nums.contains(expect_no))
            count += 1;
        return count;
    }

    public static int getMoneyByCount(int correct_count){
        int[] result = {0,0,0,5000,50000,1500000, 2000000000};
        return result[correct_count];
    }

}
