package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private List<List<Integer>> numbers;
    private NumberGenerator numberGenerator;
    private List<Integer> winningNumbers;
    private int bonusBall;
    private Map<Rank, Integer> score;

    Lotto(NumberGenerator numberGenerator) {
        this.numbers = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        bonusBall = 0;
        score = new HashMap<>();
        score.put(Rank.FIRST, 0);
        score.put(Rank.SECOND, 0);
        score.put(Rank.THIRD, 0);
        score.put(Rank.FORTH, 0);
        score.put(Rank.FIFTH, 0);
    }
    public Map<Rank, Integer> getScore() {
        return score;
    }

    public long calculateCount(long money) {
        return money / 1000;
    }
    public List<List<Integer>> generateLotto(long count) {
        for (int i = 0; i < count; i++) {
            numbers.add(numberGenerator.numberGenerate());
        }
        return numbers;
    }
    public void setWinningNumbers(List<Integer> list) {
        winningNumbers = list;
    }
    public void calculateTotalResult() {
        for (int i = 0; i < numbers.size(); i++) {
            Rank rank = calculateRank(i);
            updateScore(rank);
        }
    }
    private Rank calculateRank(int index) {
        List<Integer> lotto = numbers.get(index);
        int count = containsNumberCount(lotto);
        boolean bonus = isContainsBonusBall(lotto);
        return Rank.getRankByScoreAndBonus(count, bonus);
    }
    private int containsNumberCount(List<Integer> lotto) {
        int count = 0;
        for (Integer winningNumber : winningNumbers) {
            count += compareSame(lotto, winningNumber);
        }
        return count;
    }
    private int compareSame(List<Integer> lotto, int winningNumber) {
        if (lotto.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
    private void updateScore(Rank rank) {
        if (rank == null) return;
        score.put(rank, score.get(rank) + 1);
    }
    private boolean isContainsBonusBall(List<Integer> lotto) {
        return lotto.contains(bonusBall);
    }
    public double calculateEarningRate() {
        double earnMoney = calculateEarnedMoney();
        double spendMoney = numbers.size() * 1000;
        return (earnMoney - spendMoney) / spendMoney * 100;
    }
    private long calculateEarnedMoney() {
        long earnMoney = 0;
        for (Rank rank : Rank.values()) {
            earnMoney += rank.getMoney() * score.get(rank);
        }
        return earnMoney;
    }
    public void updateBonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }
}
