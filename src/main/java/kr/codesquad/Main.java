package kr.codesquad;

import kr.codesquad.Controller.LottoController;
import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.User;
import kr.codesquad.View.Input;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}