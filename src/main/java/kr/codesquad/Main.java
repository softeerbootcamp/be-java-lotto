package kr.codesquad;

import kr.codesquad.entities.CalculateMatch;
import kr.codesquad.entities.UserInfo;
import kr.codesquad.entities.lottoImpl.MyLotto;
import kr.codesquad.entities.lottoImpl.RandomLotto;
import kr.codesquad.entities.lottoImpl.ResultLotto;
import kr.codesquad.utils.UserConsole;

public class Main {

    //initial method
    private static void initMethod(){

        UserInfo user = new UserInfo();
        UserConsole userConsole = new UserConsole(user);
        RandomLotto randomLotto = new RandomLotto();
        MyLotto myLotto = new MyLotto();
        ResultLotto resultLotto = new ResultLotto();
        CalculateMatch calculateMatch = new CalculateMatch();

        //구매 금액 입력
        userConsole.enterPurchasePrice();
        //로또 번호 생성 (랜덤)
        randomLotto.startGeneration(user.getNumOfLottoAuto(), user.getNumOfLottoSudong());
        //로또 번호 생성 (유저가 입력)
        myLotto.generateLotto(user.getNumOfLottoSudong());
        //당첨 번호 입력
        resultLotto.enterResultNumbers();
        //보너스 번호 입력
        resultLotto.enterBonusNum();
        //당첨 여부 확인
        calculateMatch.startCalculate(randomLotto, myLotto, resultLotto);
        //결과 출력
        calculateMatch.printResult(user.getPurchasedPrice());

    }

    public static void main(String[] args) {
        initMethod();
    }


}