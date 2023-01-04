package kr.codesquad;

import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;

import java.util.List;

public class LottoController {

    public static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private final LottoService lottoService;

    private int inputMoney;
    private List<Row> rows;

    public LottoController() {
        this.lottoService = new LottoService();
    }


    public List<Row> receiveInput(int inputMoney) {
        //로또 구입 금액을 입력하면
        this.inputMoney = inputMoney;
        rows = lottoService.receiveRandomRows(inputMoney);

        return rows;
    }

    /**
     * 당첨 통계 내기
     */
    public Statistic getPrintStatistics(int[] answers, int bonusNumber) {
        lottoService.compareLotto(rows, answers, bonusNumber);

        Statistic statistic = new Statistic();
        for (Row row : rows) {
            statistic.calculateOutput(row);
        }
        statistic.calculateRate(inputMoney);
        return statistic;
    }
}
