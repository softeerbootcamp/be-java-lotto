//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package kr.codesquad.Controller;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.LottoGenerator;
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
    LottoGenerator lottoGenerator = new LottoGenerator();
    WinnerCalculator winnerCalculator = new WinnerCalculator();

    public LottoController() {
    }

    public void start() {
        Lotto.initLotto();
        User user = new User(this.getInitMoney());
        user.buyLotto(this.lottoGenerator);
        this.getBuyResult(user);
        WinLotto winLotto = new WinLotto(this.getWinNumber(), this.getBonusNumber());
        this.winnerCalculator.initWinnerCount();
        this.winnerCalculator.calcResult(user, winLotto);
        this.lottoPrinter.print(this.mg.getResultMsg(this.winnerCalculator));
    }

    private List<Integer> getWinNumber() {
        this.lottoPrinter.print(this.mg.getWinRequestMsg());
        return this.lottoScanner.scanWinNum();
    }

    private int getBonusNumber() {
        this.lottoPrinter.print(this.mg.getBonusReqMsg());
        return this.lottoScanner.scanBonus();
    }

    private BigInteger getInitMoney() {
        this.lottoPrinter.print(this.mg.getMoneyReqMsg());
        return this.lottoScanner.scanMoney();
    }

    private void getBuyResult(User user) {
        this.lottoPrinter.print(this.mg.getBuyMsg(user.getLottoAmount()));
        Iterator<Lotto> iterator = user.lottoList.listIterator();

        while(iterator.hasNext()) {
            Lotto lotto = (Lotto)iterator.next();
            this.lottoPrinter.print(Arrays.asList(lotto.num).toString());
        }

    }
}
