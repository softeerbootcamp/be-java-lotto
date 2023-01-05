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

    //todo : 예외 처리 필요 (숫자 맞는지, 6개 맞는지)
    public void checkValidation(String manualRowString) {

        this.manualRowString = manualRowString;
    }

    private Row convertStringToRow(String rowByString) {
        StringTokenizer st = new StringTokenizer(rowByString);
        List<Integer> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(numbers);

        return Row.createRow(LottoNumber.convertIntegersToLottoNumbers(numbers));
    }
}
