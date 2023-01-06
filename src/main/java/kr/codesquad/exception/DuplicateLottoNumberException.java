package kr.codesquad.exception;

import kr.codesquad.lotto.Lotto;

public class DuplicateLottoNumberException extends RuntimeException{
    public DuplicateLottoNumberException() {
        super("로또 번호는 중복될 수 없으며 " + Lotto.NUMBER_COUNT + "개 숫자만 입력받을 수 있습니다");
    }
}
