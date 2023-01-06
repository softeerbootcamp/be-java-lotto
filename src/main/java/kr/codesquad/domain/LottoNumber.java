package kr.codesquad.domain;

import kr.codesquad.LottoController;
import kr.codesquad.exception.NumberNotValidException;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber>{

    private final int number;

    public LottoNumber(int number) {
        this.number = isValidate(number);
    }

    public LottoNumber(String input) {
        this.number = isValidate(input);
    }

    public int isValidate(int number) {
        if (number < 1 || number > 45) {
            throw new NumberNotValidException();
        }
        return number;
    }
    public int isValidate(String input) {
        int num = Integer.parseInt(input);
        return isValidate(num);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
