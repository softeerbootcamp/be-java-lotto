package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static kr.codesquad.Lotto_Info.LOTTO_CNT;

public class Jackpot_Handler {
    public static final int[] JACKPOT_CNT = {0,0,0,0,0};
    public static ArrayList<Integer> JACKPOT_NUM;
    public static int JACKPOT_BONUS_NUM=0;
    public static boolean JACKPOT_BONUS_CORRECT = false;
    public static int ret1_if_contains(int i, ArrayList<Integer> my, ArrayList<Integer> jk){
        if(my.contains(JACKPOT_BONUS_NUM)){
            JACKPOT_BONUS_CORRECT = true;
            return 0;
        }
        if(my.contains(jk.get(i))){
            return 1;
        }else{
            return 0;
        }
    }
    public static void ret_jackpot_cnts(ArrayList<Integer> my, ArrayList<Integer> jk){
        int cnt=0;
        for (int i=0;i<LOTTO_CNT.getValue();i++) {
            cnt+=ret1_if_contains(i,my,jk);
        }
        if(cnt>=3&&JACKPOT_BONUS_CORRECT){
            JACKPOT_CNT[cnt-2]++;
            return;
        }
        if(cnt>=3) JACKPOT_CNT[cnt-3]++;
    }

    public static void finding_jackpot(My_lotto myLotto, ArrayList<Integer> jackpot_num){
        for (Empty_lotto o:myLotto.getMy_lottos()
        ) {
            ArrayList<Integer> my_lotto_one = o.getNumbers();
            ret_jackpot_cnts(my_lotto_one,jackpot_num);
        }
    }

    public static void setJackpotNum(){
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        Scanner s2 = new Scanner(System.in);
        String str = s2.nextLine();
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = s2.nextInt();
        String[] strArr= str.split(",");
        JACKPOT_NUM = new ArrayList<>(LOTTO_CNT.getValue());
        JACKPOT_BONUS_NUM = bonus;
        for(int i=0;i<LOTTO_CNT.getValue();i++){
            JACKPOT_NUM.add(Integer.parseInt(strArr[i]));
        }
        Collections.sort(JACKPOT_NUM);
    }
}
