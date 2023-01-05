package kr.codesquad.lotto.factory;

import kr.codesquad.util.LottoUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumFactory {

    public List<Integer> makeRandomNum() {
        List<Integer> allNumber = new ArrayList<>();
        for (int i = LottoUtil.LOTTO_NUM_MIN_BOUND; i <= LottoUtil.LOTTO_NUM_MAX_BOUND; i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LottoUtil.LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }
}
