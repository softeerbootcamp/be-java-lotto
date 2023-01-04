package kr.codesquad.lotto;

import kr.codesquad.input.Input;

public class AutoLotto extends Lotto{
    public AutoLotto(Input input) {
        super(input);
    }

    @Override
    public Lotto fillLottoNumbers() {
        //return shuffled list
        return null;
    }
}
