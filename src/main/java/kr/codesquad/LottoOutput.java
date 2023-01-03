package kr.codesquad;
import java.util.List;
import java.util.Map;

public class LottoOutput {
    public static void printLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            lotto.printLotto();
        }
    }
    public static void printResult(Map<Rank, Integer> result, double rate){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.forEach((r,c)-> System.out.printf("%s (%d원)- %d개\n", r.getWords(), r.getPrize(), c));
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rate);
    }
}
