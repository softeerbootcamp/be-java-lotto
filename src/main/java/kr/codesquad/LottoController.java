package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import static kr.codesquad.LottoService.COLUMN;

public class LottoController {

    private static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private LottoService lottoService;

    private int inputMoney;
    private BufferedReader br;
    private List<Row> rows;

    public void receiveInput() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        br = new BufferedReader(new InputStreamReader(System.in));
        inputMoney = Integer.parseInt(br.readLine());
        //로또 구입 금액을 입력하면
        int num = inputMoney / SINGLE_PRICE;
        System.out.println(num + "개를 구매했습니다.");

        lottoService = new LottoService();
        rows = lottoService.receiveRandomRows(num);

        printRows(rows);
    }

    public void printRows(List<Row> rows) {
        for (Row row : rows) {
            List<Integer> values = row.getValues();
            System.out.println(values);
        }
    }


    public void inputAnswers() throws IOException {
        System.out.println("당첨 번호를 입력해 주세요.");
        int[] answers = new int[COLUMN];
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < COLUMN; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(br.readLine());
        getPrintStatistics(answers, bonusNumber);
    }

    /**
     * 당첨 통계 내기
     */
    private void getPrintStatistics(int[] answers, int bonusNumber) {
        lottoService.compareLotto(rows, answers, bonusNumber);

        Statistic statistic = new Statistic();
        for (Row row : rows) {
            statistic.calculateOutput(row);
        }
        statistic.calculateRate(inputMoney);
        statistic.printStatistics();
    }
}
