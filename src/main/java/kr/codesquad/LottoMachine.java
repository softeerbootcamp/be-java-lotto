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
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < 5; i++)
        {
            ret.add(0);
        }
        for(int i = 0; i < Tickets.size(); i++)
        {
            int count = 0;
            boolean notBonus = true;
            count = CountValidNums(Tickets.get(i));
            if(Tickets.get(i).contains(bonusBall)) notBonus = false;

            if(count == 3)              ret.set(0, ret.get(0)+1);
            if(count == 4)              ret.set(1, ret.get(1)+1);
            if(count == 5 && notBonus)  ret.set(2, ret.get(2)+1);
            if(count == 5 && !notBonus) ret.set(3, ret.get(3)+1);
            if(count == 6)              ret.set(4, ret.get(4)+1);
        }
        return ret;
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
}
