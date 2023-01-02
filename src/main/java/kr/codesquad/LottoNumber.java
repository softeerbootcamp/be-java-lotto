package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class LottoNumber {
    ArrayList<Integer> lotto = new ArrayList<>();

    public LottoNumber () {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= 45; ++i) { nums.add(i); }
        Collections.shuffle(nums);
        for(int i =0; i < 6; i++) { lotto.add(nums.get(i)); }
        Collections.sort(lotto);
    }

    public ArrayList<Integer> getLotto() {
        return lotto;
    }

}
