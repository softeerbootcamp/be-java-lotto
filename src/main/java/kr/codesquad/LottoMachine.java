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

    public ArrayList<Integer> GetResult(ArrayList<ArrayList<Integer>> Tickets)
    {
        ArrayList<Integer> Result = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++)
        {
            Result.add(0);
        }

        for(int i = 0; i < Tickets.size(); i++)
        {
            CompareTicketWithWinNum(Tickets.get((i)), Result);
        }
        return Result;
    }

    private void CompareTicketWithWinNum(ArrayList<Integer> Ticket, ArrayList<Integer> Result)
    {
        int count = CountValidNums(Ticket);
        boolean isBonus = JudgeBonus(Ticket);

        String rank = DecideRank(count, isBonus);

        if(rank.equals("Out of rank")) return;

        int EnumIdx = LottoStatus.valueOf(rank).ordinal();
        Result.set(EnumIdx, Result.get(EnumIdx)+1);
    }

    private int CountValidNums(ArrayList<Integer> Ticket)
    {
        int ret = 0;
        for(int j = 0; j < 6; j++)
        {
            if(Ticket.contains(winNums.get(j))) ret++;
        }
        return ret;
    }

    private boolean JudgeBonus(ArrayList<Integer> Ticket)
    {
        if(Ticket.contains(bonusBall))
            return true;
        return false;
    }

    private String DecideRank(int c, boolean isBonus)
    {
        if(c == 3)              return "Fifth";
        if(c == 4)              return "Fourth";
        if(c == 5 && !isBonus)  return "Third";
        if(c == 5 && isBonus)   return "Second";
        if(c == 6)              return "First";
        return "Out of rank";
    }
}
