package kr.codesquad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final int SINGLE_PRICE = 1000; //로또 한 장의 가격은 1000원이다.
    private static final int COLUMN = 6;

    public static void main(String[] args) throws IOException {
        /**
         * 로또 구입
         */
        System.out.println("구입 금액을 입력해 주세요.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        //로또 구입 금액을 입력하면
        int num = input / SINGLE_PRICE;
        System.out.println(num + "개를 구매했습니다.");

        /**
         * 랜덤 로또 발급
         */
        //구입 금액에 해당하는 로또를 발급해야 한다.

        List<Row> rows = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            Row row = new Row();
            receiveRandomLotto(row);
            rows.add(row);
        }

        /**
         * 당첨번호 입력
         */

        System.out.println("당첨 번호를 입력해 주세요.");
        int[] answers = new int[COLUMN];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < COLUMN; i++) {
            answers[i] = Integer.parseInt(st.nextToken());
        }

        /**
        * 당첨 통계 내기
        */
        System.out.println("당첨 통계\n" + "---------");

        //todo: 각 Row 별 일치 값 갯수 compare, 더 나은 방식은 없나
        for (int i = 0; i < num; i++) {
            Row row = rows.get(i);
            row.compare(answers);
        }

        /**
         * 수익률 계산
         */
        Statistic statistic = new Statistic();
        statistic.calculateRate(rows);

    }

    /**
     * 유사난수로 1~45의 숫자 중 6개씩 생성된 줄만큼 입력
     *
     */
    private static void receiveRandomLotto(Row row) {
        int min = 1;
        int max = 45;
        for (int i = 0; i < COLUMN; i++) {
            int random = (int) ((Math.random() * (max - min)) + min);
            row.addValue(random);
        }
        row.shuffle();
    }

}