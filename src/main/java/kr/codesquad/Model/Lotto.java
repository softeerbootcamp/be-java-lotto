//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_LENGTH = 6;
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;
    public Integer[] num = new Integer[6];
    public static List<Integer> lottoNum = new ArrayList();

    public static void initLotto() {
        for(int i = 1; i <= 45; ++i) {
            lottoNum.add(i);
        }

    }

    Lotto(List<Integer> lottoNum) {
        for(int i = 0; i < 6; ++i) {
            this.num[i] = (Integer)lottoNum.get(i);
        }

        Arrays.sort(this.num);
    }
}
