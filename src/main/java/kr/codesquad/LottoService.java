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

    /**
     * 유사난수로 1~45의 숫자 중 6개씩 생성된 줄만큼 입력
     * 랜덤 로또 생성
     */
    public void compareLotto(List<Row> rows, int[] answers) {
        int num = rows.size();
        for (int i = 0; i < num; i++) {
            Row row = rows.get(i);
            row.compare(answers);
        }
    }
}
