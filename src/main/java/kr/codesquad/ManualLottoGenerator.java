package kr.codesquad;

import kr.codesquad.domain.Row;

public class ManualLottoGenerator implements LottoGenerator {

    public Row generateRow(String rowString) {
        //todo: 예외 처리 (갯수, 숫자여부 등등)
        return Row.convertStringToRow(rowString);
    }

    @Override
    public Row generateRow() {
        return null;
    }
}
