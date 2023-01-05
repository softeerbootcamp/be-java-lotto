package kr.codesquad.Controller;


import kr.codesquad.Model.*;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;
import kr.codesquad.View.MessageGenerator;
import kr.codesquad.View.Printer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LottoController {
    LottoScanner lottoScanner = new LottoScanner();
    Printer lottoPrinter = new LottoPrinter();
    MessageGenerator mg = new MessageGenerator();
    LottoGenerator lottoGenerator = new LottoGenerator();
    WinnerCalculator winnerCalculator = new WinnerCalculator();
    public void start(){
        Lotto.initLotto();  //로또 번호 1~45 초기화
        User user = new User(getInitMoney());
        user.buyLotto(lottoGenerator);      //유저 로또 구입
        getBuyResult(user);  //유저가 구입한 로또 리스트 출력
        WinLotto winLotto = new WinLotto(getWinNumber(), getBonusNumber());    //당첨 로또 설정
        winnerCalculator.initWinnerCount(); //당첨자수 초기화
        winnerCalculator.calcResult(user,winLotto);
        lottoPrinter.print(mg.getResultMsg(winnerCalculator));
        /*
        user.setMoney(getInitMoney());
        winnerCalculator.initWinnerCount();
        lottoService.init();
        lottoPrinter.print(buyLotto(lottoService));
        lottoService.setWinNum(getWinNumber());
        lottoService.calcResult();
        lottoPrinter.print(mg.getResultMsg(lottoService));
         */
    }

    private List<Integer> getWinNumber(){
        lottoPrinter.print(mg.getWinRequestMsg());
        return lottoScanner.scanWinNum();
    }

    private int getBonusNumber(){
        lottoPrinter.print(mg.getBonusReqMsg());
        return lottoScanner.scanBonus();
    }

    private BigInteger getInitMoney(){
        lottoPrinter.print(mg.getMoneyReqMsg());
        return lottoScanner.scanMoney();
    }

    private void getBuyResult(User user){
        lottoPrinter.print(mg.getBuyMsg(user.getLottoAmount()));
        Iterator<Lotto> iterator = user.lottoList.listIterator();
        while (iterator.hasNext()){
            Lotto lotto = iterator.next();
            lottoPrinter.print(Arrays.asList(lotto.num).toString());
        }
    }
    /*

    private BigInteger getInitMoney(){
        lottoPrinter.print(mg.getMoneyReqMsg());
        BigInteger money = lottoScanner.setMoney();
        return money;
    }

    private String buyLotto(LottoService lottoService){
        return mg.getBuyMsg(lottoService.buyLotto());
    }

    public void calcResult(){

    }

    private

     */
}
