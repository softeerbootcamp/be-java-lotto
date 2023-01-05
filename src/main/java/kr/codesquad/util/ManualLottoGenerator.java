package kr.codesquad.util;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Money;
import kr.codesquad.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.calculateLottoCount(); i++) {
            lottos.add(lottoGenerate());
        }
        return lottos;
    }

    private Lotto lottoGenerate() {
        List<Integer> numberList = new ArrayList<>();
        String[] inputNumbers = InputView.inputManualLotto();
        for (String inputNumber : inputNumbers) {
            numberList.add(convertInputNumber(inputNumber));
        }
        return new Lotto(numberList);
    }

    private int convertInputNumber(String inputNumber) {
        //NumberFormatException 생각해야함
        return Integer.parseInt(inputNumber);
    }
}
