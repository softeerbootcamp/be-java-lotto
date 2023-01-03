package kr.codesquad;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        List<Lotto> purchasedLottoList = lottoGame.purchaseLottoList();
        Lotto winningLotto = lottoGame.createWinningLottery();
        lottoGame.checkMyLotto(purchasedLottoList, winningLotto);
    }
}