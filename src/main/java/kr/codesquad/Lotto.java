package kr.codesquad;

import java.util.List;

import static kr.codesquad.Prize.*;

public class Lotto {
    private static final Prize[] prizes = {NOTHING, NOTHING, NOTHING, FIFTH, FORTH, THIRD, FIRST};
    private final List<Integer> lottoNums;

    public Lotto(){
        lottoNums = Utility.generateRandomSixNumbers();
        System.out.println(lottoNums);
    }

    public Prize getRightPrize(List<Integer> prize_nums, int bonus){
        int count = 0;
        for(Integer expect_no : lottoNums){
            count = countUpIfContain(prize_nums, expect_no, count);
        }
        if(count == 5 && lottoNums.contains(bonus)){
            return SECOND;
        }
        return prizes[count];
    }

    public int countUpIfContain(List<Integer> prize_nums, int expect_no, int count){
        if(prize_nums.contains(expect_no))
            count += 1;
        return count;
    }


}
