package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import static kr.codesquad.LottoService.COLUMN;

public class LottoController {

    private static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private int inputMoney;
    private LottoService lottoService;
    private BufferedReader br;
    private int num;
    private List<Row> rows;
    private int[] answers;


    public void start() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        br = new BufferedReader(new InputStreamReader(System.in));
        inputMoney = Integer.parseInt(br.readLine());
    }

    public List<Row> receiveInput() {
        //로또 구입 금액을 입력하면
        num = inputMoney / SINGLE_PRICE;
        System.out.println(num + "개를 구매했습니다.");

        lottoService = new LottoService();
        rows = lottoService.receiveRandomRows(num);
        return rows;
    }

    public void printRows(List<Row> rows) {
        for (Row row : rows) {
            List<Integer> values = row.getValues();
            System.out.println(values);
        }
    }

    public void inputAnswers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        answers = new int[COLUMN];
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < COLUMN; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        getPrintStatistics();
    }

    /**
     * 당첨 통계 내기
     */
    private void getPrintStatistics() {
        System.out.println("당첨 통계\n" + "---------");
        lottoService.compareLotto(rows, answers);

        Statistic statistic = new Statistic(COLUMN);
        for (Row row : rows) {
            statistic.calculateOutput(row);
        }
        statistic.calculateRate(inputMoney);
        statistic.printStatistics();
    }
}
