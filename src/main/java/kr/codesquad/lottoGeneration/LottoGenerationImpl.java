package kr.codesquad.lottoGeneration;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.Lotto;
import java.util.List;

public class LottoGenerationImpl implements LottoGeneration{
    private final int count;
    private LottoGenerationMethod method;
    private final Input input;

    private LottoGenerationImpl(int count, LottoGenerationMethod method, Input input) {
        this.count = count;
        this.method = method;
        this.input = input;
    }

    public static LottoGenerationImpl of(int count, LottoGenerationMethod method, Input input) {
        return new LottoGenerationImpl(count, method, input);
    }

    @Override
    public List<Lotto> generate() {
            return method.realGenerate(this.count);
    }
}

