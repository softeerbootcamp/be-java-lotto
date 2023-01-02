package kr.codesquad.controller;

import kr.codesquad.view.PrintView;
import kr.codesquad.view.ReceiveView;

public class LottoController {

    public void play() {
        int purchaseAmount = enterPurchaseAmount();
    }

    private static int enterPurchaseAmount() {
        PrintView.enterPurchaseAmount();
        return ReceiveView.EnterPurchaseAmount();
    }
}
