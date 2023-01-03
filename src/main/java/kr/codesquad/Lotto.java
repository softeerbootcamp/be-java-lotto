package kr.codesquad;

import java.util.*;

public class Lotto {
    public Lotto()
    {
        matchesBonus = false;
        matchCount = 0;
        lottoList = new ArrayList<>();
    }
    public Lotto(List<Integer> list)
    {
        matchesBonus = false;
        matchCount = 0;
        lottoList = new ArrayList<>(list);
    }

    List<Integer> lottoList;
    private int matchCount;
    boolean matchesBonus;

    public List<Integer> getLottoList()
    {
        return lottoList;
    }

    public boolean getMatchesBonus()
    {
        return matchesBonus;
    }

    public int getMatchCount()
    {
        return matchCount;
    }

    public void setMatchesBonus(boolean matches)
    {
        matchesBonus = matches;
    }

    public void setMatchCount(int count)
    {
        matchCount = count;
    }
}
