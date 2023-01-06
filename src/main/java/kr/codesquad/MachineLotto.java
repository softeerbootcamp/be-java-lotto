package kr.codesquad;

import kr.codesquad.exception.CustomException;
import kr.codesquad.utils.Utility;

import java.util.*;

public class MachineLotto extends BaseLotto{
    private List<Integer> numList;

    public MachineLotto(UserConsole userConsole) {
        this.lottoList = new ArrayList<>();
        numList = new ArrayList<>();
        for(int j=1;j<46;j++) numList.add(j);
    }

    public Integer getAmountOfMoney(){
        int amountOfMoney = 0;
        try {
            System.out.print("구입금액을 입력해주세요");
            Scanner sc = new Scanner(System.in);
            amountOfMoney = sc.nextInt();
            Utility.checkAmountOfMoney(amountOfMoney);
            sc.nextLine();
        }catch(InputMismatchException e){
            System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
        }catch(CustomException e){
            throw e;
        }catch(Exception e){
            System.out.println("입력에 에러가 발생했습니다. 다시 값을 입력해주세요");
        }
        return amountOfMoney;
    }

    @Override
    public Integer getLottoCnt(int amountOfMoney,int manualLottoCnt) {
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
        ArrayList<Integer> shuffledNumList;
        do{
            Collections.shuffle(numList); //1에서 46까지를 셔플
            shuffledNumList =  new ArrayList<>(numList.subList(0,6));
            Collections.sort(shuffledNumList);
        }while(this.lottoList.contains(shuffledNumList)); //만약 중복이라면 다시 돌아가서 새롭게 셔플, 없으면 while문 끝
        this.lottoList.add(shuffledNumList);
    }

}
