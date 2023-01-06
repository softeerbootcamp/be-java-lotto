package kr.codesquad;

import kr.codesquad.domain.LottoNumber;
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

    public Row checkValidation(String manualRowString) {
        Row row = convertStringToRow(manualRowString);
        this.manualRowString = manualRowString;
        return row;
    }

    private Row convertStringToRow(String rowByString) {
        StringTokenizer st = new StringTokenizer(rowByString);
        List<LottoNumber> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            numbers.add(new LottoNumber(st.nextToken()));
        }
        Collections.sort(numbers);

        return Row.createRow((numbers));
    }
}
