package kr.codesquad.Controller;

import kr.codesquad.Model.*;
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
        Money money = new Money(Input.inputPrice());
        Output.printCount(money.countLottos());
        // count 만큼의 로또 번호 생성
        LottoGame lottoGame = new LottoGame(money);
        // 구매한 로또 번호 출력
        Output.printLottoBuyList(lottoGame);
        // 지난 주 당첨 번호 입력 받기
        WinningLotto winningLotto = new WinningLotto(Input.inputWinLottoNum(), Input.inputBonusBall());
        // 지난 주 당첨 통계
        LottoResult result = lottoGame.match(winningLotto);
        // 출력
        Output.printScore(result);
        // statistics(user.getLottoBuyList(), user.getPrice());
    }

    public void statistics(List<Lotto> lottoBuyList, int price) {
        for (Lotto lottoBuy : lottoBuyList) {
            getScore(lottoBuy);
        }
        // 맞춘 개수와 수익률 출력
        //Output.printScore(price, user.getScoreList(), user.getBonusBallScoreCount());
        //Output.printRate(price, user.getTotalWinPrice());
    }

    public int getScore(Lotto lottoNumList){
        int score = countScore(lottoNumList);
        // 5개 당첨 + 보너스 볼 당첨됐는지 확인 > 확인 결과에 따라 총 상금 갱신
        countTotalWinPrice(score, checkBonusBall(lottoNumList, winLottoNum.getBonusBall(), score));
        addScoreList(score);
        return score;
    }
    public int countScore(Lotto lottoNumList){
        int score = 0;
        for(int i = 0;i<6;i++)
            score += compareValue(lottoNumList, 0);
        return score;
    }
    public int compareValue(Lotto lottoNumList, int value){
        if(lottoNumList.getLottoNumbers().contains(value)) return 1;
        return 0;
    }

    public boolean checkBonusBall(Lotto lottoNumList, int value, int score) {
        if(lottoNumList.getLottoNumbers().contains(value)){
            // 보너스 볼 당첨일 경우 이미 5개가 맞는지 확인
            return checkBonusBallScore(score);
        }
        return false;
    }

    public boolean checkBonusBallScore(int score){
        if(score != 5) return false;
        // 5개가 당첨이 되었고 보너스 볼 당첨이므로 count + 1 해주고
        user.addBonusBallScoreCount();
        // 5개 당첨자랑은 다르게 보너스 볼 추가 당첨이므로 5개 당첨자 수 - 1 해서 맞춰줌
        user.minusBonusBallScroreCount();
        return true;
    }
    public void addScoreList(int score) {
        user.addScoreList(score);
    }

    private void countTotalWinPrice(int score, boolean isWinBonus) {
        //user.addTotalWinPrice(Rank.valueOf(score, isWinBonus));
    }
}
