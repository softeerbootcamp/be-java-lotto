package kr.codesquad;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // User 클래스 생성
        User user = new User();
        // 구입 금액 입력 받고 구입 개수 출력
        user.inputPrice();
        // 로또 클래스 생성
        Lotto lotto = new Lotto();
        // count 만큼의 로또 번호 생성 및 출력
        user.createLottoNumber();
        // 당첨 번호 입력 받
        lotto.setWinLottoNum();
        // 당첨 통계
        // 맞춘 개수(통계) 구하기
        lotto.statistics(user.lottoBuyList);
        // 맞춘 개수와 수익률 출력
        lotto.printScore(user.price);

    }
}