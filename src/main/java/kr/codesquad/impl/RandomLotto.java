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

    public void generateAllNums(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }
    public void startGeneration(int repNum){
        for(int i = 0 ; i < repNum; i++){
            generateLotto();
        }
    }
    public void generateLotto(){
        Collections.shuffle(allNums);
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        for(int j = 0;  j < 6; j++)
            tempList.add(allNums.get(j));
        System.out.println(tempList);
    }
    @Override
    public void addLotto(ArrayList<Integer> givenList) {
        lottoList.add(givenList);
    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
