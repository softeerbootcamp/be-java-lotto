package kr.codesquad;

import java.util.ArrayList;

public class Lotto {
    private final ArrayList<Integer> lottoNums;

    public Lotto(){
        lottoNums = Utility.generateRandomSixNumbers();
    }

    public int getRightCount(ArrayList<Integer> prize_nums){
        int count = 0;
        for(Integer expect_no : lottoNums){
            if(prize_nums.contains(expect_no))
                count += 1;
        }
        return count;
    }

    public static int getMoneyByCount(int correct_count){
        if(correct_count == 6){
            return 2000000000;
        }
        if(correct_count == 5){
            return 1500000;
        }
        if(correct_count == 4){
            return 50000;
        }
        if(correct_count == 3) {
            return 5000;
        }
        return 0;
    }

}
