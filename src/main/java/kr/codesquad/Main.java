package kr.codesquad;

import kr.codesquad.input.InputImpl;

public class Main{

    public static void main(String[] args) {
        LottoGame lottoGame = LottoGame.of(new InputImpl());
    }
}