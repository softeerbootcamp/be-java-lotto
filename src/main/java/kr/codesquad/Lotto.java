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

    }
    public Map<Integer, Integer> getResult() {
        return result;
    }

    public Map<Integer, Integer> getResultIndex() {
        return resultIndex;
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
            updateResult(count);
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
    private void updateResult(int count) {
        if (count < 3) return;
        int winningMoney = resultIndex.get(count);
        result.put(winningMoney, result.get(winningMoney) + 1);
    }
    public double calculateEarningRate() {
        double earnMoney = calculateEarnedMoney();
        double spendMoney = numbers.size() * 1000;
        return (earnMoney - spendMoney) / spendMoney * 100;
    }
    private long calculateEarnedMoney() {
        long earnMoney = 0;
        for (Integer key : result.keySet()) {
            earnMoney += key * result.get(key);
        }
        return earnMoney;
    }
}
