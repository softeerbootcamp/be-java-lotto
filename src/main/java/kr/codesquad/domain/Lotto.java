package kr.codesquad.domain;

import kr.codesquad.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final Money money;
    private final List<Row> totalLotto = new ArrayList<>();

    public Lotto(Money money) {
        this.money = money;
    }

    public void addRowToLotto(int count, LottoGenerator lottoGenerator) {
        for (int i = 0; i < count; i++) {
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

    public Money getMoney() {
        return money;
    }

}
