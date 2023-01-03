package kr.codesquad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private List<List<Integer>> numbers;
    private NumberGenerator numberGenerator;
    private List<Integer> winningNumbers;
    private Map<Integer, Integer> result;
    private Map<Integer, Integer> resultIndex;
    private int bonusBall;
    private Map<Rank, Integer> score;

    Lotto(NumberGenerator numberGenerator) {
        this.numbers = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        result = new HashMap<>();
        resultIndex = new HashMap<>();
        resultIndex.put(3, 5000);
        resultIndex.put(4, 50000);
        resultIndex.put(5, 1500000);
        resultIndex.put(6, 2000000000);

        result.put(5000, 0);
        result.put(50000, 0);
        result.put(1500000, 0);
        result.put(2000000000, 0);
        bonusBall = 0;
        score = new HashMap<>();
        score.put(Rank.FIRST, 0);
        score.put(Rank.SECOND, 0);
        score.put(Rank.THIRD, 0);
        score.put(Rank.FORTH, 0);
        score.put(Rank.FIFTH, 0);
    }
    public Map<Integer, Integer> getResult() {
        return result;
    }

    public Map<Integer, Integer> getResultIndex() {
        return resultIndex;
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
            int count = containsNumberCount(i);
            updateScore(count);
        }
    }
    private int containsNumberCount(int index) {
        List<Integer> lotto = numbers.get(index);
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
    private void updateScore(int count) {
        if (count < 3) return;
        Rank rank = Rank.getRankByScore(count);
        score.put(rank, score.get(rank) + 1);
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
