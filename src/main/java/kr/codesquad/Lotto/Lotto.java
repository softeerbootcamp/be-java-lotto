package kr.codesquad.Lotto;

import kr.codesquad.Exceptions.CustomException;
import kr.codesquad.Utility;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNums;

    public Lotto() {
        lottoNums = Utility.generateRandomSixNumbers();
        System.out.println(lottoNums);
    }

    public Lotto(List<Integer> lottoNums) {
        if (lottoNums.size() != 6) {
            throw new CustomException("로또 번호가 6자리가 아닙니다.");
        }
        this.lottoNums = lottoNums;
    }

    public Prize getPrize(WinLotto winLotto) {
        int count = 0;
        for (Integer expect_no : lottoNums) {
            count = countUpIfContains(winLotto.getLottoNums(), expect_no, count);
        }
        return Prize.getPrize(count, lottoNums.contains(winLotto.getBonusNo()));
    }

    public int countUpIfContains(List<Integer> arr, int target, int count) {
        if (arr.contains(target))
            count += 1;
        return count;
    }

    public String toString() {
        return lottoNums.toString();
    }

    public List<Integer> getLottoNums(){
        return lottoNums;
    }
}
