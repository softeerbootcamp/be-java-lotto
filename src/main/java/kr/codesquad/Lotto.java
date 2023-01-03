package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public List<Integer> numberList = new ArrayList<>();
    public static final int LOTTO_NUM_BOUND = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    public int correctNumCnt(WinNum winNum) {
        List<Integer> temp = this.numberList;
        temp.retainAll(winNum.num);
        return temp.size();
    }

    public List<Lotto> makeLottoNum(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i=0;i<amount;i++) {
            Lotto lotto = makeRandomLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    public Lotto makeRandomLotto() {
        Lotto lotto = new Lotto();
        lotto.numberList.addAll(makeRandomNum());
        return lotto;
    }

    private List<Integer> makeRandomNum() {
        List<Integer> allNumber = new ArrayList<>();
        for(int i=1;i<=LOTTO_NUM_BOUND;i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }

    public int[] lottoResult(WinNum winNum, List<Lotto> lottoList) {
        int [] correctCnt = new int[7];
        for(int i=0;i<lottoList.size();i++) {
            correctCnt[lottoList.get(i).correctNumCnt(winNum)]++;
        }
        return correctCnt;
    }

}
