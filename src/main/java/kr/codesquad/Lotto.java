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
        System.out.println(this.numberList);
    }

    public int correctNumCnt(WinNum winNum) {
        int cnt = 0;
        if(this.numberList.contains(winNum.num.get(0))) cnt++;
        if(this.numberList.contains(winNum.num.get(1))) cnt++;
        if(this.numberList.contains(winNum.num.get(2))) cnt++;
        if(this.numberList.contains(winNum.num.get(3))) cnt++;
        if(this.numberList.contains(winNum.num.get(4))) cnt++;
        if(this.numberList.contains(winNum.num.get(5))) cnt++;
        return cnt;
    }

}
