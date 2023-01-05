package kr.codesquad.domain;

import kr.codesquad.exception.ColumnOverflowException;
import kr.codesquad.exception.DuplicateLottoNumberException;

import java.util.*;
import java.util.stream.Collectors;

public class Row {

    private final List<LottoNumber> values = new ArrayList<>();
    private int match;
    private boolean isBonus;
    public static final int COLUMN = 6;

    protected Row(List<LottoNumber> numbers) {
        this.addValues(numbers);
    }

    public static Row createRow(List<LottoNumber> numbers) {
        lottoIntegersDuplicateCheck(extractIntegersList(numbers));
        checkValuesOverColumn(numbers);
        return new Row(numbers);
    }

    private static List<Integer> extractIntegersList(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    private static void checkValuesOverColumn(List<LottoNumber> numbers) {
        if (numbers.size() != COLUMN) {
            throw new ColumnOverflowException();
        }
    }

    public static void lottoIntegersDuplicateCheck(List<Integer> numList) {
        Set<Integer> numSet = new HashSet<>(numList);

        if (numSet.size() != numList.size()) {
            throw new DuplicateLottoNumberException();
        }
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
