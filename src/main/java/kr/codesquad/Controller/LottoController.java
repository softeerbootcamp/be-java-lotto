package kr.codesquad.Controller;

import kr.codesquad.Model.LottoService;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;
import kr.codesquad.View.MessageGenerator;
import kr.codesquad.View.Printer;

import java.math.BigInteger;

public class LottoController {
    LottoScanner lottoScanner = new LottoScanner();
    Printer lottoPrinter = new LottoPrinter();
    MessageGenerator mg = new MessageGenerator();
    public void start(){
        LottoService lottoService = new LottoService(getInitMoney());
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
}
