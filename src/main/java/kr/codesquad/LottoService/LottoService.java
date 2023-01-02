package kr.codesquad.LottoService;

import java.util.ArrayList;
import java.util.List;

public interface LottoService {
    void setLottoNumbers(long lottoCount);

    void printLottos();

    void printWonLottos();


    ArrayList<ArrayList<Integer>> getLottos();
}
