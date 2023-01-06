package kr.codesquad;

import kr.codesquad.IO.InputImpl;
import kr.codesquad.IO.OutputImpl;
import kr.codesquad.exception.InputExceptionHandlerImpl;

public class Main{

    public static void main(String[] args) {
        LottoGame.of(new InputImpl(), new OutputImpl());
    }
}