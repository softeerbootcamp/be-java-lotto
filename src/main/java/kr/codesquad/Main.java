package kr.codesquad;

import kr.codesquad.io.Console;

import java.util.List;
import java.util.Map;

public class Main {
    private static Console console = new Console();
    private static LottoService lottoService = new LottoService();
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int money = console.inputMoney();
        int lottoAmount = money / LOTTO_PRICE;
        console.printAmount(lottoAmount);
        List<Lotto> allLotto = lottoService.makeLottoList(lottoAmount);
        console.printLottoNum(allLotto);
        WinLotto winLotto = new WinLotto(console.inputWinNum(), console.inputBonusNum());
        Map<WinningCount, Integer> lottoResult = lottoService.makeLottoResult(allLotto, winLotto);
        console.printLottoResult(money, lottoResult);
    }

}
