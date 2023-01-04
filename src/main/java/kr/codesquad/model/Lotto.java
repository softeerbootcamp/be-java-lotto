package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int compare(List<Integer> otherLottoNumbers) {
        List<Integer> temp = new ArrayList<>(otherLottoNumbers);
        temp.retainAll(numbers);
        return temp.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        numbers.forEach(number -> sb.append(number).append(", "));
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");

        return sb.toString();
    }
}
