package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LottoMachine {

    private List<List<Integer>> lottos;
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

    public Integer getLottoCount(int amountOfMoney){
        lottoCnt = amountOfMoney/1000; // 총 로또 개수
        System.out.println("총"+lottoCnt+"개를 구매했습니다.");
        return lottoCnt;
    }

    public List<List<Integer>> getLottos(){
        for(int i=0;i<lottoCnt;i++){
            getLottoByShuffle();
        }
        System.out.println(lottos);

        return lottos;
    }

    public void getLottoByShuffle(){
        Collections.shuffle(numList); //1에서 46까지를 셔플
        List<Integer> shuffledNumList =  new ArrayList<>(numList.subList(0,6));
        Collections.sort(shuffledNumList);
        lottos.add(shuffledNumList);
    }

}
