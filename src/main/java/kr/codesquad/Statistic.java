package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private double rate;
    private double output = 0;
    private final Map<Integer, Integer> scoreBoard = new HashMap<>();
    private final int[] counts;

    public Statistic(int column) {
        counts = new int[column + 1];

        //enum 처리예정
        this.scoreBoard.put(0, 0);
        this.scoreBoard.put(1, 0);
        this.scoreBoard.put(2, 0);
        this.scoreBoard.put(3, 5000);
        this.scoreBoard.put(4, 50000);
        this.scoreBoard.put(5, 1500000);
        this.scoreBoard.put(6, 2000000000);
    }

    // (수익금 - 넣은 금액 ) / 100
    public void calculateRate(int input) {
        this.rate = ((output - input) / input) * 100;
    }

    public int calculateOutput(Row row) {
        int result = row.getResult();

        Integer value = scoreBoard.get(result);
        counts[result]++;
        this.output += value;
        return value;
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 ("+scoreBoard.get(i) + "원)- " + counts[i]+"개");
        }
        System.out.println("총 수익률은 " + rate + "% 입니다.");


    }
}
