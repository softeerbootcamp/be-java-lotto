package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public List<Integer> numberList = new ArrayList<>();

    public Lotto() {
        List<Integer> allNumber = new ArrayList<>();
        for(int i=1;i<=45;i++) allNumber.add(i);
        Collections.shuffle(allNumber);
        List<Integer> lottoNum = new ArrayList<>();
        lottoNum.addAll(allNumber.subList(0, 6));
        Collections.sort(lottoNum);
        this.numberList.addAll(lottoNum);
    }

    public int correctNumCnt(WinNum winNum) {
        List<Integer> temp = (ArrayList<Integer>) this.numberList;
        temp.retainAll(winNum.num);
        return temp.size();
    }

}
