package kr.codesquad;

public class Statistic {
    private double rate;
    private double output = 0;
    private final int[] counts;

    public Statistic(int column) {
        counts = new int[column + 1];
    }

    // (수익금 - 넣은 금액 ) / 100
    public void calculateRate(int input) {
        this.rate = ((output - input) / input) * 100;
    }

    public void calculateOutput(Row row) {
        int match = row.getMatch();

        int money = Rank.getMoney(match);
        counts[match]++;
        this.output += money;
    }

    public void printStatistics() {
        System.out.println("당첨 통계\n" + "---------");

        for (int i = 3; i <= 6; i++) {
            System.out.println(i + "개 일치 (" + Rank.getMoney(i) + "원)- " + counts[i] + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", rate) + "% 입니다.");


    }
}
