package kr.codesquad.Controller;

import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.User;
import kr.codesquad.View.Input;
import kr.codesquad.View.Output;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoController {
    private User user;
    private Lotto lotto;
    private Lotto winLottoNum; // 당첨 번호
    private int totalWinPrice = 0; // 총 상금
    private static int[] scoreList = new int[7]; // 3개~6개 맞췄는지 저장할 점수 리스트
    private int bonusBallScoreCount = 0;
    private List<Integer> numberList = new ArrayList<Integer>(); // 1 ~ 45로 이루어진 리스트

    public LottoController(){
        user = new User();
        lotto = new Lotto();
        winLottoNum = new Lotto();
        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }
    }

    public void start(){
        // 구입 금액 입력 받고 구입 개수 출력
        user.setPriceAndCount(Input.inputPrice());
        Output.printCount(user.getCount());
        // count 만큼의 로또 번호 생성 및 출력
        createLottoNumber();
        // 구매한 로또 번호 출력
        Output.printLottoBuyList(user.getLottoBuyList());
        // 지난 주 당첨 번호 입력 받기
        winLottoNum = Input.inputWinLottoNum();
        winLottoNum.setBonusBall(Input.inputBonusBall());
        // 지난 주 당첨 통계
        //lotto.statistics(user.getLottoBuyList(), user.getPrice());
    }

    // 자동 생성 로또
    public void createLottoNumber(){
        for(int i = 0;i<user.getCount();i++){
            // 번호 섞기
            Collections.shuffle(numberList);
            // 번호 6개 자르고 정렬 후 구매 리스트에 추가
            user.addLottoBuyList(new Lotto(numberList.subList(0,6)));
        }
    }

}
