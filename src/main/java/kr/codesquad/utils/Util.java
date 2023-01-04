package kr.codesquad.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {


    //인풋 스트링을 정수형 배열로 변환
    public static ArrayList<Integer> parseString(String str){
        List<String> split = Arrays.asList(str.split(","));
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }

    public static int containNum(int target, ArrayList<Integer> tempList){
        if (tempList.contains(target))
            return 1;
        return 0;
    }

}
