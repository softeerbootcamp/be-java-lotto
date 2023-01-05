package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    static List<Integer> lottoNum = new ArrayList<>();  //로또 발행 번호 1~45
    {
        for (int i=Lotto.LOTTO_START_NUM; i<=Lotto.LOTTO_END_NUM; i++)
            lottoNum.add(i);
    }

    public static Lotto generateLotto(){
        Collections.shuffle(lottoNum);
        List<Integer> lottoNumList = setLottoNum(lottoNum);
        Lotto lotto = new Lotto(lottoNumList);
        return lotto;
    }

    private static List<Integer> setLottoNum(List<Integer> lottoNum) {
        List<Integer> number = new ArrayList<>();
        for (int i=0; i<6; i++)
            number.add(lottoNum.get(i));
        return number;
    }
}
