package kr.codesquad.LottoService;

import java.util.ArrayList;
import java.util.List;

public interface LottoService {
    void setLottoNumbers(long lottoCount);

    void printLottos();

    void printWinningLottos();

    void setWinningNumbers(ArrayList<Integer> wonNumberList);

    void calculateEarningRate(long lottoCount);


    ArrayList<ArrayList<Integer>> getLottos();
}
