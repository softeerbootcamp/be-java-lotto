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

    public void makeRandomLottoTickets() {
        for(Integer i = 0; i < buyNum; i++)
        {
            // 임의의 6개의 번호 입력 후
            lottoTickets.add(getRandomSixNums());
            // 오름차순으로 정렬
            Collections.sort(lottoTickets.get(i));
        }
    }

    private ArrayList<Integer> getRandomSixNums()
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        // 1부터 45까지의 정수를 담고 있는 arraylist
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        for(Integer i = 1; i <= 45; i++) Numbers.add(i);
        Collections.shuffle(Numbers);

        // 앞 6자리 추출
        for(int i = 0; i < 6; i++) {
            ret.add(Numbers.get(i));
        }

        return ret;
    }

    public void calculateBuyNum()
    {
        // 구매 개수 구하기
        buyNum = cash / 1000;
    }

    public void calculateRateOfRetrun(ArrayList<Integer> Result)
    {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------");

        for(LottoStatus stat : LottoStatus.values())
        {
            System.out.printf("%s, (%d)- %d개\n", stat.getStatusString(), stat.getWinningAmout(), Result.get(stat.ordinal()));
        }
//          System.out.printf("3개 일치 (5000원)- %d개\n", Result.get(0));
//          System.out.printf("4개 일치 (50000원)- %d개\n", Result.get(1));
//          System.out.printf("5개 일치 (1500000원)- %d개\n", Result.get(2));
//          System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", Result.get(3));
//          System.out.printf("6개 일치 (2000000000원)- %d개\n", Result.get(4));

        float rate = (float)(
                    LottoStatus.Fifth.getWinningAmout()*Result.get(0) +
                    LottoStatus.Fourth.getWinningAmout()*Result.get(1) +
                    LottoStatus.Third.getWinningAmout()*Result.get(2) +
                    LottoStatus.Second.getWinningAmout()*Result.get(3) +
                    LottoStatus.First.getWinningAmout()*Result.get(4) - buyNum*1000) /
                (float) (buyNum*1000)
                * 100;

        System.out.printf("총 수익률은 %.2f%% 입니다.\n", rate);
    }
}
