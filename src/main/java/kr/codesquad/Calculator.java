package kr.codesquad;

public class Calculator {
    public static void print_and_calculation(int[] jk,int money){
        double prof,sum=0;
        int flag=0;
        System.out.println("\n당첨통계\n---------");
        for(Prizes_Info pr:Prizes_Info.values()){
            pr.print_message(jk[flag]);
            sum+=pr.getValue()*jk[flag];
            flag++;
        }
        prof = (double)((sum- money)/ money);
        System.out.printf("총 수익률은 : %.2f%%입니다\n",prof*100);
    }
}
