package kr.codesquad.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumFactory {

    public static final int LOTTO_NUM_MIN_BOUND = 1;
    public static final int LOTTO_NUM_MAX_BOUND = 45;
    public static final int LOTTO_NUM_COUNT = 6;
    public List<Integer> makeRandomNum() {
        List<Integer> allNumber = new ArrayList<>();
        for (int i = LOTTO_NUM_MIN_BOUND; i <= LOTTO_NUM_MAX_BOUND; i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }
}
