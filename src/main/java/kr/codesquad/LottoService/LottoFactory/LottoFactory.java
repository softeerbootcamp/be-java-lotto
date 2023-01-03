package kr.codesquad.LottoService.LottoFactory;

import kr.codesquad.LottoService.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory{
    private List<Integer> numbers;
    private int LOTTO_SIZE = 6;

    public LottoFactory() {
        numbers = new ArrayList<>();
        for (int number = 1; number <= 45; number++) {
            numbers.add(number);
        }
    }

    public Lotto generateLotto(String type) {
        if (type.equals("automatic")) {
            Collections.shuffle(numbers);
            return new Lotto(new ArrayList<>(numbers.subList(0, LOTTO_SIZE)));
        }
        if (type.equals("manual")) {
            return null;
        }
        throw new IllegalArgumentException("유효하지 않은 로또 종류입니다");
    }
}
