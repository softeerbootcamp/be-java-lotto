package kr.codesquad;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // User, Lotto 클래스 생성
        User user = new User();
        Lotto lotto = new Lotto();
        // 구입 금액 입력 받고 구입 개수 출력
        user.inputPrice();
        // count 만큼의 로또 번호 생성 및 출력
        user.createLottoNumber();
        // 당첨 번호 입력 받기
        //lotto.setWinLottoNum();
        // 당첨 통계
        //lotto.statistics(user.getLottoBuyList(), user.getPrice());
        // 지난 주 당첨 번호 입력 받기
        lotto.setWinLottoNum();
        lotto.inputBonusBall();
        // 지난 주 당첨 통계
        lotto.statistics(user.getLottoBuyList(), user.getPrice());
    }
}