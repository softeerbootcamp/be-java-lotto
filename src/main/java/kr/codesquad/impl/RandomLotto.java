package kr.codesquad.impl;

import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;

public class RandomLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> allNums = new ArrayList<Integer>();

    public RandomLotto(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    @Override
    public void addLotto(ArrayList<Integer> lottoList) {

    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
