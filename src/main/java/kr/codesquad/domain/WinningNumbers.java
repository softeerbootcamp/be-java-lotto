package kr.codesquad.domain;

public class WinningNumbers {
    private final Row row;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Row row, LottoNumber bonusNumber) {
        this.row = row;
        this.bonusNumber = bonusNumber;
    }

    public Row getRow() {
        return row;
    }

    public int getBonusNum() {
        return bonusNumber.getNumber();
    }
}
