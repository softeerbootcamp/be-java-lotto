package kr.codesquad.validator;

import java.util.List;
import java.util.function.Predicate;

public class Validator<T> {

    public boolean isAllValid(List<Predicate<T>> predicates, T input) {
        return predicates.stream().allMatch(predicate -> predicate.test(input));
    }
}
