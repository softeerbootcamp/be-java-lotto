package kr.codesquad.utils;

import kr.codesquad.model.lottos.Lotto;

import java.util.*;

public class Util {


    //인풋 스트링을 정수형 배열로 변환
    public static Set<Integer> parseString(String str){
        List<String> split = Arrays.asList(str.split(","));
        Set<Integer> tempList = new HashSet<>();
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }


    //특정 숫자가 ArrayList 안에 들어있는지 판단
    public static int containNum(int target, ArrayList<Integer> tempList){
        if (tempList.contains(target))
            return 1;
        return 0;
    }

    //두가지의 로또를 합하여 리턴
    public static ArrayList<ArrayList<Integer>> mergeLottos(Lotto lotto1, Lotto lotto2){
        ArrayList<ArrayList<Integer>> lottoList1 = lotto1.getLottoList();
        ArrayList<ArrayList<Integer>> lottoList2 = lotto2.getLottoList();
        lottoList1.addAll(lottoList2);
        return lottoList1;
    }

}
