package kr.codesquad.lottoGeneration;

import kr.codesquad.exception.DuplicateLottoNumberException;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoFactory implements LottoFactory{
    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            numbers.add(i);
        }
        for(int i = 0; i < count; i++) {
            Collections.shuffle(numbers);
            lottos.add(Lotto.of(intToLottoNumber(numbers.subList(0,Lotto.NUMBER_COUNT))));
        }

        return lottos;
    }

    private List<LottoNumber> intToLottoNumber(List<Integer> list) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for(Integer number : list) {
            lottoNumbers.add(LottoNumber.of(number));
        }

        return lottoNumbers;
    }
}