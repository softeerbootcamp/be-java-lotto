package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface LottoGenerator {
    Lotto getNewLotto();
    List<Integer> setLottoNum(List<Integer> lottoNum);

}
