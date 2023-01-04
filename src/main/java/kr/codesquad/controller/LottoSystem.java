package kr.codesquad.controller;

import kr.codesquad.model.UserInfo;
import kr.codesquad.model.lottoImpl.MyLotto;
import kr.codesquad.model.lottoImpl.RandomLotto;
import kr.codesquad.model.lottoImpl.ResultLotto;
import kr.codesquad.utils.Util;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoSystem {

    private UserInfo user;
    private UserConsole userConsole;
    private RandomLotto randomLotto = new RandomLotto();
    private MyLotto myLotto = new MyLotto();
    private ResultLotto resultLotto = new ResultLotto();
    private CalculateMatcher calculateMatcher = new CalculateMatcher();


    public LottoSystem(UserInfo userInfo) {
        this.user = userInfo;
        this.userConsole = new UserConsole(user);
    }

    public void start(){
        //로또 구매
        purchaseLotto();
        //로또 번호 생성
        generateLottos();
        //결과 번호 생성
        generateResults();
        //당첨 여부 조회
        calculateMatch();
        //결과 출력
        printResult();
    }

    //로또 구매 로직
    public void purchaseLotto(){
        int purchasedPrice = userConsole.enterPurchasePrice();
        int numOfLottoSudong = userConsole.enterSudongLottoNumber();
        int numOfLottoAuto = (purchasedPrice / 1000) - numOfLottoSudong;
        user.insertInfos(purchasedPrice, numOfLottoAuto, numOfLottoSudong);
    }


    //로또 생성 로직
    public void generateLottos(){
        //자동 로또 생성
        randomLotto.startGeneration(user.getNumOfLottoAuto(), user.getNumOfLottoSudong());
        //수동 로또 생성
        for(int i = 0; i < user.getNumOfLottoSudong(); i++){
            String lottoStr = userConsole.enterSudongLottoList();
            myLotto.addLotto(Util.parseString(lottoStr));
        }
    }

    //당첨 번호 생성
    public void generateResults(){
        String givenResult = userConsole.enterResultList();
        resultLotto.addLotto(Util.parseString(givenResult));
        resultLotto.setBonusNum(userConsole.enterBonusNum());
    }


    //당첨 여부 조회
    public void calculateMatch(){
        calculateMatcher.startCalculate(randomLotto, myLotto, resultLotto);
    }

    //결과 출력
    public void printResult(){
        calculateMatcher.printResult(user.getPurchasedPrice());
    }
}
