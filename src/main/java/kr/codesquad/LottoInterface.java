package main.java.kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public interface LottoInterface {
    public void makeLottoList(int count);
    public void printLottoList(int count);
    public void getJackPotNumbers(String st);
    public void getJackPots(List<Integer> list);
}
