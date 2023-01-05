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

<<<<<<< HEAD
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
=======
    public void start() {
        Lotto.initLotto();
        User user = new User(getInitMoney());
        user.buyLotto(autoLottoGenerator);
        getBuyResult(user);
        WinLotto winLotto = new WinLotto(getWinNumber(), getBonusNumber());
        winnerCalculator.initWinnerCount();
        winnerCalculator.calcResult(user, winLotto);
        lottoPrinter.print(mg.getResultMsg(winnerCalculator,user));
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
>>>>>>> cbaed76 (변수명 변경 및 코드 정리)
        }
    }
}
