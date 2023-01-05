package kr.codesquad;

import kr.codesquad.domain.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ManualLottoGenerator implements LottoGenerator {

    private String manualRowString;
    @Override
    public Row generateRow() {
        return convertStringToRow(manualRowString);
    }
    public void checkValidation(String manualRowString) {
        /**
         * 예외 처리 필요
         */
        this.manualRowString = manualRowString;
    }

    private Row convertStringToRow(String rowByString) {
        StringTokenizer st = new StringTokenizer(rowByString);
        List<Integer> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(numbers);

        return Row.createRow(numbers);
    }
}
