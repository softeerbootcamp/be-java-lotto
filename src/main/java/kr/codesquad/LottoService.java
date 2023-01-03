package kr.codesquad;

import java.util.*;

public class LottoService {

    public static final int LOTTO_NUM_BOUND = 45;
    public static final int LOTTO_NUM_COUNT = 6;

    public List<Lotto> makeLottoList(int amount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
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
        for (int i = 1; i <= LOTTO_NUM_BOUND; i++) {
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);
        List<Integer> randNum = new ArrayList<>();
        randNum.addAll(allNumber.subList(0, LOTTO_NUM_COUNT));
        Collections.sort(randNum);
        return randNum;
    }

    public int[] lottoResult( List<Lotto> lottoList, Lotto winNum) {
        int[] correctCnt = new int[7];
        for (int i = 0; i < lottoList.size(); i++) {
            correctCnt[lottoList.get(i).correctNumCnt(winNum)]++;
        }
        return correctCnt;
    }

}
