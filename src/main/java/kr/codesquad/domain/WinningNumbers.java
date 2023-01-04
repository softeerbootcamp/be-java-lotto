package kr.codesquad.domain;

public class WinningNumbers {
    private final Row row;
    private final int bonusNum;

    public WinningNumbers(Row row, int bonusNum) {
        this.row = row;
        this.bonusNum = bonusNum;
    }

    public Row getRow() {
        return row;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
