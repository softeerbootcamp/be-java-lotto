package kr.codesquad;

import kr.codesquad.controller.CalculateMatcher;
import kr.codesquad.controller.LottoSystem;
import kr.codesquad.model.UserInfo;
import kr.codesquad.model.lottoImpl.MyLotto;
import kr.codesquad.model.lottoImpl.RandomLotto;
import kr.codesquad.model.lottoImpl.ResultLotto;

public class Main {

    //initial method
    private static void initMethod(){
        //시작 사용자
        UserInfo user = new UserInfo();
        LottoSystem lottoSystem = new LottoSystem(user);
        lottoSystem.start();
    }

    public static void main(String[] args) {
        initMethod();
    }


}