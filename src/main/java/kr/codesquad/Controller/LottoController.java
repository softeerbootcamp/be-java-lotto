package kr.codesquad.Controller;

import kr.codesquad.Model.*;
import kr.codesquad.View.Input;
import kr.codesquad.View.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoController {

    public LottoController(){
    }

    public void start(){
        // 구입 금액 입력 받고 구입 개수 출력
        Money money = new Money(Input.inputPrice());
        Output.printCount(money.countLottos());
        // count 만큼의 로또 번호 생성
        LottoGame lottoGame = new LottoGame(money);
        // 구매한 로또 번호 출력
        Output.printLottoBuyList(lottoGame);
        // 지난 주 당첨 번호 입력 받기
        WinningLotto winningLotto = new WinningLotto(Input.inputWinLottoNum(), Input.inputBonusBall());
        // 지난 주 당첨 통계
        LottoResult result = lottoGame.match(winningLotto);
        // 출력
        Output.printScore(result);
        Output.printRate(result, money);
    }

}
