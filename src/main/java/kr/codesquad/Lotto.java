package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public List<Integer> numberList = new ArrayList<>();

    public int correctNumCnt(Lotto winNum) {
        List<Integer> temp = this.numberList;
        temp.retainAll(winNum.numberList);
        return temp.size();
    }

}