package kr.codesquad;


import java.util.*;

import static kr.codesquad.Calculator.*;
import static kr.codesquad.Jackpot_Handler.*;
import static kr.codesquad.Lotto_Info.LOTTO_PRICE;

public class Main {
    // todo list 1
    public static int ret_lotto_cnt(int money){
        return money/LOTTO_PRICE.getValue();
    }

    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int cnt = ret_lotto_cnt(money);
        System.out.printf("%d개를 구매했습니다.\n",cnt);
        My_lotto myLotto = new My_lotto(cnt);
        setJackpotNum();
        finding_jackpot(myLotto,JACKPOT_NUM);
        Calculator.print_and_calculation(JACKPOT_CNT,money);
    }
}
