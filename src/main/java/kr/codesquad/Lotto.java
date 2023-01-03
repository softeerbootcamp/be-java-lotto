package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> nums;
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_CNT = 6;

    Lotto(){
        List<Integer> temp = IntStream.range(1, LOTTO_NUM_MAX+1).boxed().collect(Collectors.toList());
        Collections.shuffle(temp);
        nums = new ArrayList<>(temp.subList(0,LOTTO_NUM_CNT+1));
        Collections.sort(nums);
    }

    public int checkWin(List<Integer> win) {
        long cnt = win.stream().filter(w -> nums.contains(w)).count();
        return (int)cnt;
    }
    public boolean checkBonus(int bonus){
        return nums.contains(bonus);
    }
    public void printLotto(){
        System.out.println(nums);
    }
}
