package kr.codesquad;

import java.util.*;

public class Lotto {
    public Lotto()
    {
        lottoList = new ArrayList<>();
    }
    public Lotto(List<Integer> list)
    {
        lottoList = new ArrayList<>(list);
    }
    List<Integer> lottoList;
    public List<Integer> getLottoList()
    {
        return lottoList;
    }
}
