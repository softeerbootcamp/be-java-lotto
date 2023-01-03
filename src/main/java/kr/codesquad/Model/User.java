package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class User {
    private int price;
    private int count;
    private List<Lotto> lottoBuyList = new ArrayList<Lotto>(); // 로또 구매 목록
    private Lotto lottoBuy = new Lotto(); // 로또 구매 1장
    private int totalWinPrice = 0; // 총 상금
    private static int[] scoreList = new int[7]; // 3개~6개 맞췄는지 저장할 점수 리스트
    private int bonusBallScoreCount = 0;



    public User(){

    }

    public List<Lotto> getLottoBuyList(){
        return lottoBuyList;
    }

    public void setPriceAndCount(int p){
        price = p;
        count = p/1000;
    }
    public int getPrice(){ return price; }
    public int getCount(){ return count; }
    public void addLottoBuyList(Lotto lotto) {
        lottoBuyList.add(lotto);
    }

    public void addBonusBallScoreCount() {
        bonusBallScoreCount++;
    }

    public void minusBonusBallScroreCount() {
        scoreList[5]--;
    }

    public void addScoreList(int score) {
        scoreList[score]++;
    }

    public void addTotalWinPrice(int price) {
        totalWinPrice += price;
    }

    public int[] getScoreList() {
        return scoreList;
    }

    public int getBonusBallScoreCount() {
        return bonusBallScoreCount;
    }

    public int getTotalWinPrice() {
        return totalWinPrice;
    }

    public void setLottoBuy(Lotto lb) {
        lottoBuy = lb;
    }

    public Lotto getLottoBuy() {
        return lottoBuy;
    }
}
