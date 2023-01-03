package kr.codesquad;
import java.util.ArrayList;
import java.util.Collections;

enum LottoStatus{
    Fifth("3개 일치", 5000),
    Fourth("4개 일치", 50000),
    Third("5개 일치", 1500000),
    Second("5개 일치, 보너스 볼 일치", 30000000),
    First("6개 일치", 2000000000);

    LottoStatus(String val1, int val2)
    {
        setStatusValue1(val1);
        setStatusValue2(val2);
    }

    private String StatusValue1; // 상태메시지
    private int StatusValue2; // 당첨금액

    public String getStatusValue1() {
        return StatusValue1;
    }

    public void setStatusValue1(String statusValue1) {
        StatusValue1 = statusValue1;
    }

    public int getStatusValue2() {
        return StatusValue2;
    }

    public void setStatusValue2(int statusValue2) {
        StatusValue2 = statusValue2;
    }

}

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
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", Result.get(3));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", Result.get(4));

        float rate = (float)(5000*Result.get(0) + 50000*Result.get(1) + 1500000*Result.get(2) +
                30000000*Result.get(3) +2000000000*Result.get(4) - buyNum*1000) / (float) (buyNum*1000) * 100;

        System.out.printf("총 수익률은 %f퍼센트 입니다.\n", rate);
    }
}
