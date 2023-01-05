package kr.codesquad.controller;

import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputRangeException;
import kr.codesquad.model.UserInfo;
import kr.codesquad.model.lottos.RandomLotto;
import kr.codesquad.model.lottos.ResultLotto;
import kr.codesquad.model.lottos.Lotto;
import kr.codesquad.view.UserConsole;

import java.util.ArrayList;

public class LottoController {

    private UserInfo user;
    private ConsoleHandler consoleHandler;
    private RandomLotto randomLotto = new RandomLotto();
    private Lotto myLotto = new Lotto();
    private ResultLotto resultLotto = new ResultLotto();
    private MatchController matchController = new MatchController();


    public LottoController(UserInfo userInfo) {
        this.user = userInfo;
        this.consoleHandler = new ConsoleHandler(user);
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
        int numOfLottoSudong = sudongBuy(purchasedPrice);
        int numOfLottoAuto = (purchasedPrice / 1000) - numOfLottoSudong;
        user.insertInfos(purchasedPrice, numOfLottoAuto, numOfLottoSudong);
    }


    //수동 구매 로직
    public int sudongBuy(int purchasedPrice){
        int numOfLottoSudong = 0;
        try{
            numOfLottoSudong = consoleHandler.enterSudongLottoNumber(purchasedPrice / 1000);
        }catch (InputRangeException e){
            System.out.println(e.getMessage());
            sudongBuy(purchasedPrice);
        }
        return numOfLottoSudong;
    }

    public ArrayList<Integer> startGenerateSudong(){
        ArrayList<Integer> sudongLottoList = new ArrayList<>();
        try{
            sudongLottoList = consoleHandler.enterSudongLottoList();}
        catch (InputCountException e){
            System.out.println(e.getMessage());
            startGenerateSudong();
        }
        return sudongLottoList;
    }

    //로또 생성 로직
    public void generateLottos(){
        //자동 로또 생성
        randomLotto.startGeneration(user.getNumOfLottoAuto(), user.getNumOfLottoSudong());
        //수동 로또 생성
        for(int i = 0; i < user.getNumOfLottoSudong(); i++){
            ArrayList<Integer> sudongLottoList = startGenerateSudong();
            myLotto.addLotto(sudongLottoList);
        }
    }

    //당첨 번호 생성
    public void generateResults(){
        ArrayList<Integer> givenResult = new ArrayList<>();
        try{
            givenResult = consoleHandler.enterResultList();}
        catch(InputCountException e){
            e.getMessage();
            generateResults();}
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
