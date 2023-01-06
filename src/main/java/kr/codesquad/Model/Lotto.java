package kr.codesquad.Model;

import kr.codesquad.Exception.InvalidLottoNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<LottoNumber> lotto;
    int bonusBall;

    public Lotto(){
        lotto = new ArrayList<>();
        bonusBall = 0;
    }

    public Lotto(List<LottoNumber> lotto){
        if(lotto.size() != 6){
            throw new InvalidLottoNumberException("번호 개수가 안맞아요\n");
        }
        this.lotto = lotto;
    }

    public static Lotto of(List<Integer> lottoNumbers){
        List<LottoNumber> lotto = new ArrayList<>();
        for(Integer number : lottoNumbers){
            lotto.add(LottoNumber.of(number));
        }
        return new Lotto(lotto);
    }

    public List<Integer> toListInteger(){
        List<Integer> integerList = new ArrayList<>();
        for(int i = 0;i <6;i++){
            integerList.add(lotto.get(i).getNo());
        }
        return integerList;
    }

    boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    int increment(LottoNumber lottoNumber) {
        if (contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
