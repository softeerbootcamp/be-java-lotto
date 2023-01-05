package kr.codesquad.Model;

import java.util.*;

public class WinnerCalculator {   //당첨자 계산기
    public WinLotto winLotto;

    public Map<Price, Integer> winnerCount = new HashMap<>();   //등수별 당첨자 수 => 로또 추첨기에서 관리

    public void initWinnerCount(){
        for (Price price:Price.values()){
            winnerCount.put(price,0);
        }
    }

    public void setWinNum(String winStr){
        List<Integer> winNum = new ArrayList<>();
        String[] winStrArr = winStr.split(",");
        for (int i=0; i<6; i++)
            winNum.add(Integer.parseInt(winStrArr[i].trim()));
        winLotto  = new WinLotto(winNum);
        setBonusNum();
    }

    private static void setBonusNum(){
        System.out.println("\n보너스 볼을 입력해 주세요.");    //, 처리 필요 -> string 활용
        Scanner sc = new Scanner(System.in);
        int bonus = sc.nextInt();
        Lotto.setBonus(bonus);  //보너스 번호 할당
    }

    public void updateWinnerCount(Price price){
        int value = winnerCount.get(price)+1;
        winnerCount.put(price, value);
    }
}
