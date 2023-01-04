package kr.codesquad.impl;

import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;

public class ResultLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();
    private int bonumsNum;

    //주어진 6개의 숫자 리스트를 로또 리스트 ArrayList에 add
    @Override
    public void addLotto(ArrayList<Integer> givenList) {
        lottoList.add(givenList);
    }

    //로또 리스트를 리턴
    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
