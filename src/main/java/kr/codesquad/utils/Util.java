package kr.codesquad.utils;

import kr.codesquad.exception.InputCountException;
import kr.codesquad.exception.InputFormatException;
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

    public static ArrayList<Integer> stringToUniqueArrayList(String str){
        Set<Integer> resultSet = new HashSet<>();
        try {
            resultSet = parseString(str);}
        catch (NumberFormatException e){  //문자를 입력할 시
            throw new InputFormatException("숫자형으로 입력해주세요");}
        if(resultSet.size() != 6)   //로또 번호의 개수가 6개가 아닐 때
            throw new InputCountException("올바르지 않은 입력입니다");
        ArrayList<Integer> resultArrayList = new ArrayList<>(resultSet);
        return resultArrayList;
    }
}
