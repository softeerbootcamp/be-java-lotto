package kr.codesquad;

import java.util.*;

import static kr.codesquad.Prize.*;

public class LottoResult {

    private final WinningLotto winningLotto;  // 지난 주 로또번호
    private final Money money;

    private Map<Prize, Integer> matches;

    private List<Lotto> lottos;

    public LottoResult(final Lotto winningLotto, List<Lotto> lottos, Money money) {
        this.winningLotto = (WinningLotto) winningLotto;
        this.lottos = lottos;
        this.money = money;

        this.matches = new HashMap<>();
        for(Prize prize : Prize.values()) {
            matches.put(prize, 0);
        }
    }

    public LottoResult(final LottoProcedure procedure) {
        this.winningLotto = (WinningLotto) procedure.getWinningLotto();
        this.lottos = procedure.getLottos();
        this.money = procedure.getMoney();

        this.matches = new HashMap<>();
        for(Prize prize : Prize.values()) {
            matches.put(prize, 0);
        }
    }

    public void showResults() {
        matchLottos();
        printStatistics();
    }

    public void matchLottos() {

        for(Lotto lotto: this.lottos) {

            final Prize result = matchLotto(lotto);  // 실제 당첨번호와 생성된 로또 번호 1대1 매칭 통해 대응되는 수의 쌍 개수 반환
            this.matches.put(result, this.matches.get(result) + 1);
        }
    }

    private Prize matchLotto(Lotto lotto) {  // 구매한 로또와 당첨 번호 비교해 등수 반환
        int matchCount = 0;
        boolean matchBonus = false;  // 보너스 번호 매칭 하는지

        // 정렬된 로또 번호 기준으로, 당첨 로또 번호와 비교
        for(Integer num : lotto.getLotto()) {
            matchCount += this.winningLotto.contains(num) ? 1:0;
        }

        // 보너스 조건 - 5개가 맞고 보너스 번호도 맞을 때 -> 2등
        if(matchCount == 5 && lotto.contains(this.winningLotto.bonus)) {
            matchBonus = true;
        }

        return Prize.valueOf(matchCount, matchBonus);
    }

    protected void printStatistics() {
        long prizeTotal = calculatePrizeTotal();  // 상금 총액 계산

        this.matches.remove(Prize.MISS);  // Miss(3개 미만 동일)인 경우 제외하고 출력

        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (%d)- %d개%n", FIFTH.getWinningMoney(), this.matches.get(FIFTH));
        System.out.printf("4개 일치 (%d)- %d개%n", FOURTH.getWinningMoney(), this.matches.get(FOURTH));
        System.out.printf("5개 일치 (%d)- %d개%n", THIRD.getWinningMoney(), this.matches.get(THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(%d) - %d개%n", SECOND.getWinningMoney(), this.matches.get(SECOND));
        System.out.printf("6개 일치 (%d)- %d개%n", FIRST.getWinningMoney(), this.matches.get(FIRST));

        double returnRate = this.money.returnRate(prizeTotal);  // 수익률 계산

        System.out.println("총 수익률은 " + String.format("%.2f", returnRate) + "%입니다.");
    }

    protected long calculatePrizeTotal() {
        long prizeTotal = 0;

        for(Map.Entry<Prize, Integer> prize : this.matches.entrySet()) {
            final Prize result = prize.getKey();
            final int winningCount = prize.getValue();

            prizeTotal += result.calculatePrize(winningCount); // 상금 총액
        }
        return prizeTotal;
    }
}
