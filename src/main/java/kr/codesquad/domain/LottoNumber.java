package kr.codesquad.domain;

import kr.codesquad.exception.NumberNotValidException;
import kr.codesquad.exception.DuplicateLottoNumberException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    public static List<LottoNumber> convertIntegersToLottoNumbers(List<Integer> integerList) {

        lottoNumbersDuplicateCheck(integerList);

        return integerList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static void lottoNumbersDuplicateCheck(List<Integer> numList) {
        Set<Integer> numSet = new HashSet<>(numList);

        if(numSet.size()!= numList.size()){
            throw new DuplicateLottoNumberException();
        }
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
