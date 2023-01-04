package kr.codesquad.Lotto;

import kr.codesquad.Exceptions.CustomException;
import kr.codesquad.Utility;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNums;

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

    public String toString() {
        return lottoNums.toString();
    }

    public List<Integer> getLottoNums(){
        return lottoNums;
    }
}
