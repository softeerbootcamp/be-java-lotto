package kr.codesquad;


import java.util.*;

import static kr.codesquad.Calculator.*;
import static kr.codesquad.Jackpot_Handler.*;
import static kr.codesquad.Lotto_Info.LOTTO_PRICE;

public class Main {
    public static int money,cnt;
    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money/LOTTO_PRICE.getValue();
    }
    public static void start(){
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        money = sc.nextInt();
        cnt = ret_lotto_cnt(money);
        System.out.printf("%d개를 구매했습니다.\n",cnt);
    }
    public static void main(String[] args) {
        start();
        My_lotto myLotto = new My_lotto(cnt);
        Jackpot_Handler jh = new Jackpot_Handler();
        jh.setJackpotNum();
        jh.finding_jackpot(myLotto);
        Calculator.print_and_calculation(jh.JACKPOT_CNT, money);
    }
}
