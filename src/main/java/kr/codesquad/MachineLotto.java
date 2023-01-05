package kr.codesquad;

import java.util.*;

public class MachineLotto extends BaseLotto{
    private List<Integer> numList;
    private UserConsole userConsole;

    public MachineLotto(UserConsole userConsole) {
        this.lottoList = new ArrayList<>();
        numList = new ArrayList<>();
        this.userConsole = new UserConsole();
        for(int j=1;j<46;j++) numList.add(j);
    }

    public Integer getAmountOfMoney(){
        int amountOfMoney = 0;
        try {
            System.out.print("구입금액을 입력해주세요");
            amountOfMoney = userConsole.enterInteger();
        }catch(InputMismatchException e){
            System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
        }catch(Exception e){
            System.out.println("입력에 에러가 발생했습니다. 다시 값을 입력해주세요");
        }
        return amountOfMoney;
    }

    @Override
    public Integer getLottoCnt(int amountOfMoney,int manualLottoCnt) {
        //to-do : 금액에 따른 개수 제한 예외처리
        this.lottoCnt = amountOfMoney/1000; // 총 로또 개수
        this.lottoCnt -= manualLottoCnt;
        return this.lottoCnt;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        for(int i=0;i<lottoCnt;i++){
            getLottoByShuffle();
        }
        return lottoList;
    }

    public void getLottoByShuffle(){
        Collections.shuffle(numList); //1에서 46까지를 셔플
        ArrayList<Integer> shuffledNumList =  new ArrayList<>(numList.subList(0,6));
        Collections.sort(shuffledNumList);
        this.lottoList.add(shuffledNumList);
    }

}
