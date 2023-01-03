package kr.codesquad.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int compare(Lotto other) {
        return (int)numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        numbers.forEach(number -> {
            sb.append(number).append(", ");
        });
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]\n");

        return sb.toString();
    }
}
