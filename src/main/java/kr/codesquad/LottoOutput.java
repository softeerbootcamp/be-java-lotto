package kr.codesquad;

public class LottoOutput {
    public static void printLottos(LottoGame game){
        System.out.println(game.toString());
    }
    public static void printResult(LottoResult result, double rate){
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        result.result.forEach((r,c)->System.out.println(r.toString()+"- "+c+"개"));
        System.out.printf("총 수익률은 %.2f%%입니다.\n", rate);
    }
}
