package kr.codesquad;

import java.util.ArrayList;

public class WinNum {
    public ArrayList<Integer> num = new ArrayList<>();

    public WinNum(String numStr) {
        String[] strList = numStr.split(", ");
        for(int i=0;i<strList.length;i++) {
            this.num.add(Integer.parseInt(strList[i]));
        }
    }
}
