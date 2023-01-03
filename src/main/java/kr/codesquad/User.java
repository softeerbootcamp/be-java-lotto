package kr.codesquad;
import java.util.ArrayList;
import java.util.Collections;

public class User {

    private int cash; // 구매 금액
    private int buyNum; // 구매 개수


    private ArrayList<ArrayList<Integer>> lottoTickets = new ArrayList<ArrayList<Integer>>();

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }


    public ArrayList<ArrayList<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public void MakeRandomLottoTickets() {
        for(Integer i = 0; i < buyNum; i++)
        {
            lottoTickets.add(GetRandomSixNums());
            Collections.sort(lottoTickets.get(i));
        }
    }

    private ArrayList<Integer> GetRandomSixNums()
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        for(Integer i = 1; i <= 45; i++) Numbers.add(i);
        Collections.shuffle(Numbers);

        for(int i = 0; i < 6; i++) {
            ret.add(Numbers.get(i));
        }

        return ret;
    }

    public void CalculateBuyNum()
    {
        buyNum = cash / 1000;
    }

    public void PrintResult(ArrayList<Integer> Result)
    {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------");
        System.out.printf("3개 일치 (5000원)- %d개\n", Result.get(0));
        System.out.printf("4개 일치 (50000원)- %d개\n", Result.get(1));
        System.out.printf("5개 일치 (1500000원)- %d개\n", Result.get(2));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", Result.get(3));

        float rate = (float)(5000*Result.get(0) + 50000*Result.get(1) + 1500000*Result.get(2) + 2000000000*Result.get(3) - buyNum*1000) / (float) (buyNum*1000) * 100;

        System.out.printf("총 수익률은 %f퍼센트 입니다.\n", rate);
    }
}
