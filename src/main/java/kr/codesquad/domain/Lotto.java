package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private int inputMoney;
    private final List<Row> totalLotto = new ArrayList<>();

    public static Lotto createLotto(List<Row> rows, int inputMoney) {
        Lotto lotto = new Lotto();
        lotto.add(rows);
        lotto.inputMoney = inputMoney;
        return lotto;
    }

    public void add(List<Row> rows) {
        this.totalLotto.addAll(rows);
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
