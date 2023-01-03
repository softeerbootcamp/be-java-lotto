package kr.codesquad.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    protected static final int NUMBER_SIZE=6;
    protected static final int START_NUMBER=1;
    protected static final int END_NUMBER=45;
    public static final int TICKET_PER_PRICE = 1000;
    protected List<Integer> numbers;

    public Lotto() {
        this.numbers = makeLotto();
    }


    private List<Integer> makeLotto() {
        List<Integer> generatedLotto = generateNumbers();
        return sortNumbers(generatedLotto);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numList = new ArrayList<>();
        for (int num = START_NUMBER; num <= END_NUMBER; num++) {
            numList.add(num);
        }
        Collections.shuffle(numList);
        return numList.subList(0, NUMBER_SIZE);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
