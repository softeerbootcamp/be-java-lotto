package kr.codesquad;

import java.util.List;

import static kr.codesquad.Prize.*;

public class Lotto {
    private final List<Integer> lottoNums;

    public Lotto(){
        lottoNums = Utility.generateRandomSixNumbers();
        System.out.println(lottoNums);
    }

    public int getRightCount(List<Integer> prize_nums){
        int count = 0;
        for(Integer expect_no : lottoNums){
            count = countUpIfContain(prize_nums, expect_no, count);
        }
        return count;
    }

    public int countUpIfContain(List<Integer> prize_nums, int expect_no, int count){
        if(prize_nums.contains(expect_no))
            count += 1;
        return count;
    }

    public static int getMoneyByCount(int correct_count){
        Prize[] result = {NOTHING, NOTHING, NOTHING, FORTH, THIRD, SECOND, FIRST};
        return result[correct_count].getMoney();
    }

}
