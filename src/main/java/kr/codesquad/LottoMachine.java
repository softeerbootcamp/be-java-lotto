package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    private ArrayList<ArrayList<Integer>> lottos;
    private int lottoCnt;
    List<Integer> numList;

    public LottoMachine() {
        lottos = new ArrayList<>();
        numList = new ArrayList<>();
        for(int j=1;j<46;j++) numList.add(j);
    }

    public Integer getAmountOfMoney(){
        System.out.println("구입금액을 입력해주세요. ");
        Scanner sc = new Scanner(System.in);
        int amountOfMoney = sc.nextInt();
        return amountOfMoney;
    }

    public Integer getLottoCount(int amountOfMoney,int manualLottoCnt){
        //to-do : 금액에 따른 개수 제한 예외처리
        this.lottoCnt = amountOfMoney/1000; // 총 로또 개수
        this.lottoCnt -= manualLottoCnt;
        System.out.println("총"+lottoCnt+"개를 자동으로 구매했습니다.");
        return lottoCnt;
    }

    public ArrayList<ArrayList<Integer>> getLottos(){
        for(int i=0;i<lottoCnt;i++){
            getLottoByShuffle();
        }
        System.out.println(lottos.size());
        return lottos;
    }


    public void getLottoByShuffle(){
        Collections.shuffle(numList); //1에서 46까지를 셔플
        ArrayList<Integer> shuffledNumList =  new ArrayList<>(numList.subList(0,6));
        Collections.sort(shuffledNumList);
        lottos.add(shuffledNumList);
    }

}
