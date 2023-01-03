package kr.codesquad;

import kr.codesquad.io.Console;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Console console = new Console();
    private static Lotto lotto = new Lotto();
    public static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int money = console.inputMoney();
        int lottoAmount = money / LOTTO_PRICE;
        console.printAmount(lottoAmount);
        List<Lotto> allLotto = lotto.makeLottoNum(lottoAmount);
        console.printLottoNum(allLotto);
        WinNum winNum = console.inputWinNum();
        int[] correctCnt = lotto.lottoResult(winNum, allLotto);
        console.printLottoResult(money, correctCnt);
    }

}