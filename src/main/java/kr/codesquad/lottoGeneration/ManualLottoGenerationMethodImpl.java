package kr.codesquad.lottoGeneration;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.Lotto;
import kr.codesquad.lotto.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerationMethodImpl implements LottoGenerationMethod{
    private final Input input;
    public ManualLottoGenerationMethodImpl(Input input) {
        this.input = input;
    }
    @Override
    public List<Lotto> realGenerate(int count) {
        List<Lotto> manualLottos = new ArrayList<>();
        if(count > 0) {
            System.out.println("수동으로 구매할 숫자를 입력하세요");
            for (int i = 0; i < count; i++) {
                List<LottoNumber> list = this.input.manualLottoNumbersInput();
                manualLottos.add(Lotto.of(list));
            }
        }

        return manualLottos;
    }
}
