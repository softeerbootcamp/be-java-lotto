package kr.codesquad.Controller;

import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.User;
import kr.codesquad.View.Input;
import kr.codesquad.View.Output;

public class LottoController {
    private User user;
    private Lotto lotto;

    public LottoController(){
        user = new User();
        lotto = new Lotto();
    }

    public void start(){
        // 구입 금액 입력 받고 구입 개수 출력
        user.setPriceAndCount(Input.inputPrice());
        Output.outputCount(user.getCount());
        // count 만큼의 로또 번호 생성 및 출력
        user.createLottoNumber();
        // 지난 주 당첨 번호 입력 받기
        lotto.setWinLottoNum();
        lotto.inputBonusBall();
        // 지난 주 당첨 통계
        lotto.statistics(user.getLottoBuyList(), user.getPrice());
    }

}
