package kr.codesquad;

import kr.codesquad.domain.Row;

import java.util.List;

public class LottoService {

    private final LottoGenerator autoLottoGenerator;

    public LottoService() {
        this.autoLottoGenerator = new AutoLottoGenerator();
    }

    public List<Row> receiveRandomRows(int inputMoney) {
        return autoLottoGenerator.generateRows(inputMoney);
    }

    public void compareLotto(List<Row> rows, int[] answers, int bonusNumber) {
        for (Row row : rows) {
            row.compare(answers, bonusNumber);
        }
    }
}
