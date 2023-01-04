package kr.codesquad;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LottoMachine {
    private ArrayList<Integer> winNums;
    private int bonusBall;

    public ArrayList<Integer> getWinNums() {
        return winNums;
    }

    public void setWinNums(ArrayList<Integer> winNums) {
        this.winNums = winNums;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    public void setBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public ArrayList<Integer> getResult(ArrayList<ArrayList<Integer>> Tickets)
    {
        ArrayList<Integer> Result = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++)
        {
            // 초기값 설정
            Result.add(0);
        }

        for(int i = 0; i < Tickets.size(); i++)
        {
            // 각 번호를 당첨 번호와 비교
            compareTicketWithWinNum(Tickets.get((i)), Result);
        }
        return Result;
    }

    private void compareTicketWithWinNum(ArrayList<Integer> Ticket, ArrayList<Integer> Result)
    {
        // 당첨 번호와 같은 숫자의 수
        int count = countValidNums(Ticket);
        // 보너스 번호가 있는지 없는지
        boolean isBonus = judgeBonus(Ticket);

        // 위 두 정보를 이용하여 순위 결정
        String rank = decideRank(count, isBonus);

        if(rank.equals("Out of rank")) return;

        int EnumIdx = LottoStatus.valueOf(rank).ordinal();
        Result.set(EnumIdx, Result.get(EnumIdx)+1);
    }

    private int countValidNums(ArrayList<Integer> Ticket)
    {
        int ret = 0;
        for(int j = 0; j < 6; j++)
        {
            if(Ticket.contains(winNums.get(j))) ret++;
        }
        return ret;
    }

    private boolean judgeBonus(ArrayList<Integer> Ticket)
    {
        if(Ticket.contains(bonusBall))
            return true;
        return false;
    }

    private String decideRank(int c, boolean isBonus)
    {
        if(c == 3)              return "Fifth";
        if(c == 4)              return "Fourth";
        if(c == 5 && !isBonus)  return "Third";
        if(c == 5 && isBonus)   return "Second";
        if(c == 6)              return "First";
        return "Out of rank";
    }
}
