package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class WinNum {
    public List<Integer> num = new ArrayList<>();

    public WinNum(String numStr) {
        String[] strList = numStr.split(", ");
        for(int i=0;i<strList.length;i++) {
            this.num.add(Integer.parseInt(strList[i]));
        }
    }
}
