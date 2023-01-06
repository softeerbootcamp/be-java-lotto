package kr.codesquad.domain;

import kr.codesquad.exception.ColumnNotValidException;
import kr.codesquad.exception.DuplicateLottoNumberException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static kr.codesquad.domain.Row.RowValidator.*;

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

    public void compare(WinningNumbers winningNumbers) {
        List<LottoNumber> answers = winningNumbers.getRow().values;
        for (LottoNumber answer : answers) {
            compareNumber(answer);
        }

        compareBonusNumber(winningNumbers.getBonusNumber());
    }

    public void compareNumber(LottoNumber answer) {
        for (LottoNumber value : values) {
            if (value.getNumber() == answer.getNumber()) {
                this.match++;
            }
        }
    }

    public void compareBonusNumber(LottoNumber bonusNumber) {
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

    static class RowValidator {
        static List<Integer> extractIntegersList(List<LottoNumber> numbers) {
            return numbers.stream()
                    .map(LottoNumber::getNumber)
                    .collect(Collectors.toList());
        }

        static void lottoIntegersDuplicateCheck(List<Integer> numList) {
            Set<Integer> numSet = new HashSet<>(numList);
            if (numSet.size() != numList.size()) {
                throw new DuplicateLottoNumberException();
            }
        }

        static void checkValuesOverColumn(List<LottoNumber> numbers) {
            if (numbers.size() != COLUMN) {
                throw new ColumnNotValidException();
            }
        }
    }

}
