package kr.codesquad;

import static kr.codesquad.Main.JACKPOT_CNT;

public class Calculator {
    public Calculator() {
    }
    public static float calculate_profit(int[] jackpots, int money){
        float prof,sum=0;
        int[] prizes = {5000,50000,1500000,2000000000};
        for (int i=0;i< jackpots.length;i++) {
            sum += prizes[i] * jackpots[i];

        }
        print_calculation(jackpots,prizes);
        prof = (sum-money)/money;
        return prof;
    }
    public static void print_calculation(int[] jk,int[] prizes){
        System.out.println("\n당첨통계\n---------");
        for(int i=0;i<JACKPOT_CNT.length;i++){
            System.out.printf("%d개 일치 : (%d)- %d개\n",i+3,prizes[i],jk[i]);
        }
    }
}
