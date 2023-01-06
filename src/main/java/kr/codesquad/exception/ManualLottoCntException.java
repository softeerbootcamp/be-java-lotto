package kr.codesquad.exception;

public class ManualLottoCntException extends LottoException{
    private static final String MESSAGE = "수동으로 구매할 로또 수는 0 이상 ";

    public ManualLottoCntException(int totalCnt) {
        super(MESSAGE + totalCnt + " 이하여야 합니다.");
    }
}
