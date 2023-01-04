package kr.codesquad;

import kr.codesquad.domain.*;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;

import java.io.IOException;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    //로또 초기화 및 발급
    public void issueLotto() throws IOException {
        //money 받아오기
        int money = Money.convertStringToMoney(inputView.inputMoney());
        //여기서 이제 정해지지 어떤 generator 가 될지
        //여기서 new Generator
    }
    //결과 출력
}
