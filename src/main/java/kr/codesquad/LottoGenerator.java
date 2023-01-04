package kr.codesquad;

import kr.codesquad.domain.Row;

import java.util.List;

public interface LottoGenerator {
    List<Row> generateRows(int inputMoney);
}
