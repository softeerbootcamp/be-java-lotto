package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;

    List<Integer> lotto = new ArrayList<>();

    public Lotto() {
        List<Integer> nums = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lotto.add(nums.get(i));
        }
        Collections.sort(lotto);
    }

    public List<Integer> getLotto() {
        return lotto;
    }

}
