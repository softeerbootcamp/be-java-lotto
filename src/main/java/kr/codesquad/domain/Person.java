package kr.codesquad.domain;

import kr.codesquad.utilities.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class Person {
    List<List<Integer>> number = new ArrayList<>();
    Integer[] winNumberArr;
    int money;
    int haveRobotLotto;
    int haveHandLotto;
    double total;

    public Person(){
        winNumberArr = new Integer[5];
        for (int i = 0; i < 5; i++) {
            winNumberArr[i] = 0;
        }
        total = 0;
    }

    public Integer getWinNumberArr(int i){
        return winNumberArr[i];
    }

    public void setWinNumberArr(int idx, int num){
        winNumberArr[idx] = num;
    }
    public int getHaveRobotLotto(){
        return this.haveRobotLotto;
    }

    public void setHaveRobotLotto(int cnt) {
        this.haveRobotLotto = cnt;
    }

    public Integer getWinNumber(int i) {
        return winNumberArr[i];
    }

    public void setWinNumber(int idx, int num) {
        winNumberArr[idx] = num;
    }

    public int getHaveHandLotto(){
        return this.haveHandLotto;
    }

    public void setHaveHandLotto(int cnt) {
        this.haveHandLotto = cnt;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addLotto(List<Integer> inputNumber) {
        number.add(inputNumber);
    }

    public Integer getSize() {
        return number.size();
    }

    public List<Integer> getLotto(int i) {
        return number.get(i);
    }

    public void setPlusTotal() {
        for (int i = 0; i < winNumberArr.length; i++) {
            plusTotal(i);
        }
    }

    public void plusTotal(int i) {
        if(i == 0) total += (winNumberArr[i] * Integer.parseInt(LottoRank.valueOf("FIVE").getRank()));
        if(i == 1) total += (winNumberArr[i] * Integer.parseInt(LottoRank.valueOf("FOURTH").getRank()));
        if(i == 2) total += (winNumberArr[i] * Integer.parseInt(LottoRank.valueOf("THIRD").getRank()));
        if(i == 3) total += (winNumberArr[i] * Integer.parseInt(LottoRank.valueOf("SECOND").getRank()));
        if(i == 4) total += (winNumberArr[i] * Integer.parseInt(LottoRank.valueOf("FIRST").getRank()));
    }

    public void print() { // 당첨 로또 개수 출력
        System.out.println("당첨 통계\n---------");
        for (int i = 0; i < 5; i++) {
            printCount(i);
        }
        setPlusTotal();
        String result = round(money);
        System.out.println( "총 수익률은 " + result + "%입니다.");
    }

    public void printCount(int i) {
        if(i == 0) System.out.println("3개 일치 (5000원) - " + winNumberArr[i] + "개");
        if(i == 1) System.out.println("4개 일치 (50000원) - " + winNumberArr[i] + "개");
        if(i == 2) System.out.println("5개 일치 (1500000원) - " + winNumberArr[i] + "개");
        if(i == 3) System.out.println("5개 일치 (30000000원), 보너스 볼 일치 - " + winNumberArr[i] + "개");
        if(i == 4) System.out.println("6개 일치 (2000000000원) - " +winNumberArr[i] + "개");
    }

    public String round(int originMoney) {
        double originM = originMoney;
        if (total < originM){
            String temp = String.format("%.3f",((originM - total) / originM) * 100);
            temp = ("-" + temp.substring(0,temp.length()-1));
            return temp;
        }
        String percent = String.format(("%.3f"), (total - originM) / originM * 100);
        return percent.substring(0,percent.length()-1);
    }

    public void LottoNumPrint() {
        for(int i=0; i<number.size(); i++) System.out.println(number.get(i));
    }
}
