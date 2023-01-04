package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static kr.codesquad.AutoLottosGenerator.LOTTO_NUM_CNT;

public class Lotto {
    private final List<Integer> nums;

    Lotto(List<Integer> lottoNumber){
        if (lottoNumber.size() != LOTTO_NUM_CNT) {
            throw new IllegalArgumentException();
        }

        this.nums = lottoNumber;
    }
    public int match(Lotto lotto) {
        long cnt = lotto.nums.stream().filter(w -> nums.contains(w)).count();
        return (int)cnt;
    }
    public boolean checkBonus(int bonus){
        return nums.contains(bonus);
    }
    @Override
    public String toString(){
        return nums.toString();
    }
}
