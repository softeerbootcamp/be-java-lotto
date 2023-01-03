package kr.codesquad.LottoService;

import java.util.List;

public interface LottoService {
    void setLottoNumbers(long lottoCount);

    void printLottos();

    void printWinningLottos();


    void calculateEarningRate(long lottoCount);

    void setWinningNumbers(List<Integer> wonNumberList);

}
