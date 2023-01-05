package kr.codesquad.domain;

import kr.codesquad.exception.NumberNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        this.number = isValidate(number);
    }

    public int isValidate(int number) {
        if (number < 1 || number > 45) {
            throw new NumberNotValidException();
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public static List<LottoNumber> convertIntegersToLottoNumbers(List<Integer> integerList) {
        return integerList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
