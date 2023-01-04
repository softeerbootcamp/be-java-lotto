package kr.codesquad.model.lottoImpl;

import kr.codesquad.templates.Lotto;

import java.util.*;

public class MyLotto extends Lotto {


    //인풋 스트링을 정수형 배열로 변환
    public ArrayList<Integer> parseString(String str){
        List<String> split = Arrays.asList(str.split(","));
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        if(split.size() != 6)
            throw new RuntimeException("올바르지 않은 입력입니다");
        split.forEach(item->tempList.add(Integer.parseInt(item)));
        return tempList;
    }

    //사용자의 인풋을 받아 이를 로또리스트 배열에 추가
    public void generateLotto(String numStr){
        addLotto(parseString(numStr));
    }

}
