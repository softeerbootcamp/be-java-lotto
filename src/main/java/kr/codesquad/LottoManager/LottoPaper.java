package kr.codesquad.LottoManager;

import java.util.Collections;
import java.util.List;

public class LottoPaper {
    private List<Integer> numbers;

    public LottoPaper(List<Integer> numbers) {
        setNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void setNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }
}
