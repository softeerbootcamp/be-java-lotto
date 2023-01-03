package kr.codesquad.Controller;

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
