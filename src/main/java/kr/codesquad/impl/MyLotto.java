package kr.codesquad.impl;

import kr.codesquad.Lotto;
import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;

public class MyLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();

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
