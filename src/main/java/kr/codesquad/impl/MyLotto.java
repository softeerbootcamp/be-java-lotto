package kr.codesquad.impl;

import kr.codesquad.Lotto;
import kr.codesquad.templates.LottoTmpl;

import java.util.ArrayList;

public class MyLotto implements LottoTmpl {

    private ArrayList<ArrayList<Integer>> lottoList = new ArrayList<ArrayList<Integer>>();

    @Override
    public void addLotto(ArrayList<Integer> lottoList) {

    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        return lottoList;
    }
}
