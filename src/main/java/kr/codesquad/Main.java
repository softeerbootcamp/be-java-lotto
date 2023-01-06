package kr.codesquad;

import kr.codesquad.controller.LottoGameController;
import kr.codesquad.domain.generate.LottoGenerator;
import kr.codesquad.domain.generate.LottoGeneratorImpl;

public class Main {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGeneratorImpl();
        LottoGameController lottoGameController = new LottoGameController(lottoGenerator);
        lottoGameController.play();
    }
}