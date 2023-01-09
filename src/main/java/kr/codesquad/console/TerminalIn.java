package kr.codesquad.console;

import kr.codesquad.enums.ErrorMessage;
import kr.codesquad.generator.condition.ConditionGeneratorProvider;
import kr.codesquad.generator.condition.SystemConditionGenerator;
import kr.codesquad.validator.Validator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TerminalIn implements Input {

    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static final Validator validator = new Validator();
    private final ConditionGeneratorProvider cgp;

    public TerminalIn(ConditionGeneratorProvider cgp) {
        this.cgp = cgp;
    }

    @Override
    public Integer readInteger() {
        String input = scanner.next();
        if (validator.isAllValid(cgp.get(SystemConditionGenerator.class).getMoneyCondition(), input)) {
            return Integer.parseInt(input);
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
    }

    @Override
    public List<Integer> readLottoNumbers() {
        String input = scanner.next();
        if (validator.isAllValid(cgp.get(SystemConditionGenerator.class).getLottoNumberCondition(), input)) {
            return parseToLottoNumber(input);
        }

        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }

    private List<Integer> parseToLottoNumber(String input) {
        return Arrays.asList(scanner.next().split(",")).stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
