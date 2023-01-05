package kr.codesquad.domain.lotto;

public class LottoNumber {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || this.getClass() != obj.getClass()) return false;
        LottoNumber that = (LottoNumber) obj;
        return lottoNumber == that.lottoNumber;
    }

}
