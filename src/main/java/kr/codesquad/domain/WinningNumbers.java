package kr.codesquad.domain;

import kr.codesquad.exception.WinningNumbersException;

import java.util.List;

public class WinningNumbers {
    private final Row row;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Row row, LottoNumber bonusNumber) {
        this.row = row;
        this.bonusNumber = isValidBonusNumber(bonusNumber);
    }

    private LottoNumber isValidBonusNumber(LottoNumber bonusNumber) {
        List<LottoNumber> values = row.getValues();
        for (LottoNumber value : row.getValues()) {
            if (value.compareTo(bonusNumber) == 0) {
                throw new WinningNumbersException();
            }

        }
        return bonusNumber;
    }


    public Row getRow() {
        return row;
    }

    public int getBonusNum() {
        return bonusNumber.getNumber();
    }
}
