package kr.codesquad.impl;

import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;

public class RandomLotto implements LottoTmpl {

    private ArrayList<Integer> allNums = new ArrayList<Integer>();

    public RandomLotto(){
        for(int i = 1; i < 46; i++)
            allNums.add(i);
    }

    @Override
    public void addLotto(ArrayList<Integer> lottoList) {

    }

    @Override
    public ArrayList<Integer> getLottoList() {
        return null;
    }
}
