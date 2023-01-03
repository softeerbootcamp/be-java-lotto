package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;

public class Empty_lotto {
    private ArrayList<Integer> numbers;

    public Empty_lotto(ArrayList<Integer> numbers) {
        setNumbers(numbers);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public void printNumbers() {
        System.out.println(this.numbers);
    }
}
