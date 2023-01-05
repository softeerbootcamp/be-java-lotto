package kr.codesquad.domain;

import java.util.*;

public class Row {

    private final List<LottoNumber> values = new ArrayList<>();
    private int match;
    private boolean isBonus;
    public static final int COLUMN = 6;


    public static Row createRow(List<LottoNumber> numbers) {
        Row row = new Row();
        row.addValues(numbers);
        return row;
    }

    public void compare(WinningNumbers winningNumbers) {
        List<LottoNumber> answers = winningNumbers.getRow().values;
        for (LottoNumber answer : answers) {
            compareNumber(answer);
        }

        compareBonusNumber(winningNumbers.getBonusNum());
    }

    public void compareNumber(LottoNumber answer) {
        for (LottoNumber value : values) {
            if (value.getNumber() == answer.getNumber()) {
                this.match++;
            }
        }
    }

    public void compareBonusNumber(int bonusNumber) {
        this.isBonus = this.values.contains(bonusNumber);
    }

    public void addValues(List<LottoNumber> num) {
        values.addAll(num);
    }

    public int getMatch() {
        return match;
    }

    public List<LottoNumber> getValues() {
        return values;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void printValues() {
        System.out.println(values);
    }
}
