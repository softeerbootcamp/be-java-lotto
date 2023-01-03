package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

import static kr.codesquad.LottoController.SINGLE_PRICE;
import static kr.codesquad.LottoService.COLUMN;

public class LottoView {
    private final LottoController lottoController;

    public LottoView() {
        this.lottoController = new LottoController();
    }

    public void home() throws IOException {
        System.out.println("구입 금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputMoney = Integer.parseInt(br.readLine());
        List<Row> rows = lottoController.receiveInput(inputMoney);

        int num = inputMoney / SINGLE_PRICE;
        System.out.println(num + "개를 구매했습니다.");
        printRows(rows);
    }

    public void printRows(List<Row> rows) {
        for (Row row : rows) {
            List<Integer> values = row.getValues();
            System.out.println(values);
        }
    }

    public void getAnswers() throws IOException{
        System.out.println("당첨 번호를 입력해 주세요.");
        int[] answers = new int[COLUMN];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < COLUMN; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(br.readLine());
        lottoController.getPrintStatistics(answers, bonusNumber);
    }
}
