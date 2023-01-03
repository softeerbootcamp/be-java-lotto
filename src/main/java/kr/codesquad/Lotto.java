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
}
