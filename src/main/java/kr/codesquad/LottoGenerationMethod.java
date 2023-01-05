package kr.codesquad;

import kr.codesquad.input.Input;
import kr.codesquad.lotto.AutoLotto;
import kr.codesquad.lotto.ManualLotto;
import kr.codesquad.lotto.Lotto;

public enum LottoGenerationMethod {
    AUTO(0),
    MANUAL(1);

    private int method;

    private LottoGenerationMethod(int method) {
        this.method = method;
    }

    public int getMethod() {
        return method;
    }

    public static Lotto generateLotto(int method, Input input) {
        if(method == AUTO.getMethod()) {
            return new AutoLotto(null);
        }
        if(method == MANUAL.getMethod()) {
            return new ManualLotto(input.manualLottoNumbersInput());
        }
        return null;
    }
}
