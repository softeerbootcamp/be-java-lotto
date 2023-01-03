package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    private final List<Integer> numberList;
    static final int COLUMN = 6;

    public LottoService() {
        this.numberList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
    }

    /**
     * 각 줄 발급
     */
    public List<Row> receiveRandomRows(int num) {
        List<Row> rows = new ArrayList<>();


        for (int i = 0; i < num; i++) {
            Collections.shuffle(numberList);

            Row row = new Row();
            List<Integer> tempt = numberList.subList(0, COLUMN);
            Collections.sort(tempt);
            row.addValues(tempt);
            rows.add(row);
        }
        return rows;
    }

    public void compareLotto(List<Row> rows, int[] answers, int bonusNumber) {
        int rowSize = rows.size();
        for (Row row : rows) {
            row.compare(answers, bonusNumber);
        }

    }
}
