package kr.codesquad;

import kr.codesquad.Exceptions.CustomException;

import java.util.List;

import static kr.codesquad.Prize.*;

public class Lotto {
    private static final Prize[] prizes = {NOTHING, NOTHING, NOTHING, FIFTH, FORTH, THIRD, FIRST};
    private final List<Integer> lottoNums;

    public Lotto(){
        lottoNums = Utility.generateRandomSixNumbers();
        System.out.println(lottoNums);
    }

    public Lotto(List<Integer> lottoNums){
        if(lottoNums.size() != 6){
            throw new CustomException("로또 번호가 6자리가 아닙니다.");
        }
        this.lottoNums = lottoNums;
    }

    public Prize getPrize(Lotto prizeNums, int bonus){
        int count = 0;
        for(Integer expect_no : lottoNums){
            count = countUpIfContains(prizeNums.lottoNums, expect_no, count);
        }
        if(count == 5 && lottoNums.contains(bonus)){
            return SECOND;
        }
        return prizes[count];
    }

    public int countUpIfContains(List<Integer> arr, int target, int count){
        if(arr.contains(target))
            count += 1;
        return count;
    }


}
