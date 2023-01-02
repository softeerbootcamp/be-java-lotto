package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    public ArrayList<Integer> nums;
    Lotto(){
        ArrayList<Integer> n = new ArrayList<>();
        for(int i=1; i<=45; i++)
            n.add(i);
        Collections.shuffle(n);
        nums = new ArrayList<Integer>();
        for(int i=0; i<6; i++)
            nums.add(n.get(i));
        Collections.sort(nums);
    }
//    Lotto(int[] n){
//        nums = new ArrayList<Integer>();
//        for(int i=0; i<6; i++)
//            nums.add(n[i]);
//    }
    public int checkWin(int[] win) {
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            cnt += nums.contains(win[i]) ? 1 : 0;
        }
        return cnt;
    }
    public void printLotto(){
        System.out.println(nums);
    }
}
