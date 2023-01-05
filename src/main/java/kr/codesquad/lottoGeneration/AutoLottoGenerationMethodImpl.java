package kr.codesquad.lottoGeneration;

import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoLottoGenerationMethodImpl implements LottoGenerationMethod{
    public AutoLottoGenerationMethodImpl() {}
    @Override
    public List<Lotto> realGenerate(int count) {
        List<Lotto> autoLottos = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++)  {
            numbers.add(i);
        }
        for(int i = 0; i < count; i++) {
            List<LottoNumber> lottoNumbers = new ArrayList<>();
            Collections.shuffle(numbers);
            for(Integer number : numbers.subList(0, Lotto.NUMBER_COUNT)) {
                lottoNumbers.add(LottoNumber.of(number));
            }
            autoLottos.add(Lotto.of(lottoNumbers));
        }

        return autoLottos;
    }
}
