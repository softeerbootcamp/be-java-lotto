package kr.codesquad.domain;

import kr.codesquad.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private int inputMoney;
    private final List<Row> totalLotto = new ArrayList<>();

    public void addRowToLotto(int num, LottoGenerator lottoGenerator) {
        for (int i = 0; i < num; i++) {
            this.totalLotto.add(lottoGenerator.generateRow());
        }
    }


    public void printTotalLotto() {
        for (Row row : totalLotto) {
            List<Integer> values = row.getValues();
            System.out.println(values);
        }
    }

    public void compareLotto(WinningNumbers winningNumbers) {
        for (Row row : totalLotto) {
            row.compare(winningNumbers);
        }
    }

    public List<Row> getTotalLotto() {
        return totalLotto;
    }

    public int getInputMoney() {
        return inputMoney;
    }
}
