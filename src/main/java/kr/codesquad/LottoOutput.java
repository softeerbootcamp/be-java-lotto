package kr.codesquad;
import java.util.Map;

public class LottoOutput {

    public static void printResult(Map<Rank, Integer> result, double rate){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.forEach((r,c)-> System.out.printf("%d개 일치 (%d원)- %d개\n", r.getCnt(), r.getPrize(), c));
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rate);
    }
}
