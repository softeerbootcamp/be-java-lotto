package kr.codesquad.model.lotto;

import java.util.List;

public class ManualLotto extends Lotto {

    public ManualLotto(List<Integer> manualGeneratedNumbers) {
        this.numbers = makeLotto(manualGeneratedNumbers);
        validLotto();
    }

    /**
     * 사용자로 부터 받아와야함
     */
    @Override
    protected List<Integer> makeLotto(List<Integer> numbers) {
        return sortNumbers(numbers);
    }
}
