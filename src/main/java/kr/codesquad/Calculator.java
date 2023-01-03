package kr.codesquad;

public class Calculator {
    public Calculator() {
    }
    public static void print_and_calculation(int[] jk,int money){
        float prof;
        int flag=0,sum=0;
        System.out.println("\n당첨통계\n---------");
        for(Prizes pr:Prizes.values()){
            pr.print_message(jk[flag]);
            sum+=pr.print_prize()*jk[flag];
            flag++;
        }
        prof = (sum-money)/money;
        System.out.printf("총 수익률은 : %f%%입니다\n",prof*100);
    }
}
