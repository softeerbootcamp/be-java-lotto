package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static kr.codesquad.Lotto_Info.LOTTO_SIZE;

public class Jackpot_Handler {
    public static final int[] JACKPOT_CNT = {0,0,0,0,0};
    public static List<Integer> JACKPOT_NUM;
    public static int JACKPOT_BONUS_NUM=0;
    public static boolean JACKPOT_BONUS_CORRECT = false;

    public static boolean isJackpotBonusCorrect(List<Integer> my) {
        if(my.contains(JACKPOT_BONUS_NUM)){
            return true;
        }else return false;
    }
    public int isMyLottoContainsJackpots(int i,List<Integer> my, List<Integer> jk){
        if(my.contains(jk.get(i))){
            return 1;
        }else{
            return 0;
        }
    }
    public void countingJackpots(List<Integer> my, List<Integer> jk){
        int cnt=0;
        for (int i = 0; i< LOTTO_SIZE.getValue(); i++) {
            cnt+= isMyLottoContainsJackpots(i,my,jk);
        }
        if(cnt>=5&&isJackpotBonusCorrect(my)){
            JACKPOT_CNT[cnt-2]++;
        } else if(cnt>=3) {
            JACKPOT_CNT[cnt-3]++;
        };
    }

    public void findingEachLottoJackpots(generateMyLottoByCount generateMyLottoByCount){
        for (EmptyLotto o: generateMyLottoByCount.getLottos()
        ) {
            List<Integer> my_lotto_one = o.getNumbers();
            countingJackpots(my_lotto_one,JACKPOT_NUM);
        }
    }

    public void setJackpotNum(){
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        Scanner s2 = new Scanner(System.in);
        String str = s2.nextLine();
        String[] strArr= str.split(",");
        JACKPOT_NUM = new ArrayList<>(LOTTO_SIZE.getValue());
        for(int i = 0; i< LOTTO_SIZE.getValue(); i++){
            JACKPOT_NUM.add(Integer.parseInt(strArr[i]));
        }
        Collections.sort(JACKPOT_NUM);
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = s2.nextInt();
        JACKPOT_BONUS_NUM = bonus;

    }
}
