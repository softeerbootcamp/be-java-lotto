package kr.codesquad.Controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.AutoLottoGenerator;
import kr.codesquad.Model.User;
import kr.codesquad.Model.WinLotto;
import kr.codesquad.Model.WinnerCalculator;
import kr.codesquad.View.LottoPrinter;
import kr.codesquad.View.LottoScanner;
import kr.codesquad.View.MessageGenerator;
import kr.codesquad.View.Printer;

public class LottoController {
    LottoScanner lottoScanner = new LottoScanner();
    Printer lottoPrinter = new LottoPrinter();
    MessageGenerator mg = new MessageGenerator();
    AutoLottoGenerator autoLottoGenerator = new AutoLottoGenerator();
    WinnerCalculator winnerCalculator = new WinnerCalculator();

    public LottoController() {
    }

    public void start() {
        Lotto.initLotto();
        User user = new User(getInitMoney());
        user.buyLotto(autoLottoGenerator);
        getBuyResult(user);
        WinLotto winLotto = new WinLotto(getWinNumber(), getBonusNumber());
        winnerCalculator.initWinnerCount();
        winnerCalculator.calcResult(user, winLotto);
        lottoPrinter.print(mg.getResultMsg(winnerCalculator));
        lottoPrinter.print(mg.bonusReqMsg);
    }

    private List<Integer> getWinNumber() {
        lottoPrinter.print(mg.winRequestMsg);
        return lottoScanner.scanWinNum();
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
        lottoPrinter.print(mg.getBuyMsg(user.getLottoAmount()));
        Iterator<Lotto> iterator = user.lottoList.listIterator();

        while(iterator.hasNext()) {
            Lotto lotto = (Lotto)iterator.next();
            lottoPrinter.print(Arrays.asList(lotto.num).toString());
        }

    }
}
