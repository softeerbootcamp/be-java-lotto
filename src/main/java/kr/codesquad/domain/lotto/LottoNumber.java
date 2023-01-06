package kr.codesquad.domain.lotto;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;


    public LottoNumber (int lottoNumber) {
        checkLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void checkLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_MIN_NUMBER || lottoNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 번호가 될 수 없는 숫자입니다.");
        }
    }

    public boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        LottoNumber that = (LottoNumber) obj;
        return lottoNumber == that.lottoNumber;
    }
}
