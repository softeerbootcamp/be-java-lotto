package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
    public ArrayList<Integer> numberList = new ArrayList<>();

    public Lotto() {
        ArrayList<Integer> allNumber = new ArrayList<>();
        for(int i=1;i<=45;i++) allNumber.add(i);
        Collections.shuffle(allNumber);
        ArrayList<Integer> lottoNum = new ArrayList<>();
        lottoNum.addAll(allNumber.subList(0, 6));
        Collections.sort(lottoNum);
        this.numberList.addAll(lottoNum);
    }

    public void showLotto() {
        System.out.println(numberList);
    }

}
