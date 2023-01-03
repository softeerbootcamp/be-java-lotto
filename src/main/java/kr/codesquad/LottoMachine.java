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
        ret.add(0);
        ret.add(0);
        ret.add(0);
        ret.add(0);
        for(int i = 0; i < Tickets.size(); i++)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(Tickets.get(i).contains(winNums.get(j))) count++;
            }
            if(count == 3) ret.set(0, ret.get(0)+1);
            if(count == 4) ret.set(1, ret.get(1)+1);
            if(count == 5) ret.set(2, ret.get(2)+1);
            if(count == 6) ret.set(3, ret.get(3)+1);
        }
        return ret;
    }
}
