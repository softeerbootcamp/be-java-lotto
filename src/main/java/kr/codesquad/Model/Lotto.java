package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_LENGTH = 6;
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;
    public static final String LOTTO_PRICE = "1000";
    public Integer[] num = new Integer[LOTTO_NUM_LENGTH];
    public static List<Integer> lottoNum = new ArrayList();

    public static void initLotto() {
        for(int i = LOTTO_START_NUM; i <= LOTTO_END_NUM; ++i) {
            lottoNum.add(i);
        }

    }

    Lotto(List<Integer> lottoNum) {
        for(int i = 0; i < LOTTO_NUM_LENGTH; ++i) {
            this.num[i] = lottoNum.get(i);
        }

        Arrays.sort(num);
    }
}
