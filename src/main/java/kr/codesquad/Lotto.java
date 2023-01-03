package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lotto {
    List<Integer> winLottoNum = new ArrayList<>(); // 당첨 번호
    int scoreList[] = {0, 0, 0, 0, 0, 0, 0}; // 3개~6개 맞췄는지 저장할 점수 리스트
    Lotto(){

    }

    public void setWinLottoNum(){
        Scanner sc = new Scanner(System.in);
        // 입력 버퍼 비우기
        sc.nextLine();
        // 당첨 번호 입력 받기
        System.out.println("\n당첨 번호를 입력해 주세요");
        String[] winLottoNumString = sc.nextLine().split(", ");
        for(int i = 0;i<6;i++){
            winLottoNum.add(Integer.parseInt(winLottoNumString[i]));
        }
    }

    public int compareValue(List<Integer> lottoNumList, int value){
        if(lottoNumList.contains(value)) return 1;
        return 0;
    }

    public int getScore(List<Integer> lottoNumList){
        int score = 0;
        for(int i = 0;i<6;i++) {
            score += compareValue(lottoNumList, winLottoNum.get(i));
        }
        return score;
    }

    public void addScoreList(int scoreList[], int score) {
        if (score == 3) scoreList[3]++;
        if (score == 4) scoreList[4]++;
        if (score == 5) scoreList[5]++;
        if (score == 6) scoreList[6]++;
    }

    public void printScore(int price){
        System.out.println("\n당첨 통계\n----------");
        System.out.println("3개 일치 (5000원) - " + scoreList[3] + "개");
        System.out.println("4개 일치 (50000원) - " + scoreList[4] + "개");
        System.out.println("5개 일치 (1500000원) - " + scoreList[5] + "개");
        System.out.println("6개 일치 (2000000000원) - " + scoreList[6] + "개");
        printRate(price);
    }

    public void printRate(int price){
        int totalWinPrice = scoreList[3] * 5000 + scoreList[4] * 50000 +
                scoreList[5] * 1500000 + scoreList[6] * 2000000000;
        // 수익률 계산 = 딴 돈 / 낸 돈  백분율
        double winRate = (double)totalWinPrice / price * 100;
        // 손해일 경우 - 100
        // 기존의 30퍼센트 = -70퍼센트
        if(totalWinPrice < price) winRate -= 100.0;

        System.out.println("총 수익률은 " + String.format("%.2f",winRate) + "%입니다.");
    }

    public void statistics(List<List<Integer>> lottoBuyList){
        for(int i = 0;i<lottoBuyList.size();i++){
            int score = getScore(lottoBuyList.get(i));
            addScoreList(scoreList, score);
        }
    }


}
