package kr.codesquad.model.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Lotto {
    protected static final int NUMBER_SIZE=6;
    protected static final int START_NUMBER=1;
    protected static final int END_NUMBER=45;
    public static final int TICKET_PER_PRICE = 1000;
    protected List<Integer> numbers;



    protected abstract List<Integer> makeLotto(List<Integer> numbers) ;

    protected List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }



    public List<Integer> getNumbers() {
        return numbers;
    }

}
