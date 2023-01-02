package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<List<Integer>> numbers;
    private NumberGenerator numberGenerator;

    Lotto(NumberGenerator numberGenerator) {
        this.numbers = new ArrayList<>();
        this.numberGenerator = numberGenerator;
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
