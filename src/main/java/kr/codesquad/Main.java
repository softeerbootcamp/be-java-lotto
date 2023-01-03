package kr.codesquad;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> purchasedLottoList = lottoGame.purchaseLottoList();
        Lotto winningLotto = lottoGame.createWinningLottery();
        int bonusBall = lottoGame.getBonusBall();
        LottoResult lottoResult = lottoGame.checkMyLotto(purchasedLottoList, winningLotto, bonusBall);
        lottoResult.printResult(purchasedLottoList.size());
    }
}