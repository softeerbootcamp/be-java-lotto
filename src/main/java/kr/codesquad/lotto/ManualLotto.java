package kr.codesquad.lotto;

import kr.codesquad.input.Input;

public class ManualLotto extends Lotto{
    public ManualLotto(Input input) {
        super(input);
    }

    @Override
    public Lotto fillLottoNumbers() {
        //get user input using InputImpl
        return null;
    }
}