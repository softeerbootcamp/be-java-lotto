package kr.codesquad.Controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import kr.codesquad.Model.*;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;
import kr.codesquad.View.MessageGenerator;
import kr.codesquad.View.Printer;

public class LottoController {
    LottoScanner lottoScanner = new LottoScanner();
    Printer lottoPrinter = new LottoPrinter();
    MessageGenerator mg = new MessageGenerator();
    LottoGenerator lottoGenerator = new LottoGenerator();
    WinnerCalculator winnerCalculator = new WinnerCalculator();

    public LottoController() {
    }

    public void start() {
        Lotto.initLotto();
        User user = new User(getInitMoney());
        sellManualLotto(user);
        WinLotto winLotto = new WinLotto(getWinNumber(), getBonusNumber());
        winnerCalculator.initWinnerCount();
        winnerCalculator.calcResult(user, winLotto);
        lottoPrinter.print(mg.getResultMsg(winnerCalculator,user));
    }

    private List<Integer> getWinNumber() {
        lottoPrinter.print(mg.winRequestMsg);
        return lottoScanner.scanLottoNumbers();
    }

    private int getBonusNumber() {
        lottoPrinter.print(mg.bonusReqMsg);
        return lottoScanner.scanBonus();
    }

    private BigInteger getInitMoney() {
        lottoPrinter.print(mg.moneyReqMsg);
        return lottoScanner.scanMoney();
    }

    private void getBuyResult(User user) {
        lottoPrinter.print(mg.getBuyMsg(user.getManualLottoAmount(),user.getAutoLottoAmount()));
        Iterator<Lotto> iterator = user.lottoList.listIterator();

        while(iterator.hasNext()) {
            Lotto lotto = iterator.next();
            lottoPrinter.print(Arrays.asList(lotto.num).toString());
        }
    }

    private void sellManualLotto(User user){
        lottoPrinter.print(mg.manualAmountReqMsg);
        int manualAmount = lottoScanner.scanManualAmount();
        lottoPrinter.print(mg.manualNumberReqMsg);
        for (int i=0; i<manualAmount; i++){
            List<Integer> lottoNumbers = lottoScanner.scanLottoNumbers();
            user.buyLotto(lottoGenerator, lottoNumbers);  //인자로 로또생성기와 수동 번호 주기
        }
        user.buyLotto(lottoGenerator);
        getBuyResult(user);
    }
}
