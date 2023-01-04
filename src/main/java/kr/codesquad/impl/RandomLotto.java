package kr.codesquad.impl;

import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;
import java.util.Collections;

public class RandomLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> allNums = new ArrayList<Integer>();

    public RandomLotto(){
        generateAllNums();
    }

    //난수 생성 용 ArrayList를 생성
    public void generateAllNums(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    //로또 번호 생성 로직 시작
    public void startGeneration(int repNum){
        for(int i = 0 ; i < repNum; i++){
            generateLotto();
        }
    }

    //6개의 로또 번호를 생성
    public void generateLotto(){
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
        addLotto(tempList);
    }

    //생성된 로또 번호를 모든 로또번호를 담은 ArrayList에 Add
    @Override
    public void addLotto(ArrayList<Integer> givenList) {
        lottoList.add(givenList);
    }

    //로또 리스트를 반
    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
