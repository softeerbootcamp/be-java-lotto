package kr.codesquad.domain;

import kr.codesquad.exception.WinningNumbersException;

public class WinningNumbers {
    private final Row row;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Row row, LottoNumber bonusNumber) {
        this.row = row;
        this.bonusNumber = isValidBonusNumber(bonusNumber);
    }

    private LottoNumber isValidBonusNumber(LottoNumber bonusNumber) {
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

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
