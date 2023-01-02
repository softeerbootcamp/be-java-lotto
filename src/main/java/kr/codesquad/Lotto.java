package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {
    private List<Integer> nums = new ArrayList<>();
    private static final int LOTTO_NUM_MAX = 45;
    private static final int LOTTO_NUM_CNT = 6;

    Lotto(){
        List<Integer> temp = IntStream.range(1, LOTTO_NUM_MAX+1)
        ArrayList<Integer> n = new ArrayList<>();
        for(int i=1; i<=LOTTO_NUM_MAX; i++)
            n.add(i);
        Collections.shuffle(n);
        nums = new ArrayList<Integer>();
        for(int i=0; i<6; i++)
            nums.add(n.get(i));
        Collections.sort(nums);
    }

    public int checkWin(int[] win, int bonus) {
        int cnt = 0;
        for (int i = 0; i < LOTTO_NUM_CNT; i++) {
            cnt += nums.contains(win[i]) ? 1 : 0;
        }
        if(cnt == 5 && nums.contains(bonus)){

        }
        return cnt;
    }
    public void printLotto(){
        System.out.println(nums);
    }
}
