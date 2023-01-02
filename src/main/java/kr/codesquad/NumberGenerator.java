package kr.codesquad;

import java.sql.Array;
import java.util.*;

public class NumberGenerator {
    private List<Integer> kindOfNumbers;
    
    public NumberGenerator() {
        kindOfNumbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            kindOfNumbers.add(i);
        }
    }
    public List<Integer> numberGenerate() {
        Collections.shuffle(kindOfNumbers);
        List<Integer> list = new ArrayList<>(kindOfNumbers.subList(0, 6));
        return list;
    }
}
