package kr.codesquad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoService {

    static final int COLUMN = 6;

    public List<Row> receiveRandomRows(int num) {

        /**
         * 각 줄 발급
         */
        //구입 금액에 해당하는 로또를 발급해야 한다.

        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Row row = new Row();
            shuffleRandomLotto(row);
            rows.add(row);
        }
        return rows;
    }

    /**
     * 유사난수로 1~45의 숫자 중 6개씩 생성된 줄만큼 입력
     * 랜덤 로또 생성
     */
    //todo: Collections.shuffle 이용해서 난수 생성으로 수정 -> subList로 가져온 다음 Collections.sort() 사용
    private void shuffleRandomLotto(Row row) {
        int min = 1;
        int max = 45;
        for (int i = 0; i < COLUMN; i++) {
            int random = (int) ((Math.random() * (max - min)) + min);
            row.addValue(random);
        }
        Collections.sort(row.getValues());
    }

    public void compareLotto(List<Row> rows, int[] answers) {
        int num = rows.size();
        for (int i = 0; i < num; i++) {
            Row row = rows.get(i);
            row.compare(answers);
        }
    }
}
