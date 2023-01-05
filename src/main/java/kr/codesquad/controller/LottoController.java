package kr.codesquad.controller;

import kr.codesquad.model.UserInfo;
import kr.codesquad.model.lottos.RandomLotto;
import kr.codesquad.model.lottos.ResultLotto;
import kr.codesquad.model.lottos.Lotto;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;

public class LottoController {

    private UserInfo user;
    private UserConsole userConsole;
    private ConsoleHandler consoleHandler;
    private RandomLotto randomLotto = new RandomLotto();
    private Lotto myLotto = new Lotto();
    private ResultLotto resultLotto = new ResultLotto();
    private MatchController matchController = new MatchController();


    public LottoController(UserInfo userInfo) {
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
        int purchasedPrice = consoleHandler.enterPurchasePrice();
        int numOfLottoSudong = consoleHandler.enterSudongLottoNumber();
        int numOfLottoAuto = (purchasedPrice / 1000) - numOfLottoSudong;
        user.insertInfos(purchasedPrice, numOfLottoAuto, numOfLottoSudong);
    }


    //로또 생성 로직
    public void generateLottos(){
        //자동 로또 생성
        randomLotto.startGeneration(user.getNumOfLottoAuto(), user.getNumOfLottoSudong());
        //수동 로또 생성
        for(int i = 0; i < user.getNumOfLottoSudong(); i++){
            ArrayList<Integer> sudongLottoList = consoleHandler.enterSudongLottoList();
            myLotto.addLotto(sudongLottoList);
        }
    }

    //당첨 번호 생성
    public void generateResults(){
        ArrayList<Integer> givenResult = consoleHandler.enterResultList();
        resultLotto.addLotto(givenResult);
        resultLotto.setBonusNum(consoleHandler.enterBonusNum());
    }

    //당첨 여부 조회
    public void calculateMatch(){
        matchController.startCalculate(randomLotto, myLotto, resultLotto);
    }

    //결과 출력
    public void printResult(){
        matchController.printResult(user.getPurchasedPrice());
    }
}
