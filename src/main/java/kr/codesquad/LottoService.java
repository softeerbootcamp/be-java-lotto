package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    static final int COLUMN = 6;
    private final LottoGenerator autoLottoGenerator;

    public LottoService() {
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    /**
     * 각 줄 발급
     */
    public List<Row> receiveRandomRows(int inputMoney) {
        return autoLottoGenerator.generateRows(inputMoney);
    }

    public void compareLotto(List<Row> rows, int[] answers, int bonusNumber) {
        for (Row row : rows) {
            row.compare(answers, bonusNumber);
        }
    }
}
