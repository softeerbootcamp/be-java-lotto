package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<Integer> winNumber = new ArrayList<>();
    int bonus;

    public void setBonus(int num) {
        this.bonus = num;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setWinNumber(List<Integer> winNumber) {
        this.winNumber = winNumber;
    }
    public List<Integer> getWinNumber() {
        return this.winNumber;
    }
}
