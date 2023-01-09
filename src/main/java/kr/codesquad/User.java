package kr.codesquad;
import kr.codesquad.Lotto.LottoStatus;

import java.util.ArrayList;
import java.util.Collections;


public class User {

    private int cash; // 구매 금액
    private int buyNum; // 구매 개수
    private int autoCount;
    private int manualCount;
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

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

    public ArrayList<ArrayList<Integer>> getLottoTickets() {
        return lottoTickets;
    }

    public void setManualTickets(ArrayList<ArrayList<Integer>> Tickets)
    {
        for(int i = 0; i < manualCount; i++)
        {
            Collections.sort(Tickets.get(i));
            lottoTickets.add(Tickets.get(i));
        }
    }

    public void setAutoTickets(ArrayList<ArrayList<Integer>> Tickets)
    {
        for(int i = 0; i < Tickets.size(); i++)
        {
            lottoTickets.add(Tickets.get(i));
        }
    }

    public void calculateBuyNum(int manuals)
    {
        // 구매 개수 구하기
        buyNum = cash / 1000;
        manualCount = manuals;
        autoCount = buyNum - manualCount;
    }

}
