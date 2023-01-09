package kr.codesquad.generator.condition;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static kr.codesquad.util.Constants.*;

public class SystemConditionGenerator implements ConditionGenerator {

    private static final String NUMBER_REGEX = "\\d*";
    private static final String LOTTO_NUMBER_REGEX = "(\\b([1-9]|[123][0-9]|4[0-5])\\b)";
    private static final Pattern LottoNumberPattern = Pattern.compile(LOTTO_NUMBER_REGEX);
    private static final Integer LOTTO_NUMBER_COUNT = 6;

    @Override
    public List<Predicate<String>> getMoneyCondition() {
        return List.of(getNumberPredict());
    }

    @Override
    public List<Predicate<String>> getManualLottoCountCondition() {
        return List.of(getNumberPredict());
    }

    @Override
    public List<Predicate<String>> getLottoNumberCondition() {
        return List.of((s) -> {
            List<Integer> numbers = LottoNumberPattern.matcher(s).results()
                    .map(mr -> Integer.parseInt(mr.group()))
                    .collect(Collectors.toList());

            return numbers.size() == LOTTO_NUMBER_COUNT && isAllInRange(numbers) && isNotDuplicated(numbers);
        });
    }

    private boolean isNotDuplicated(List<Integer> numbers) {
        return numbers.size() == numbers.stream().distinct().count();
    }

    private boolean isAllInRange(List<Integer> number) {
        return number.stream().allMatch((num) -> isInRange(num));
    }

    private boolean isInRange(int number) {
        return COUNT_LOWER_BOUND < number && number <= COUNT_UPPER_BOUND;
    }

    @Override
    public List<Predicate<String>> getBonusNumberCondition() {
        return List.of(getNumberPredict());
    }

    private Predicate<String> getNumberPredict() {
        return (s) -> s.matches(NUMBER_REGEX);
    }
}
