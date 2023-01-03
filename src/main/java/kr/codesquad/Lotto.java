package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    Scanner sc = new Scanner(System.in);
    private List<Integer> winLottoNum = new ArrayList<>(); // 당첨 번호
    private int bonusBall = 0;
    private int totalWinPrice = 0;
    private int scoreList[] = {0, 0, 0, 0, 0, 0, 0}; // 3개~6개 맞췄는지 저장할 점수 리스트
    private int bonusBallScoreCount = 0;
    Lotto(){

    }

    public void setWinLottoNum(){
        // 입력 버퍼 비우기
        //sc.nextLine();
        // 당첨 번호 입력 받기
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요");
        String[] winLottoNumString = sc.nextLine().split(", ");
        for(int i = 0;i<6;i++){
            winLottoNum.add(Integer.parseInt(winLottoNumString[i]));
        }
    }


    public void inputBonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusBall = sc.nextInt();
    }

    public int compareValue(List<Integer> lottoNumList, int value){
        if(lottoNumList.contains(value)) return 1;
        return 0;
    }

    public int checkBonusBall(List<Integer> lottoNumList, int value, boolean isWinBonus){
        if(lottoNumList.contains(value)) {
            isWinBonus = true;
            return 1;
        }
        return 0;
    }

    public int getScore(List<Integer> lottoNumList){
        int score = 0;
        boolean isWinBonus = false;
        for(int i = 0;i<6;i++) {
            score += compareValue(lottoNumList, winLottoNum.get(i));
        }
        if(score == 5) bonusBallScoreCount += checkBonusBall(lottoNumList, bonusBall, isWinBonus);
        if(score >= 3) countTotalWinPrice(score, isWinBonus);
        return score;
    }

    public void addScoreList(int scoreList[], int score) {
        if (score == 3) scoreList[3]++;
        if (score == 4) scoreList[4]++;
        if (score == 5) scoreList[5]++;
        if (score == 6) scoreList[6]++;
        scoreList[5] -= bonusBallScoreCount;
    }

    public void printRate(int price){
        // 수익률 계산 = 딴 돈 / 낸 돈  백분율
        double winRate = (double)totalWinPrice / price * 100;
        // 손해일 경우 - 100
        // 기존의 30퍼센트 = -70퍼센트
        if(totalWinPrice < price) winRate -= 100.0;
        System.out.println("총 수익률은 " + String.format("%.2f",winRate) + "%입니다.");
    }

    private void countTotalWinPrice(int score, boolean isWinBonus) {
        totalWinPrice += Rank.valueOf(score, isWinBonus).getWinningMoney();
    }

    public void statistics(List<List<Integer>> lottoBuyList, int price) {
        for(int i = 0;i<lottoBuyList.size();i++){
            int score = getScore(lottoBuyList.get(i));
            addScoreList(scoreList, score);
        }
        // 맞춘 개수와 수익률 출력
        printScore(price);
    }

    private void printScore(int price) {
        System.out.println("\n당첨 통계\n----------");
        System.out.println("3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원) - " + scoreList[3] + "개");
        System.out.println("4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원) - " + scoreList[4] + "개");
        System.out.println("5개 일치 (" + Rank.THIRD.getWinningMoney() + "원) - " + scoreList[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치(" + Rank.SECOND.getWinningMoney() + "원) - " + bonusBallScoreCount + "개");
        System.out.println("6개 일치 (" + Rank.FIRST.getWinningMoney() + "원) - " + scoreList[6] + "개");
        printRate(price);
    }
}
