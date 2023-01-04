package kr.codesquad.impl;

import kr.codesquad.templates.LottoTmpl;

import java.util.*;

public class MyLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();


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
    public void generateLotto(int repNum){
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < repNum; i++){
            String numStr = scan.nextLine();
            addLotto(parseString(numStr));
        }
    }

    //생성된 로또 번호를 모든 로또번호를 담은 ArrayList에 Add
    @Override
    public void addLotto(ArrayList<Integer> givenList) {
        lottoList.add(givenList);
    }

    //로또 리스트를 반환
    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
