package kr.codesquad.templates;

import java.util.ArrayList;

public interface LottoTmpl {

    public abstract void addLotto(ArrayList<Integer> lottoList);
    public abstract ArrayList<Integer> getLottoList();

}
