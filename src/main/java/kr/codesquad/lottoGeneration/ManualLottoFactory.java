package kr.codesquad.lottoGeneration;

import kr.codesquad.IO.Input;
import kr.codesquad.IO.InputImpl;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoFactory implements LottoFactory{
    private final Input Input;

    public ManualLottoFactory() {
        this.Input = new InputImpl();
    }
    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> lottos = new ArrayList<>();
        List<List<LottoNumber>> manualLottoNumbersList = Input.manualLottoNumbersInput(count);
        for(List<LottoNumber> numbers : manualLottoNumbersList) {
            lottos.add(Lotto.of(numbers));
        }

        return lottos;
    }
}
