package kr.codesquad.Controller;

import kr.codesquad.Model.*;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;
import kr.codesquad.View.MessageGenerator;
import kr.codesquad.View.Printer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    LottoScanner lottoScanner = new LottoScanner();
    Printer lottoPrinter = new LottoPrinter();
    MessageGenerator mg = new MessageGenerator();
    LottoGenerator lottoGenerator = new LottoGenerator();
    WinnerCalculator winnerCalculator = new WinnerCalculator();
    User user = new User();
    public void start(){
        user.setMoney(getInitMoney());
        winnerCalculator.initWinnerCount();
        lottoService.init();
        lottoPrinter.print(buyLotto(lottoService));
        lottoService.setWinNum(getWinNumber());
        lottoService.calcResult();
        lottoPrinter.print(mg.getResultMsg(lottoService));
    }

    private BigInteger getInitMoney(){
        lottoPrinter.print(mg.getMoneyReqMsg());
        BigInteger money = lottoScanner.setMoney();
        return money;
    }

    private String buyLotto(LottoService lottoService){
        return mg.getBuyMsg(lottoService.buyLotto());
    }

    private String getWinNumber(){
        lottoPrinter.print(mg.getWinRequestMsg());
        return lottoScanner.scanWinNum();
    }

    public void calcResult(){
        List<Integer> winList = Arrays.asList(winnerCalculator.winLotto.num);
        for (Lotto lotto : user.lottoList) {
            List<Integer> lottoNum = new ArrayList<Integer>(Arrays.asList(lotto.num));
            lottoNum.retainAll(winList);
            int countOfMatch = lottoNum.size(); //일치 갯수
            Price price = Price.valueOf(countOfMatch, lotto.bonusMatch());
            if (price == null) continue;
            winnerCalculator.updateWinnerCount(price);
            user.updateEarn(price);
        }

=======
import kr.codesquad.Model.LottoService;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;

import java.math.BigInteger;

public class LottoController {
    public void start(){
        LottoScanner lottoScanner = new LottoScanner();
        LottoPrinter lottoPrinter = new LottoPrinter();
        LottoService lottoService = new LottoService(lottoScanner.setMoney());
        lottoService.init();
        lottoPrinter.printBuy(lottoService.buyLotto());
        lottoPrinter.printWinRequest();
        lottoService.setWinNum(lottoScanner.scanWinNum());
        lottoService.calcResult();
        lottoPrinter.printResult(lottoService);
    }
}
