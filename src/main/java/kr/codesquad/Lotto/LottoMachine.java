package kr.codesquad.Lotto;

import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<ArrayList<Integer>> getRandomLottoTickets(int count)
    {
        ArrayList<ArrayList<Integer>> Tickets = new ArrayList<ArrayList<Integer>>();

        for(Integer i = 0; i < count; i++)
        {
            // 임의의 6개의 번호 입력 후
            Tickets.add(getRandomSixNums());
            // 오름차순으로 정렬
            Collections.sort(Tickets.get(i));
        }

        return Tickets;
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
