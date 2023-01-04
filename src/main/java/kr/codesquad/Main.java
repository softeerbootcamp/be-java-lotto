package kr.codesquad;

import kr.codesquad.controller.LottoController;
import kr.codesquad.model.UserInfo;

public class Main {

    public static void main(String[] args) {
        UserInfo user = new UserInfo();  //사용자 정보
        LottoController lottoController = new LottoController(user);
        lottoController.start();
    }

}