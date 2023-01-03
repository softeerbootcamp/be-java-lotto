package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    List<List<Integer>> lottoBuyList = new ArrayList<>(); // 로또 구매 목록
    List<Integer> lottoBuy = new ArrayList<>(); // 로또 구매 1장
    List<Integer> numberList = new ArrayList<Integer>(); // 1 ~ 45로 이루어진 리스트
    List<Integer> winLottoNum = new ArrayList<>(); // 당첨 번호
    int scoreList[] = {0, 0, 0, 0, 0, 0, 0}; // 3개~6개 맞췄는지 저장할 점수 리스트
    Lotto(){
        // 로또 번호 1 ~ 45를 저장할 리스트 생성
        for(int n = 1;n<=45;n++){
            numberList.add(n);
        }
    }
    public void createLottoNumber(int count){
        for(int i = 0;i<count;i++){
            // 번호 섞기
            Collections.shuffle(numberList);
            lottoBuy = new ArrayList<>(numberList.subList(0,6));

            // 번호 정렬
            Collections.sort(lottoBuy);

            // 로또 구매 리스트에 추가
            lottoBuyList.add(lottoBuy);
        }
    }

    public void printLottoBuyList(){
        for(int i = 0;i<lottoBuyList.size();i++){
            // 출력
            System.out.println(lottoBuyList.get(i));
        }
    }

    public void setWinLottoNum(String[] winLottoNumString){
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

    public void printScore(){
        System.out.println("3개 일치 (5000원) - " + scoreList[3] + "개");
        System.out.println("4개 일치 (50000원) - " + scoreList[4] + "개");
        System.out.println("5개 일치 (1500000원) - " + scoreList[5] + "개");
        System.out.println("6개 일치 (2000000000원) - " + scoreList[6] + "개");
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

    public void statistics(){
        for(int i = 0;i<lottoBuyList.size();i++){
            int score = getScore(lottoBuyList.get(i));
            addScoreList(scoreList, score);
        }
    }


}
