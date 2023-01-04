package kr.codesquad.lotto;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        boolean isLottoNumber = number >= 1 && number <= 45;
        if (!isLottoNumber) throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자만 입력 가능합니다.");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
